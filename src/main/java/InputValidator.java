public class InputValidator {


    private static void checkIsNotPositive(int input) throws NotPositiveNumberException {
        if (input < 0) throw new NotPositiveNumberException();
    }

    private static void checkIsInteger(String input) throws NotIntegerException {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }

    private static void isInRange(int number, int leftBound, int rightBound) throws OutOfRangeException {
        if (number < leftBound || number > rightBound) throw new OutOfRangeException();
    }

    public static boolean validate(String input) {

        boolean isValidated = false;
        int inputNumber;

        try {
            checkIsInteger(input);
            inputNumber = Integer.parseInt(input);

            checkIsNotPositive(inputNumber);
            isInRange(inputNumber, 1, 30);

            isValidated = true;
        } catch (NotIntegerException e) {
            System.out.println("It is not number of integer type. Please, write integer number");
        } catch (NotPositiveNumberException e) {
            System.out.println("This is not positive type number. Please, write positive number");
        } catch (OutOfRangeException e) {
            System.out.println("This number is out of range. Write number in range from that to that");
        }


        return isValidated;
    }

}
