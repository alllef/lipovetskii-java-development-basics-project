package warehouse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Subscriber;

import java.io.File;
import java.io.IOException;

public class JSONParser {
    private ObjectMapper objectMapper = new ObjectMapper();

   public void saveSubscribers(File file, Subscriber[] arr) {

        try {
            objectMapper.writeValue(file, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public Subscriber[] loadSubscribers(File file) {
        Subscriber[] tmpArr = new Subscriber[0];
        try {
           if(file.length()>0) tmpArr = objectMapper.readValue(file, Subscriber[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpArr;
    }
}
