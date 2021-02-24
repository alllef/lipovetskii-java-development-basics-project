package warehouse;

import entity.Subscriber;

import java.io.*;

public class WareHouseStringSaver {

    public void saveStringSubscribers(Subscriber[] subscribers, String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Subscriber tmp : subscribers)
                writer.write(convertSubscriberToString(tmp));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Subscriber[] loadStringSubscribers(String fileName) {

        Subscriber[] subscribers = new Subscriber[100];
        int subscriberCounter = 0;
        String tmpString;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            do {

                tmpString = reader.readLine();
                subscribers[subscriberCounter] = convertStringToSubscriber(tmpString);
                System.out.println(tmpString);

            } while (tmpString != null);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subscribers;
    }

    private Subscriber convertStringToSubscriber(String subscriberString) {

        String tmpString = new String(subscriberString);
        String[] valuesArr = tmpString.split(" ");
        return new Subscriber(valuesArr[0], valuesArr[1], valuesArr[2], valuesArr[3], Integer.parseInt(valuesArr[4]), Integer.parseInt(valuesArr[5]));
    }

    private String convertSubscriberToString(Subscriber subscriber) {
        return subscriber.getName() + " " + subscriber.getSurname() + " " + subscriber.getFatherName() + " " + subscriber.getAddress() + " " + subscriber.getInnerCitySpeakingTime() + subscriber.getOuterCitySpeakingTime() + "\n";
    }

}
