package model;

import entity.Subscriber;
import entity.SubscriberGenerator;

import java.util.Arrays;

public class SubscriberModel {

    private Subscriber[] subscriberArr;



    public Subscriber[] getSubscriberArr() {
        return subscriberArr;
    }

    public void setSubscriberArr(Subscriber[] subscriberArr) {
        this.subscriberArr = subscriberArr;
    }

    public SubscriberModel(int number) {
        subscriberArr = SubscriberGenerator.generateSubscribers(number);
    }





    public Subscriber[] getSubscribersByInnerCitySpeakingTime(int innerCitySpeakingTime) {
        Subscriber[] tmpArr = new Subscriber[0];

        for (Subscriber tmp : subscriberArr) {

            if (tmp.getInnerCitySpeakingTime() > innerCitySpeakingTime) {
                tmpArr = Arrays.copyOf(tmpArr, tmpArr.length + 1);
                tmpArr[tmpArr.length - 1] = tmp;
            }
        }

        return tmpArr;

    }

    public Subscriber[] getSubscribersUsedOuterCityCommunication() {
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
