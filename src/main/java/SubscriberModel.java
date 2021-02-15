import java.util.Arrays;

public class SubscriberModel {

    private Subscriber[] subscriberArr;

    public static final String NAME_ARR[] = new String[]{"Peter", "Steven", "Michael", "George", "Alexandr", "Dmitriy", "David"};
    public static final String SURNAME_ARR[] = new String[]{"King", "Jackson", "Ivanov", "Petrov", "Kozlov", "Shevchenko"};
    public static final String FATHER_NAME_ARR[] = new String[]{"Vitaliovich", "Anatoliovich", "Petrovich", "Markovich", "Genadiovich"};
    public static final String ADDRESS_ARR[] = new String[]{"Cheluskintsev str.", "5th Avenue", "Baker str.", "Khreschatyk"};
    public static final Integer INNER_CITY_SPEAKING_TIME_ARR[] = new Integer[]{5, 250, 1500, 780, 0};
    public static final Integer OUTER_CITY_SPEAKING_TIME_ARR[] = new Integer[]{456, 967, 648, 1564, 26, 8};

    public Subscriber[] getSubscriberArr() {
        return subscriberArr;
    }

    public void setSubscriberArr(Subscriber[] subscriberArr) {
        this.subscriberArr = subscriberArr;
    }

    SubscriberModel() {

    }

    private Subscriber generateSubscriber() {

        String name = NAME_ARR[(int) (Math.random() * NAME_ARR.length)];
        String surname = SURNAME_ARR[(int) (Math.random() * SURNAME_ARR.length)];
        String fatherName = FATHER_NAME_ARR[(int) (Math.random() * FATHER_NAME_ARR.length)];
        String address = ADDRESS_ARR[(int) (Math.random() * ADDRESS_ARR.length)];
        int innerCitySpeakingTime = INNER_CITY_SPEAKING_TIME_ARR[(int) (Math.random() * INNER_CITY_SPEAKING_TIME_ARR.length)];
        int outerCitySpeakingTime = OUTER_CITY_SPEAKING_TIME_ARR[(int) (Math.random() * OUTER_CITY_SPEAKING_TIME_ARR.length)];

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
        Subscriber[] tmpArr = new Subscriber[0];

        for (Subscriber tmp : subscriberArr) {

            if (tmp.getInnerCitySpeakingTime() > innerCitySpeakingTime) {
                tmpArr = Arrays.copyOf(tmpArr, tmpArr.length + 1);
                tmpArr[tmpArr.length - 1] = tmp;
            }
        }

        return tmpArr;

    }

    Object[] getSubscribersUsedOuterCityCommunication() {
        Subscriber[] tmpArr = new Subscriber[0];

        for (Subscriber tmp : subscriberArr) {

            if (tmp.getOuterCitySpeakingTime() > 0) {
                tmpArr = Arrays.copyOf(tmpArr, tmpArr.length + 1);
                tmpArr[tmpArr.length - 1] = tmp;
            }

        }
        return tmpArr;
    }



}
