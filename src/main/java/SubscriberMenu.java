import java.util.Arrays;
import java.util.Scanner;

public class SubscriberMenu {

    void startMenu() {

        System.out.println("Enter the number of subscribers that you want to generate");

        Scanner scanner = new Scanner(System.in);
        Object[] tmpSubscribers;
        int numberToGenerate = scanner.nextInt();
        SubscriberGenerator subscribers = new SubscriberGenerator(numberToGenerate);

        boolean userWantsToContinue = true;

        System.out.println(convertSubscriberArrToString(subscribers.getSubscriberArr()));

        while (userWantsToContinue) {

            System.out.println("Enter 1, if you want to know subscribers, that spoken more minutes in inner city lines, than entered by you number");
            System.out.println("Enter 2, if you want to know subscribers, that used outer city lines");
            System.out.println("Enter 3, if you want to exit");

            switch (scanner.nextInt()) {

                case 1:
                    System.out.println("Enter the minimal number of speaking in inner city lines of subscriber");
                    tmpSubscribers =  subscribers.getSubscribersByInnerCitySpeakingTime(scanner.nextInt());
                    System.out.println(convertSubscriberArrToString(tmpSubscribers));
                    break;

                case 2:
                    tmpSubscribers = subscribers.getSubscribersUsedOuterCityCommunication();
                    System.out.println(convertSubscriberArrToString(tmpSubscribers));
                    break;

                case 3:
                    userWantsToContinue = false;
                    scanner.close();
                    break;

                default:
                    System.out.println("Wrong input");

                    break;
            }
        }

    }

    String convertSubscriberArrToString(Object[] subscribers) {

        String subscribersString = "";

        for (Object tmp : subscribers) {

            subscribersString += tmp.toString()+"\n";
        }

        return subscribersString;
    }

    public static void main(String[] args) {

        SubscriberMenu menu = new SubscriberMenu();
        menu.startMenu();

    }

}
