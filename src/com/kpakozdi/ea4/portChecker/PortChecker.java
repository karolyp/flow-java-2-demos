package com.kpakozdi.ea4.portChecker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PortChecker {
    public static void main(String[] args) {
        String host = "localhost";
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<PortCheckerCallable> portCheckerCallables =
                IntStream.range(2000, 10001)
                .mapToObj(port -> new PortCheckerCallable(host, port))
                .collect(Collectors.toList());

        try {
            long openedPorts = executorService.invokeAll(portCheckerCallables)
                    .stream()
                    .filter(c -> {
                        try {
                            return c.get();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    })
                    .count();

            System.out.println(openedPorts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class PortCheckerCallable implements Callable<Boolean> {
    private String host;
    private int port;

    public PortCheckerCallable(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Boolean call() {
        try {
            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(host, port);
            socket.connect(address, 5);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

