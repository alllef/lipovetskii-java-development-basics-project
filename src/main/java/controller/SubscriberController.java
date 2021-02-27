package controller;

import entity.Subscriber;
import model.SubscriberModel;
import validation.InputValidator;
import view.SubscriberView;
import warehouse.DataFiles;
import warehouse.JSONParser;

public class SubscriberController {

    private SubscriberModel model = new SubscriberModel(15);
    private SubscriberView view = new SubscriberView();
    private JSONParser parser = new JSONParser();

    public SubscriberController() {
        start();
    }

    public void start() {

        Subscriber[] tmp = parser.loadSubscribers(DataFiles.BASIC_DATA_FILE);
        if (tmp.length > 0) model.setSubscriberArr(tmp);

        boolean isToContinue;
        int input;

        view.println(SubscriberView.STARTER_OUTPUT);
        view.printSubscriberArr(model.getSubscriberArr());

        do {
            view.println(SubscriberView.MENU_OUTPUT);

            do {
                input = InputReader.getIntegerInput();
            } while (InputValidator.validate(input, 1, 3)==Integer.MAX_VALUE);

            isToContinue = makeDecision(input);
        } while (isToContinue);

        parser.saveSubscribers(DataFiles.BASIC_DATA_FILE, model.getSubscriberArr());
    }

    private boolean makeDecision(int decision) {

        switch (decision) {

            case 1:
                int input;

                do {
                    input = InputReader.getIntegerInput();
                } while (InputValidator.validate(input, 0, Integer.MAX_VALUE)==Integer.MAX_VALUE);

                printAndSaveArr(model.getSubscribersByInnerCitySpeakingTime(input));
                break;

            case 2:
                printAndSaveArr(model.getSubscribersUsedOuterCityCommunication());
                break;

            case 3:
                return false;

            default:
                view.println("Wrong input");
                break;
        }

        return true;
    }

    private void printAndSaveArr(Subscriber[] arr) {

        view.printSubscriberArr(arr);

        if (arr.length > 0) {
            view.println(SubscriberView.SAVE_MENU_OUTPUT);

            String inputResult = InputReader.getStringInput();
            if (inputResult.equals("yes")) parser.saveSubscribers(DataFiles.TEMPORARY_DATA_FILE, arr);
        }

    }

    private boolean printValidationResult(int validation) {
        boolean validationResult = false;
        switch (validation) {
            case 1:
                view.println("This is not positive type number. Please, write positive number");
                break;
            case 2:
                view.println("This number is out of range. Write number in range");
                break;
            case 3:
                validationResult = true;
                break;
            default:
                break;
        }
        return validationResult;
    }
}
