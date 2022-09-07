package json;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;
import domain.Book;
import domain.MessageInfo;
import domain.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.json.JSONArray;


// tag::main[]
public class ReadWriteJackson {

    protected static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws IOException {

        //BasicReadWrite();
        //Test01();
        //TestJsonArray();
        //JsonToString();
        //JsonToFile();
        //ObjectsToJsonArray();
        //UseDefaultPrettyPrinter();
        //MapToJson();
        //JsonStringToJson();
        //JsonFileToJavaObject();
        //JsonArrayToListOfJavaObjects();
        ConvertJsonToJavaMap();
        logger.info("Information");
    }

    private static void ConvertJsonToJavaMap() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get("c:/temp/book.json").toFile(), Map.class);

            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                logger.info(entry.getKey() + "=" + entry.getValue());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void JsonArrayToListOfJavaObjects() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            List<Book> books = Arrays.asList(mapper.readValue(Paths.get("c:/temp/books.json").toFile(), Book[].class));

            // print books
            books.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void JsonFileToJavaObject() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            Book book = mapper.readValue(Paths.get("c:/temp/book.json").toFile(), Book.class);

            // print book
            System.out.println(book);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void JsonStringToJson() {
        try {
            // JSON string
            String json = "{\"title\":\"Thinking in Java\",\"isbn\":\"978-0131872486\"" +
                    ",\"year\":1998,\"authors\":[\"Bruce Eckel\"]}";

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            Book book = mapper.readValue(json, Book.class);

            // print book
            System.out.println(book);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void MapToJson() {
        try {
            // create book map
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Thinking in Java");
            map.put("isbn", "978-0131872486");
            map.put("year", 1998);
            map.put("authors", new String[]{"Bruce Eckel"});

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert book map to JSON file
            mapper.writeValue(System.out, map);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void UseDefaultPrettyPrinter() {
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel"});

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // create an instance of DefaultPrettyPrinter
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            // convert book object to JSON file
            writer.writeValue(System.out, book);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void ObjectsToJsonArray() {
        try {
            // create books list
            List<Book> books = Arrays.asList(
                    new Book("Thinking in Java", "978-0131872486", 1998,
                            new String[]{"Bruce Eckel"}),
                    new Book("Head First Java", "0596009208", 2003,
                            new String[]{"Kathy Sierra", "Bert Bates"})
            );

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert books object to JSON file
            mapper.writeValue(System.out, books);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void JsonToFile() {
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel"});

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert book object to JSON file
            mapper.writeValue(Paths.get("c:/temp/book.json").toFile(), book);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void JsonToString() {
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel", "Bill"});

            // convert book object to JSON
            String json = new ObjectMapper().writeValueAsString(book);

            // print JSON string
            System.out.println(json);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void TestJsonArray() throws JsonProcessingException {
        JSONArray jsonArray = new JSONArray();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.textMessage = "text";
        messageInfo.phoneNumber = "1234";
        jsonArray.put("string");
        jsonArray.put(2);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(messageInfo);
        jsonArray.put(json);
        System.out.println(jsonArray.toString());
    }

    private static void Test01() throws JsonProcessingException {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.textMessage = "text";
        messageInfo.phoneNumber = "1234";
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();

        String json = mapper.writeValueAsString(messageInfo);
        System.out.println(">>" + json);

        MessageInfo mi = mapper.readValue(json, MessageInfo.class);
        System.out.println("<<" + mapper.writeValueAsString(mi));
    }

    public static void BasicReadWrite() throws IOException {
        ObjectMapper mapper = new ObjectMapper();                // <1>

        String jsonInput =                                       // <2>
                "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
        Person q = mapper.readValue(jsonInput, Person.class);
        System.out.println("Read and parsed Person from JSON: " + q);

        Person p = new Person("Roger", "Rabbit");                // <3>
        System.out.print("Person object " + p + " as JSON = ");
        mapper.writeValue(System.out, p);
    }
}
// end::main[]
