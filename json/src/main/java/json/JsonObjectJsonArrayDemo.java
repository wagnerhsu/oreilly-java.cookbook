package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Car;
import domain.User;
import domain.Zoo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


public class JsonObjectJsonArrayDemo {
    final static String FILE_NAME = "/json/softwareinfo.json";
    protected static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws IOException {
        ConvertObjectToJsonObject();
        EmbeddedJsonToJsonString();
        ExceptionTest();
    }

    private static void ExceptionTest() throws JsonProcessingException {
        String json = "{\"animal\":{\"name\":\"lacy\"},\"place\":\"sh\"}";
        ObjectMapper mapper = new ObjectMapper();
        logger.debug(json);
        Zoo zoo = mapper.reader().forType(Zoo.class).readValue(json);
        logger.debug(zoo.toString());
        logger.debug(mapper.writeValueAsString(zoo));
    }

    private static void EmbeddedJsonToJsonString() throws JsonProcessingException {
        User user = new User();
        user.name = "Test";
        user.car.model = "testModel";
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        String jsonString = mapper.writeValueAsString(user);
        logger.debug(jsonString);


        User newUser = mapper.reader().forType(User.class).readValue(jsonString);
        logger.debug(newUser.toString());

    }

    private static void ConvertObjectToJsonObject() throws IOException {
        InputStream jsonInput =
                JsonObjectJsonArrayDemo.class.getResourceAsStream(FILE_NAME);
        if (jsonInput == null) {
            throw new NullPointerException("can't find " + FILE_NAME);
        }
        ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SoftwareInfo softwareInfo = mapper.readValue(jsonInput, SoftwareInfo.class);
        String s1 = mapper.writeValueAsString(softwareInfo.contributors);
        JSONArray j1 = new JSONArray(s1);
        logger.debug(j1.toString());
        JSONObject jsonObject = new JSONObject(mapper.writeValueAsString(softwareInfo));
        logger.debug(jsonObject.toString());
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);
        logger.debug(jsonArray);
    }
}
