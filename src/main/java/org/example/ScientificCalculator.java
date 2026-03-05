package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("Result: " + Math.sqrt(a));
                    break;
                case 2:
                    System.out.print("Enter integer: ");
                    int n = scanner.nextInt();
                    System.out.println("Result: " + factorial(n));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + Math.log(b));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double exp = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(base, exp));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        scanner.close();
    }

    public static long factorial(int n) {
        if (n < 0) return 0;
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}