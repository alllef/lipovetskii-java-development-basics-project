package warehouse;

import java.io.*;

public class WareHouseSerializer<T> {

    private final File file;

    public WareHouseSerializer(String fileName){
        file = new File(fileName);
    }

    public void serialize(T object) {

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T deserialize() {

        T realObject = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object tmpObject = objectInputStream.readObject();
            realObject = (T) tmpObject;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return realObject;
    }

}
