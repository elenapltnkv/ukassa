package ukassa.test.positive;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import ukassa.Base;

import ukassa.steps.PayoutCardPostPositiveStep;

public class PayoutCardPostPositiveStepTest extends Base {
    PayoutCardPostPositiveStep step = new PayoutCardPostPositiveStep();
    @Feature("Позитивные тесты")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка ввода валидного номера карты")
    @Test
    @Tag("positiveStep")
    public void payoutCheckStatusTest() {

        step.payoutCheckStatusStep("2202474301322987");

    }
    @Feature("Позитивные тесты")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка получения валидных данных")
    @Test
    @Tag("positiveStep")
    public void payoutCheckAmountTest() {
        step.payoutCheckAmountStep("150.00", "RUB", "2202474301322987");


    }
    @Feature("Позитивные тесты")
    @Owner("samigullaeva.ea")
    @DisplayName("Проверка получения платежной системы")
    @Test
    @Tag("positiveStep")
    public void payoutCheckCardTypeTest() {

        step.payoutCheckCardTypeStep("2202474301322987", "Mir");


    }


}
