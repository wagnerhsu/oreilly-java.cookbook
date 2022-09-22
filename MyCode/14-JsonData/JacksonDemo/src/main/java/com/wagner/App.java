package com.wagner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) throws JsonProcessingException {
        ObjectToJsonString();
        JsonStringToObject();
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
