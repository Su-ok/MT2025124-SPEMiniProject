package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class ScientificCalculator {
    private static final Logger logger = Logger.getLogger(ScientificCalculator.class.getName());

    static {
        try {
            // Creates the log file for the project
            FileHandler fh = new FileHandler("Calculator.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            System.err.println("Error initializing log file.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Application Begins.");
        int choice;

        do {
            System.out.println("\n--- Scientific Calculator ---");
            System.out.println("1. Square root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double a = scanner.nextDouble();
                    if(a<0) {
                        System.out.println("Error: Input is negative.");
                        logger.warning("Square root error: Negative input " + a);
                    }
                    else {
                        System.out.println("Result: " + Math.sqrt(a));
                        logger.info("Square Root of "+a+" = "+Math.sqrt(a));
                    }
                    break;
                case 2:
                    System.out.print("Enter integer: ");
                    int n = scanner.nextInt();
                    if(n<0) {
                        System.out.println("Error: Input is negative.");
                        logger.warning("Factorial error: Negative input " + n);
                    } else {
                        System.out.println("Result: " + factorial(n));
                        logger.info("Factorial of "+n+" = "+Math.sqrt(n));
                    }
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double b = scanner.nextDouble();
                    if(b<=0) {
                        System.out.println("Error: Input must be greater than 0.");
                        logger.warning("Log error: Non-positive input " + b);
                    }
                    else {
                        System.out.println("Result: " + Math.log(b));
                        logger.info("Natural Log of "+b+" = "+Math.log(b));
                    }
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(base, exp));
                    logger.info("Power "+base+"^"+exp+" = "+Math.pow(base, exp));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    logger.info("User exited.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        scanner.close();
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}