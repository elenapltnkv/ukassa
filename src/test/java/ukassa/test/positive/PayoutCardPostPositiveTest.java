package ukassa.test.positive;

import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ukassa.Base;
import ukassa.model.DataModel;
import ukassa.model.DataResponseModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ukassa.spec.Specifications.resPect;
import static ukassa.spec.Specifications.spec;

public class PayoutCardPostPositiveTest extends Base {
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка статуса 'waiting_for_capture'")
    @Test
    @Tag("positive")
    public void payoutCheckStatusTest() {
        DataModel dataModel = new DataModel();
        DataModel.Amount amount = new DataModel.Amount();
        amount.setValue("150.00");
        amount.setCurrency("RUB");
        dataModel.setAmount(amount);

        DataModel.Card card = new DataModel.Card();
        card.setCardholder("MR CARDHOLDER");
        card.setCsc("213");
        card.setExpiry_month("01");
        card.setExpiry_year("2020");
        card.setNumber("5555555555554444");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(200)
                //.extract().as(DataResponseModel.class)
                .body("status", is("waiting_for_capture"));

    }
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка отображения правильной суммы в ответе")
    @Test
    @Tags({@Tag("positive"), @Tag("smoke")})
    public void payoutCheckAmountTest() {
        DataModel dataModel = new DataModel();

        DataModel.Amount amount = new DataModel.Amount();
        amount.setValue("150.00");
        amount.setCurrency("RUB");
        dataModel.setAmount(amount);

        DataModel.Card card = new DataModel.Card();
        card.setCardholder("MR CARDHOLDER");
        card.setCsc("213");
        card.setExpiry_month("01");
        card.setExpiry_year("2020");
        card.setNumber("5555555555554444");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        DataResponseModel responseModel = given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(200)
                .extract().as(DataResponseModel.class);

        Assertions.assertThat(responseModel.getAmount().getValue()).isEqualTo("150.00");


    }

    //"card_type": "MasterCard",
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка card_type в ответе")
    @Test
    @Tag("positive")
    public void payoutCheckCardTypeTest() {

        DataModel dataModel = new DataModel();

        DataModel.Amount amount = new DataModel.Amount();
        amount.setValue("150.00");
        amount.setCurrency("RUB");
        dataModel.setAmount(amount);

        DataModel.Card card = new DataModel.Card();
        card.setCardholder("MR CARDHOLDER");
        card.setCsc("213");
        card.setExpiry_month("01");
        card.setExpiry_year("2020");
        card.setNumber("5555555555554444");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        DataResponseModel responseModel = given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(200)
                .extract().as(DataResponseModel.class);

        Assertions.assertThat(responseModel.getPayment_method().getCard().getCard_type()).isEqualTo("MasterCard");


    }


}
