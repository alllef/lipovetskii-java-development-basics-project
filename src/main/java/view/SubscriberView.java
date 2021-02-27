package view;

import entity.Subscriber;
import entity.SubscriberGenerator;


public class SubscriberView {

    public static final String STARTER_OUTPUT = "Hello, welcome to menu";
    public static final String MENU_OUTPUT = """
            Enter 1, if you want to know subscribers, that spoken more minutes in inner city lines, than entered by you number
            Enter 2, if you want to know subscribers, that used outer city lines
            Enter 3, if you want to exit""";
    public static final String SAVE_MENU_OUTPUT = """
            Do you want to save this information?
            Enter "yes", if you want
            Enter other characters, if you do not want""";


   public void println(String output) {
        System.out.println(output);
    }


   public void printSubscriberArr(Object[] subscribers) {

        StringBuilder subscribersString = new StringBuilder();

        if (subscribers.length == 0) {
            println("There is now data by this criteria");
            return;
        }

        for (Object tmp : subscribers) subscribersString.append(formatSubscriberOutput((Subscriber) tmp)).append("\n");

        println(subscribersString.toString());
    }

    private String formatSubscriberOutput(Subscriber subscriber) {
        return "Subscriber{" + "name='" + subscriber.getName() + '\'' + SubscriberView.getSpaceToAlign(subscriber.getName(), SubscriberGenerator.NAME_ARR)+
                "surname='" + subscriber.getSurname() + '\'' + SubscriberView.getSpaceToAlign(subscriber.getSurname(), SubscriberGenerator.SURNAME_ARR)+
                "fatherName='" + subscriber.getFatherName() + '\'' + SubscriberView.getSpaceToAlign(subscriber.getFatherName(), SubscriberGenerator.FATHER_NAME_ARR)+
                "address='" + subscriber.getAddress() + '\'' + SubscriberView.getSpaceToAlign(subscriber.getAddress(), SubscriberGenerator.ADDRESS_ARR)+
                "innerCitySpeakingTime=" + subscriber.getInnerCitySpeakingTime() + SubscriberView.getSpaceToAlign(subscriber.getInnerCitySpeakingTime(), SubscriberGenerator.INNER_CITY_SPEAKING_TIME_ARR)+
                "outerCitySpeakingTime=" + subscriber.getOuterCitySpeakingTime() + SubscriberView.getSpaceToAlign(subscriber.getOuterCitySpeakingTime(), SubscriberGenerator.OUTER_CITY_SPEAKING_TIME_ARR)+
                '}';
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
