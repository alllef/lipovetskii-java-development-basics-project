

public class SubscriberController {

    private SubscriberModel model = new SubscriberModel();
    private SubscriberView view = new SubscriberView();

    public void start() {

        boolean isToContinue;

        view.println(SubscriberView.STARTER_OUTPUT);
        model.generateSubscribers(InputReader.getInput());
        view.printSubscriberArr(model.getSubscriberArr());

        do {
            view.println(SubscriberView.MENU_OUTPUT);
            isToContinue = makeDecision(InputReader.getInput());
        } while (isToContinue);

    }

   private boolean makeDecision(int decision) {

        switch (decision) {

            case 1:
                view.printSubscriberArr(model.getSubscribersByInnerCitySpeakingTime(InputReader.getInput()));
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
