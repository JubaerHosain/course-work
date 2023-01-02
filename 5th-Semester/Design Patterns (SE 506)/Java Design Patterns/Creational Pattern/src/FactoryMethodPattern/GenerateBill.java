package FactoryMethodPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GenerateBill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PlanFactory planFactory = new PlanFactory();

        System.out.print("Enter the name of plan: ");
        String planName = br.readLine();

        System.out.print("Enter the number of units: ");
        int units = Integer.parseInt(br.readLine());

        Plan plan = planFactory.getPlan(planName);

        plan.getRate();

        System.out.print("Bill amount for " + planName + " of " + units +
                " units is: " + plan.calculateBill(units));
    }
}