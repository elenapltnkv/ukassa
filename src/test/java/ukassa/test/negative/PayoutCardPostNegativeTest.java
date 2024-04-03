package ukassa.test.negative;

import io.qameta.allure.Owner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ukassa.Base;
import ukassa.model.DataModel;
import ukassa.model.DataResponseNegativeModel;
import ukassa.model.ErrorModel;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static ukassa.spec.Specifications.resPect;
import static ukassa.spec.Specifications.spec;

public class PayoutCardPostNegativeTest extends Base {
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка срока действия карты")
    @Test
    public void payoutCancellationReasonTest() {
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
        card.setNumber("5555555555554543");

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
                .body("cancellation_details.reason", is("card_expired"));

    }
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка невалидного номера карты")
    @Test
    public void payoutInvalidCardNumberTest() {
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
        card.setNumber("5555555555554618");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        DataResponseNegativeModel responseNoModel = given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(200)
                .extract().as(DataResponseNegativeModel.class);

        Assertions.assertThat(responseNoModel.getCancellation_details().getReason()).isEqualTo("invalid_card_number");


    }
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка текста ошибки при отправке невалидного номера карты")
    @Test
    @Tag("smoke")
    public void payoutErrorCardNumberTest() {

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
        card.setNumber("32558");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        ErrorModel errorModel = given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(400)
                .extract().as(ErrorModel.class);

        Assertions.assertThat(errorModel.getCode()).isEqualTo("invalid_request");
        Assertions.assertThat(errorModel.getDescription()).isEqualTo("Error in the bank card number. Specify a valid number. " +
                "You can validate the number using the Luhn algorithm.");


    }
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка ввода невалидного года Expiry_year")
    @Test
    public void payoutErrorExpiryCardTest() {

        DataModel dataModel = new DataModel();

        DataModel.Amount amount = new DataModel.Amount();
        amount.setValue("150.00");
        amount.setCurrency("RUB");
        dataModel.setAmount(amount);

        DataModel.Card card = new DataModel.Card();
        card.setCardholder("MR CARDHOLDER");
        card.setCsc("213");
        card.setExpiry_month("01");
        card.setExpiry_year("20");
        card.setNumber("2202202212312379");

        DataModel.PaymentMethodData methodData = new DataModel.PaymentMethodData();
        methodData.setType("bank_card");
        methodData.setCard(card);

        dataModel.setPayment_method_data(methodData);
        DataModel.Confirmation confirmation = new DataModel.Confirmation();
        confirmation.setType("redirect");
        confirmation.setReturn_url("https://www.example.com/return_url");
        dataModel.setConfirmation(confirmation);

        dataModel.setDescription("Заказ №74");


        ErrorModel errorModel = given(spec)
                .body(dataModel)
                .when()
                .post()
                .then()
                .spec(resPect)
                .statusCode(400)
                .extract().as(ErrorModel.class);

        Assertions.assertThat(errorModel.getCode()).isEqualTo("invalid_request");
        Assertions.assertThat(errorModel.getDescription()).isEqualTo("Card expiry year is illegal. Must be a 4-digit number");

    }
}

