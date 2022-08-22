package com.company;

import java.io.*;

class Bank {
    private String name;

    Bank(String name) {
        this.name = name;
    }

    public String getBankName() {
        return this.name;
    }
}

class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String getEmployeeName() {
        return this.name;
    }
}

public class Association {

    public static void main(String[] args) {
        Bank bank = new Bank("ICICI");
        Employee emp = new Employee("Jubaer");

        System.out.println(emp.getEmployeeName() + " is employee of " + bank.getBankName());
    }
}






// Definition:
// see the Association.png in root folder
// Association is a relation between two separate classes which establishes through their Objects


//Output Explanation: In the above example, two separate classes Bank and Employee are associated
// through their Objects. Bank can have many employees, So it is a one-to-many relationship.






