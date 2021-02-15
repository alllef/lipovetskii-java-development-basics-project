

public class SubscriberController {

    private SubscriberModel model = new SubscriberModel();
    private SubscriberView view = new SubscriberView();

    public void start() {

        boolean isToContinue;
        String input;

        view.println(SubscriberView.STARTER_OUTPUT);

        do {
            input = InputReader.getInput();
        } while (!InputValidator.validate(input));

        model.generateSubscribers(Integer.parseInt(input));
        view.printSubscriberArr(model.getSubscriberArr());

        do {
            view.println(SubscriberView.MENU_OUTPUT);

            do {
                input = InputReader.getInput();
            } while (!InputValidator.validate(input));

            isToContinue = makeDecision(Integer.parseInt(input));
        } while (isToContinue);

    }

    private boolean makeDecision(int decision) {

        switch (decision) {

            case 1:
                String input;

                do {
                    input = InputReader.getInput();
                } while (!InputValidator.validate(input));

                view.printSubscriberArr(model.getSubscribersByInnerCitySpeakingTime(Integer.parseInt(input)));
                break;

            case 2:
                view.printSubscriberArr(model.getSubscribersUsedOuterCityCommunication());
                break;

            case 3:
                return false;

            default:
                view.println("Wrong input");
                break;
        }

        return true;
    }

}
