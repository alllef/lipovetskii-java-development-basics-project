import java.util.ArrayList;
import java.util.Arrays;

public class SubscriberModel {

    private Subscriber[] subscriberArr;

    private String nameArr[] = new String[]{"Peter", "Steven", "Michael", "George", "Alexandr", "Dmitriy", "David"};
    private String surnameArr[] = new String[]{"King", "Jackson", "Ivanov", "Petrov", "Kozlov", "Shevchenko"};
    private String fatherNameArr[] = new String[]{"Vitaliovich", "Anatoliovich", "Petrovich", "Markovich", "Genadiovich"};
    private String addressArr[] = new String[]{"Cheluskintsev str.", "5th Avenue", "Baker str.", "Khreschatyk"};
    private int innerCitySpeakingTimeArr[] = new int[]{5, 250, 1500, 780, 0};
    private int outerCitySpeakingTimeArr[] = new int[]{456, 967, 648, 1564, 26, 8};

    public Subscriber[] getSubscriberArr() {
        return subscriberArr;
    }

    public void setSubscriberArr(Subscriber[] subscriberArr) {
        this.subscriberArr = subscriberArr;
    }

    SubscriberModel() {

    }

    private Subscriber generateSubscriber() {

        String name = nameArr[(int) (Math.random() * nameArr.length)];
        String surname = surnameArr[(int) (Math.random() * surnameArr.length)];
        String fatherName = fatherNameArr[(int) (Math.random() * fatherNameArr.length)];
        String address = addressArr[(int) (Math.random() * addressArr.length)];
        int innerCitySpeakingTime = innerCitySpeakingTimeArr[(int) (Math.random() * innerCitySpeakingTimeArr.length)];
        int outerCitySpeakingTime = outerCitySpeakingTimeArr[(int) (Math.random() * outerCitySpeakingTimeArr.length)];
        return new Subscriber(name, surname, fatherName, address, innerCitySpeakingTime, outerCitySpeakingTime);

    }

    public void generateSubscribers(int numberToGenerate) {
        subscriberArr = new Subscriber[numberToGenerate];

        for (int i = 0; i < subscriberArr.length; i++) {

            do {
                subscriberArr[i] = generateSubscriber();
            } while (hasSameSubscriber(subscriberArr[i]));


        }

    }

    public boolean hasSameSubscriber(Subscriber subscriber) {

        for (Subscriber tmp : subscriberArr) {

            if (tmp == subscriber || tmp == null) continue;
            if (tmp.equals(subscriber)) return true;

        }

        return false;
    }

    Object[] getSubscribersByInnerCitySpeakingTime(int innerCitySpeakingTime) {
        ArrayList<Subscriber> subscribersList = new ArrayList<Subscriber>();

        for (Subscriber tmp : subscriberArr)
            if (tmp.getInnerCitySpeakingTime() > innerCitySpeakingTime) subscribersList.add(tmp);


        return subscribersList.toArray();

    }

    Object[] getSubscribersUsedOuterCityCommunication() {
        ArrayList<Subscriber> subscribersList = new ArrayList<>();

        for (Subscriber tmp : subscriberArr)
            if (tmp.getOuterCitySpeakingTime() > 0) subscribersList.add(tmp);


        return subscribersList.toArray();
    }


}
