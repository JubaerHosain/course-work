package com.company;

import java.io.IOException;

interface Show {
    public void display();
}

class AA {
    Show s;
    public AA(Show s) {
        //s is loosely coupled to A
        this.s = s;
    }

    public void display() {
        System.out.println("A");
        s.display();
    }
}

class BB implements Show {
    public BB(){}
    public void display() {
        System.out.println("B");
    }
}

class CC implements Show {
    public CC(){}
    public void display() {
        System.out.println("C");
    }
}


public class LooseCoupling {
    public static void main(String args[]) throws IOException {
        Show b = new BB();
        Show c = new CC();

        AA a = new AA(b);
        //a.display() will print A and B
        a.display();

        AA a1 = new AA(c);
        //a.display() will print A and C
        a1.display();
    }
}

// Using interfaces, we achieve the loose coupling by injecting the dependency.


