package ukassa;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {

    static Properties properties;
    static String baseURL;
    static String username;
    static String token;
    @BeforeAll
    static void beforeAll() throws IOException {
//        properties = new Properties();
//        properties.load(new FileInputStream("/home/user/IdeaProjects/ukassa/src/test/resources/additional.properties"));
//        baseURL = properties.getProperty(baseURL);
//        username = properties.getProperty("username", username);
//        token = properties.getProperty(token);

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = "https://api.yookassa.ru/v3/payments";

    }
    @BeforeEach
    void beforeEach(){

    }
    //@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)


}
