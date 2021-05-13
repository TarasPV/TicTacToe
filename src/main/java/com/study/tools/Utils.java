package com.study.tools;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    public static String getEnteredStringData(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        return sc.nextLine();
    }

    public static int getEnteredIntData(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter only numbers");
            System.out.print(text);
            sc.next();
        }

        return sc.nextInt();
    }

    public static boolean isCorrectValue(int value) {
        if (value < 0 || value > Constants.COUNT_BOARD_FIELDS) {
            System.out.println("Please enter only numbers from 1 to " + Constants.COUNT_BOARD_FIELDS);
            return false;
        }
        return true;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(Constants.MAX_RANDOM_NUMBER);
    }
}
