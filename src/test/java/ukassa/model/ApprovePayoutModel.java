package ukassa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApprovePayoutModel {

    @Data
    public static class Amount {
        private String value;
        private String currency;
    }
    private Amount amount;
}
