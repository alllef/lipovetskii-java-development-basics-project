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

        StringBuilder subscribersString = new StringBuilder();

        if (subscribers.length == 0) {
            println("There is now data by this criteria");
            return;
        }

        for (Object tmp : subscribers) subscribersString.append(tmp.toString()).append("\n");

        println(subscribersString.toString());
    }

    private static int getMaxStringLengthInArr(Object[] arr) {
        int length = 0;

        for (Object object : arr)
            if (object.toString().length() > length) length = object.toString().length();

        return length;
    }

    private static String getStringCopy(String string, int copyNumber){
        StringBuilder copyString= new StringBuilder(" ");

        copyString.append(String.valueOf(string).repeat(Math.max(0, copyNumber)));


        return copyString.toString();
    }

    public static String getSpaceToAlign(Object str,Object[]arr){
        int numberOfSpaces = getMaxStringLengthInArr(arr)-str.toString().length();
        return getStringCopy(" ",numberOfSpaces);
    }
}
