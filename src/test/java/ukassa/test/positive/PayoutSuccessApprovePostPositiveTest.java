package ukassa.test.positive;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ukassa.Base;
import ukassa.model.ApprovePayoutModel;
import ukassa.model.PayoutApproveResponseModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ukassa.spec.Specifications.resPect;
import static ukassa.spec.Specifications.spec;

public class PayoutSuccessApprovePostPositiveTest extends Base {
    @Feature("Позитивные тесты")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка успешного подтверждения платежаб статус код 200")
    @Test
    public void PayoutSuccessAproveTest() {
        String payment_id = "2d9c9457-000f-5000-a000-1ea13968ba7c";
        ApprovePayoutModel apmodel = new ApprovePayoutModel();
        ApprovePayoutModel.Amount amount = new ApprovePayoutModel.Amount();
        amount.setValue("150");
        amount.setCurrency("RUB");


        given(spec)
                .body(apmodel)
                .when()
                .post("/" + payment_id + "/capture")
                .then()
                .spec(resPect)
                .statusCode(200);


    }

    @Feature("Позитивные тесты")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка успешного подтверждения платежаб статус 'succeeded'")
    @Test
    public void PayoutSuccessAproveStatusTest() {
        String payment_id = "2d9c9457-000f-5000-a000-1ea13968ba7c";
        ApprovePayoutModel apmodel = new ApprovePayoutModel();
        ApprovePayoutModel.Amount amount = new ApprovePayoutModel.Amount();
        amount.setValue("150");
        amount.setCurrency("RUB");

        PayoutApproveResponseModel parmodel = given(spec)
                .body(apmodel)
                .when()
                .post("/" + payment_id + "/capture")
                .then()
                .spec(resPect)
                .statusCode(200)
                .extract().as(PayoutApproveResponseModel.class);
        Assertions.assertThat(parmodel.getStatus()).isEqualTo("succeeded");

    }
}
