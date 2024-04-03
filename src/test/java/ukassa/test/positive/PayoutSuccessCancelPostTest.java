package ukassa.test.positive;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ukassa.Base;

import static io.restassured.RestAssured.given;
import static ukassa.spec.Specifications.resPect;
import static ukassa.spec.Specifications.spec;

public class PayoutSuccessCancelPostTest extends Base {
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка успешного отклонения платежа")
    @Test
    public void PayoutCancelAproveTest(){
        String payment_id = "2d9c96c5-000f-5000-a000-1b3bd0a22a74";


        given(spec)
                .when()
                .post("/"+payment_id+"/cancel")
                .then()
                .spec(resPect)
                .statusCode(200);


    }
}
