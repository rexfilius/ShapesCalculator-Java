
package com.github.rexfilius.shapescalculatorjava.screen;

import java.util.Scanner;

public class Screen {

    public static final String INVALID_DATA = "\nYOU ENTERED INVALID DATA\n";
    public static final String INVALID_CASING = "\nCHECK YOUR CASING/WORDS. TYPE CORRECTLY\n";

    Scanner input = new Scanner(System.in);
    String select = null;
    String parameter = null;

    public String firstMenu() {
        String firstMessage =
                """
                        This Application Calculates The Area And Perimeter Of 2-Dimensional Shapes
                        List of Shapes: [Triangle, Circle, Square, Rectangle, Parallelogram, Trapezium]
                        Select a Shape: [Type it in]""";
        System.out.println(firstMessage);
        select = input.nextLine();
        checkFirstMenu();
        return select;
    }

    private void checkFirstMenu() {
        while (!(select.equals("Circle") || select.equals("Triangle")
                || select.equals("Square") || select.equals("Rectangle")
                || select.equals("Parallelogram") || select.equals("Trapezium"))) {
            System.out.println(INVALID_CASING);
            firstMenu();
        }
    }

    public String secondMenu() {
        System.out.println("What do you want to calculate: Area? or Perimeter? [Type it in]");
        parameter = input.nextLine();
        checkSecondMenu();
        return parameter;
    }

    private void checkSecondMenu() {
        while (!(parameter.equals("Area") || parameter.equals("Perimeter"))) {
            System.out.println(INVALID_CASING);
            secondMenu();
        }
    }

    public static void thirdMenu() {
        System.out.println("\nPress 1 to go back to MENU\nPress 2 to END");
        try {
            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();
            switch (userInput) {
                case 1 -> Calculator.run();
                case 2 -> System.out.println("program is ending...");
                default -> {
                    System.out.println("Invalid Input");
                    Screen.thirdMenu();
                }
            }
        } catch (Exception e) {
            System.out.println("\nInvalid Input\n");
            Screen.thirdMenu();
        }
    }

}
