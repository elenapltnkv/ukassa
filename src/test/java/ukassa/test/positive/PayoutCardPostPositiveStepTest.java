package ukassa.test.positive;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import ukassa.Base;

import ukassa.steps.PayoutCardPostPositiveStep;

public class PayoutCardPostPositiveStepTest extends Base {
    PayoutCardPostPositiveStep step = new PayoutCardPostPositiveStep();

    @Test
    @Tag("positiveStep")
    public void payoutCheckStatusTest() {

        step.payoutCheckStatusStep("2202474301322987");

    }

    @Test
    @Tag("positiveStep")
    public void payoutCheckAmountTest() {
        step.payoutCheckAmountStep("150.00", "RUB", "2202474301322987");


    }

    @Test
    @Tag("positiveStep")
    public void payoutCheckCardTypeTest() {

        step.payoutCheckCardTypeStep("2202474301322987", "Mir");


    }


}
