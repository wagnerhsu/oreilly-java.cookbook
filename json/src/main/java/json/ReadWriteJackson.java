package json;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

        BasicReadWrite();
        UseCreateObjectNode();
        TestJsonArray();
        ObjectToJsonString();
        JsonToFile();
        ObjectsToJsonArray();
        UseDefaultPrettyPrinter();
        MapToJson();
        JsonStringToJson();
        JsonFileToJavaObject();
        JsonArrayToListOfJavaObjects();
        ConvertJsonToJavaMap();
        logger.info("Done");

    }

    private static void ObjectToJsonString() {
        try {
            // create book object
            Book book = new Book("Thinking in Java", "978-0131872486", 1998,
                    new String[]{"Bruce Eckel", "Bill"});

            ObjectMapper mapper= new ObjectMapper();
            // convert book object to JSON
            String json = mapper.writeValueAsString(book);

            // print JSON string
            logger.debug(json);
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.textMessage = "text";
            messageInfo.phoneNumber = "1234";

            logger.debug(mapper.writeValueAsString(messageInfo));

        } catch (Exception ex) {
            logger.error(ex);

        }
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
            logger.error(ex);
        }
    }

    private static void JsonArrayToListOfJavaObjects() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list of books
            List<Book> books = Arrays.asList(mapper.readValue(Paths.get("c:/temp/books.json").toFile(), Book[].class));

            // print books
            books.forEach(x->logger.debug(x));

        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    private static void JsonFileToJavaObject() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            Book book = mapper.readValue(Paths.get("c:/temp/book.json").toFile(), Book.class);

            // print book
            logger.debug(book);

        } catch (Exception ex) {
            logger.error(ex);
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
            logger.debug(book);

        } catch (Exception ex) {
            logger.error(ex);
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
            logger.debug(mapper.writeValueAsString(map));

        } catch (Exception ex) {
            logger.error(ex);
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
            logger.debug(writer.writeValueAsString(book));

        } catch (Exception ex) {
            logger.error(ex);
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
            logger.debug(mapper.writeValueAsString(books));

        } catch (Exception ex) {
            logger.error(ex);
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
            logger.error(ex);
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
        logger.debug(jsonArray.toString());
    }

    private static void UseCreateObjectNode() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode object = mapper.createObjectNode();
        object.put("textMessage","textMessage");
        java.util.Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        object.put("dateTime", df.format(date));
        logger.debug(object);
    }

    public static void BasicReadWrite() throws IOException {
        ObjectMapper mapper = new ObjectMapper();                // <1>

        String jsonInput =                                       // <2>
                "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
        Person q = mapper.readValue(jsonInput, Person.class);
        logger.debug("Read and parsed Person from JSON: " + q);

        Person p = new Person("Roger", "Rabbit");                // <3>
        logger.debug("Person object " + p + " as JSON = ");

        logger.debug(mapper.writeValueAsString(p));
    }
}
// end::main[]
