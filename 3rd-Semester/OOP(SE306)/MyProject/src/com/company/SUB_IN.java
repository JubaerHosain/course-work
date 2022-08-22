package com.company;

public class SUB_IN implements IN{
    @Override
    public void get() {
        int a = IN.a;
        // though interface has no constructor
        // but is can instantiate its child object
        // allowing polymorphism
        IN obj = new SUB_IN();
    }
}
