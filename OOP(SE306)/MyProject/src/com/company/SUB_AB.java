package com.company;

public class SUB_AB extends AB{
    public SUB_AB() {

    }

    public SUB_AB(String NAME) {
        super(NAME);
    }

    @Override
    public void abcd() {

    }

    public static void main(String[] args) {
        AB obj = new SUB_AB("s");
    }
}
