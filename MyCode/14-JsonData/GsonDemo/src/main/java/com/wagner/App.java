package com.wagner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    static Logger logger = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        ObjectToJson();
        JsonToObject();
    }

    private static void JsonToObject() {
        String jsonString = "{'id':1001, 'firstName':'Lokesh', 'lastName':'Gupta', 'email':'howtodoinjava@gmail.com'}";

        Gson gson = new Gson();

        Employee emp = gson.fromJson(jsonString, Employee.class);
        logger.debug(gson.toJson(emp));
    }

    private static void ObjectToJson() {
        Employee emp = new Employee();
        emp.id = 1001;
        emp.firstName = "Lokesh";
        emp.lastName = "Gupta";
        emp.email = "howtodoinjava@gmail.com";
        Gson gson = new Gson();
        logger.debug(gson.toJson(emp));
    }
}
