package com.company;

public class Person {
    private int age;
    private String name;
    private double salary;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person(String name, int age, double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
