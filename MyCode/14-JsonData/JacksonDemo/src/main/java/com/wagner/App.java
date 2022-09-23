package com.wagner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        ObjectToJsonString();
        JsonStringToObject();
        JsonStringToObjectUsingJsonMapper();
        ObjectToJsonStringUsingJsonMapper();
    }

    private static void ObjectToJsonStringUsingJsonMapper() throws JsonProcessingException {
        logger.debug(">>ObjectToJsonStringUsingJsonMapper");
        User user = new User();
        user.name = "Wagner";
        user.car = new Car();
        user.car.model = "BMW";
        ObjectMapper mapper = JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT).build();
        String jsonString = mapper.writeValueAsString(user);
        logger.info(jsonString);
        logger.debug("<<ObjectToJsonStringUsingJsonMapper");
    }

    private static void JsonStringToObjectUsingJsonMapper() throws JsonMappingException, JsonProcessingException {
        logger.debug(">>JsonStringToObjectUsingJsonMapper");
        String jsonString = "{\"Name\":\"Wagner\",\"car\":{\"model\":\"BMW\"}}";
        ObjectMapper mapper = JsonMapper.builder().enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES).build();

        User user = mapper.readValue(jsonString, User.class);
        logger.info(String.format("%s %s", user.name, user.car.model));
        logger.debug("<<JsonStringToObjectUsingJsonMapper");
    }

    private static void JsonStringToObject() throws JsonMappingException, JsonProcessingException {
        String jsonString = "{\"name\":\"Wagner\",\"car\":{\"model\":\"BMW\"}}";
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(jsonString, User.class);
        logger.info(String.format("%s %s", user.name, user.car.model));
    }

    private static void ObjectToJsonString() throws JsonProcessingException {
        User user = new User();
        user.name = "Wagner";
        user.car = new Car();
        user.car.model = "BMW";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        logger.info(jsonString);
    }
}
