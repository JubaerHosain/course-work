package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Student());
        list.add(new Teacher());
        list.add(new Person());

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof Student)
                System.out.println("Stuent");
            else if(list.get(i) instanceof Teacher)
                System.out.println("Teacher");
            else if(list.get(i) instanceof Person)
                System.out.println("Person");
        }
    }
}
