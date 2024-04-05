package ukassa.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ukassa.Base;
import static io.restassured.RestAssured.given;
import static ukassa.spec.Specifications.resPect;
import static ukassa.spec.Specifications.spec;


public class PayoutGetInfoTest extends Base {
    @Feature("Запрос информации по платежам")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка запроса информации по всем платежам")
    @Test
    public void PayoutGetAllInfoTest() {


        given(spec)

                .when()
                .get()
                .then()
                .spec(resPect)
                .statusCode(200);


    }

    @Feature("Запрос информации по платежам")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка запроса информации по определенному платежу")
    @Test
    public void PayoutGetInfoIdTest() {
        String payment_id ="2d9cc60d-000f-5000-9000-131c0b967024";

        given(spec)

                .when()
                .get("/"+payment_id)
                .then()
                .spec(resPect)
                .statusCode(200);


    }



}
