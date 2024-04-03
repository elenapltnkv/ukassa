package ukassa.spec;

import de.huxhorn.sulky.ulid.ULID;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ukassa.Base;

import java.util.Base64;
import java.util.UUID;


import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.*;
import static org.apache.commons.codec.Charsets.UTF_8;

public class Specifications extends Base {
    static String originalInput = "359240:test_xjhYEg858jF0R1zaYQtdkWYODrm9Hq7T8qysiaDX-P8";
    static String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes(UTF_8));
    static UUID uuid = UUID.randomUUID();
//    static ULID ulid = new ULID();
//
//    // with current timestamp
//    static String newId = ulid.nextULID();


    public static RequestSpecification spec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .baseUri("https://api.yookassa.ru/v3/payments")
            .header("Idempotence-Key", uuid)
            .contentType("application/json")
            .header("Authorization", "Basic " + encodedString);


    public static ResponseSpecification resPect = new ResponseSpecBuilder()

            .log(URI)
            .log(BODY)
            .log(STATUS)
            .log(BODY)
            .log(ALL)
            .build();




}

