package com.kpakozdi.ea2;

import java.util.Objects;

public class Comparing {
    public static void main(String[] args) {
        // javaban 2-féleképp tudok összehasonlítani:
        // referencia szerint
        // equals() meghívásával
        Dog dog1 = new Dog("Abc123", Breed.VIZSLA);
        Dog dog2 = new Dog("Abc123", Breed.VIZSLA);
    }
}

class Dog implements Comparable<Dog> {
    private String name;
    private Breed breed;

    public Dog(String name, Breed breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name) && breed == dog.breed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed=" + breed +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        return this.name.compareTo(o.getName());
    }
}

enum Breed {
    VIZSLA, LABRADOR
}