package validation;

public class InputValidator {


    private static void checkIsNotPositive(int input) throws NotPositiveNumberException {
        if (input < 0) throw new NotPositiveNumberException();
    }

    private static void isInRange(int number, int leftBound, int rightBound) throws OutOfRangeException {
        if (number < leftBound || number > rightBound) throw new OutOfRangeException();
    }

    public static int validate(int input, int leftBound, int rightBound) {

        int isValidated = 3;


        try {
            checkIsNotPositive(input);
            isInRange(input, leftBound, rightBound);
        } catch (NotPositiveNumberException e) {
            isValidated = 1;
            //System.out.println("This is not positive type number. Please, write positive number");
        } catch (OutOfRangeException e) {
            isValidated = 2;
            //System.out.println("This number is out of range. Write number in range");
        }


        return isValidated;
    }

}
