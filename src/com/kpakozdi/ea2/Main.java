package com.kpakozdi.ea2;

import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String foo = "Aa";
        int fooHashCode = foo.hashCode();

        String bar = "BB";
        int barHashCode = bar.hashCode();

        System.out.println(fooHashCode);
        System.out.println(barHashCode);
        System.out.println("CC".hashCode());
    }

    private static boolean isBracketsBalanced(String input) {
        Stack<Character> s = new Stack<>();
        Set<Character> openBrackets = Set.of('{', '[', '(');
        Set<Character> closedBrackets = Set.of('}', ']', ')');

        for (Character c : input.toCharArray()) {
            if (openBrackets.contains(c)) {
                // 1. nyitott zárójelet találunk
                s.push(c);
            } else if (closedBrackets.contains(c)) {
                // 2. csukott zárójelet találunk
                Character top = s.pop();
                Character pair = getBracketPair(c);
                if (!top.equals(pair)) {
                    return false;
                }
            }
        }

        return s.empty();
    }

    public static Character getBracketPair(Character bracket) {
        switch (bracket) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                throw new IllegalArgumentException();
        }
    }
}