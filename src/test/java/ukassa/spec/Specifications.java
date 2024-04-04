package ukassa.spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ukassa.Base;

import java.util.Base64;
import java.util.UUID;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static org.apache.commons.codec.Charsets.UTF_8;


public class Specifications extends Base {
    static final String originalInput = "359240:test_xjhYEg858jF0R1zaYQtdkWYODrm9Hq7T8qysiaDX-P8";
    static final String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes(UTF_8));
    //static UUID uuid = Generators.randomBasedGenerator().generate();

    //static UUID uuid = new UUID(24, 2);
    public static RequestSpecification spec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec1 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec2 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec3 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);
    public static RequestSpecification spec4 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec5 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec6 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);

    public static RequestSpecification spec7 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);
    public static RequestSpecification spec8 = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", UUID.randomUUID())
            .contentType("application/json")
            .filter(new AllureRestAssured())
            .header("Authorization", "Basic " + encodedString);
    public static final ResponseSpecification resPect = new ResponseSpecBuilder()

            .log(URI)
            .log(BODY)
            .log(STATUS)
            .log(BODY)
            .log(ALL)
            .build();


}

