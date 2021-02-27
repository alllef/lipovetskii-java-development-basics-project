package controller;

import validation.NotIntegerException;

import java.util.Scanner;

public class InputReader {

    public static Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput() {
        String input = scanner.nextLine();
        try {
            checkIsInteger(input);
        }catch (Exception NotIntegerException){
            return Integer.MAX_VALUE;
        }
        return Integer.parseInt(input);
    }

    public static String getStringInput() {
        return scanner.nextLine();
    }

    private static void checkIsInteger(String input) throws NotIntegerException {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }
}
