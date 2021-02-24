package controller;

import entity.Subscriber;
import model.SubscriberModel;
import validation.InputValidator;
import view.SubscriberView;
import warehouse.WareHouseSerializer;
import warehouse.WareHouseStringSaver;

public class SubscriberController {

    private SubscriberModel model = new SubscriberModel(15);
    private SubscriberView view = new SubscriberView();
    private WareHouseSerializer<Subscriber[]> serializer = new WareHouseSerializer<>("SerializedObjects.ser");
    private WareHouseStringSaver stringSaver = new WareHouseStringSaver();

   public SubscriberController(){
        start();
    }

    public void start() {

        Subscriber[] tmp = serializer.deserialize();

        if (tmp != null) model.setSubscriberArr(tmp);

        boolean isToContinue;
        String input;

        view.println(SubscriberView.STARTER_OUTPUT);
        view.printSubscriberArr(model.getSubscriberArr());

        do {
            view.println(SubscriberView.MENU_OUTPUT);

            do {
                input = InputReader.getInput();
            } while (!InputValidator.validate(input, 1, 3));

            isToContinue = makeDecision(Integer.parseInt(input));
        } while (isToContinue);

        serializer.serialize(model.getSubscriberArr());
    }

    private boolean makeDecision(int decision) {

        switch (decision) {

            case 1:
                String input;

                do {
                    input = InputReader.getInput();
                } while (!InputValidator.validate(input, 0, Integer.MAX_VALUE));

                printAndSaveArr(model.getSubscribersByInnerCitySpeakingTime(Integer.parseInt(input)));
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

    private void printAndSaveArr(Subscriber[]arr){

        view.printSubscriberArr(arr);
        view.println(SubscriberView.SAVE_MENU_OUTPUT);

        String inputResult = InputReader.getInput();
        if (inputResult.equals("yes")) stringSaver.saveStringSubscribers(arr,"test");

    }

}
