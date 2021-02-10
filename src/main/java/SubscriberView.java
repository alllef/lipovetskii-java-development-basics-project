import java.util.Scanner;

public class SubscriberView {

    public static final String STARTER_OUTPUT = "Enter the number of subscribers that you want to generate";
    public static final String MENU_OUTPUT = """
            Enter 1, if you want to know subscribers, that spoken more minutes in inner city lines, than entered by you number
            Enter 2, if you want to know subscribers, that used outer city lines
            Enter 3, if you want to exit""";


    void println(String output) {
        System.out.println(output);
    }


    void printSubscriberArr(Object[] subscribers) {

        String subscribersString = "";

        if (subscribers.length == 0) {
            println("There is now data by this criteria");
            return;
        }



        for (Object tmp : subscribers) subscribersString += tmp.toString() + "\n";

        println(subscribersString);
    }


}
