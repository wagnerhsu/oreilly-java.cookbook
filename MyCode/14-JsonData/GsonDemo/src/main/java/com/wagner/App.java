package com.wagner;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        ObjectToJson();
        JsonToObject();
        ObjectToJsonPretty();
        JsonArrayToObjectArray();
        JsonArrayToObjectList();
        DeserializeRecognizeResult();
    }

    /**
     * 以PascalCase反序列化为Java对象，再以CamelCase序列化为Json字符串
     */
    private static void DeserializeRecognizeResult() {
        logger.debug(">>DeserializeRecognizeResult");
        String json = "{\"Response\":{\"RequestId\":\"a23644b3-980a-4c31-9001-612b37fb683b\",\"Result\":\"姓名，张三。\",\"AudioDuration\":2268,\"WordSize\":0,\"WordList\":null}}";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        Type t = new TypeToken<RecognizeResult>() {
        }.getType();
        RecognizeResult result = gson.fromJson(json, t);
        logger.debug(new Gson().toJson(result));
        logger.debug("<<DeserializeRecognizeResult>>");
    }

    private static void JsonArrayToObjectList() {
        logger.debug(">>JsonArrayToObjectList");
        String userJson = "[{'name': 'Alex','id': 1}, "
                + "{'name': 'Brian','id':2}, "
                + "{'name': 'Charles','id': 3}]";

        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<User>>() {
        }.getType();

        ArrayList<User> userArray = gson.fromJson(userJson, userListType);

        for (User user : userArray) {
            logger.info(user);
        }
        logger.debug(">>JsonArrayToObjectList");
    }

    private static void JsonArrayToObjectArray() {
        logger.debug(">>JsonArrayToObjectArray");
        String userJson = "[{'name': 'Alex','id': 1}, "
                + "{'name': 'Brian','id':2}, "
                + "{'name': 'Charles','id': 3}]";

        Gson gson = new Gson();

        User[] userArray = gson.fromJson(userJson, User[].class);

        for (User user : userArray) {
            logger.info(user);
        }
        logger.debug(">>JsonArrayToObjectArray");
    }

    private static void ObjectToJsonPretty() {
        logger.debug(">>ObjectToJsonPretty");
        Employee emp = new Employee();
        emp.id = 1001;
        emp.firstName = "Lokesh";
        emp.lastName = "Gupta";
        emp.email = "howtodoinjava@gmail.com";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        logger.debug(gson.toJson(emp));

        logger.debug("<<ObjectToJsonPretty");
    }

    private static void JsonToObject() {
        logger.debug(">>JsonToObject");
        String jsonString = "{'id':1001, 'firstName':'Lokesh', 'lastName':'Gupta', 'email':'howtodoinjava@gmail.com'}";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Employee emp = gson.fromJson(jsonString, Employee.class);
        logger.debug(gson.toJson(emp));
        logger.debug("<<JsonToObject");
    }

    private static void ObjectToJson() {
        logger.debug(">>ObjectToJson");
        Employee emp = new Employee();
        emp.id = 1001;
        emp.firstName = "Lokesh";
        emp.lastName = "Gupta";
        emp.email = "howtodoinjava@gmail.com";
        Gson gson = new Gson();
        logger.debug(gson.toJson(emp));

        logger.debug("<<ObjectToJson");
    }
}
