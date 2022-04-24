package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    private static void metadata() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        // entry point of reflection API
	    Class<?> cl = Class.forName("com.company.Person");

        System.out.println("Getting constructors of a class.........");
        Constructor<?>[] constructors = cl.getConstructors();
        System.out.println("Constructors are: " + Arrays.toString(constructors));

        System.out.println("Getting methods(even super class) of a class.........");
        Method[] methods = cl.getMethods();
        System.out.println("Methods are: " + Arrays.toString(methods));

        Method[] declaredMethods = cl.getDeclaredMethods();
        System.out.println("Declared methods are: " + Arrays.toString(declaredMethods));


        System.out.println("Getting fields of a class.........");
        Field[] fields = cl.getFields();
        System.out.println("Fields are: " + Arrays.toString(fields));

        Field[] declaredFields = cl.getDeclaredFields();
        System.out.println("Fields are: " + Arrays.toString(declaredFields));
    }
}
