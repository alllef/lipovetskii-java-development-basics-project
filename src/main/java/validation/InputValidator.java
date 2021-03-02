package validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        } catch (OutOfRangeException e) {
            isValidated = 2;

        }


        return isValidated;
    }

}
