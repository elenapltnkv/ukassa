package ukassa.model;

import lombok.Data;

import java.util.Date;

@Data
public class DataResponseModel {
    /*
    {
    "id": "2d9c597f-000f-5000-9000-10f9bc1aa039",
    "status": "waiting_for_capture",
    "amount": {
        "value": "150.00",
        "currency": "RUB"
    },
    "description": "Заказ №74",
    "recipient": {
        "account_id": "359240",
        "gateway_id": "2215148"
    },
    "payment_method": {
        "type": "bank_card",
        "id": "2d9c597f-000f-5000-9000-10f9bc1aa039",
        "saved": false,
        "title": "Bank card *4444",
        "card": {
            "first6": "555555",
            "last4": "4444",
            "expiry_year": "2020",
            "expiry_month": "01",
            "card_type": "MasterCard",
            "card_product": {
                "code": "E"
            },
            "issuer_country": "US"
        }
    },
    "created_at": "2024-04-01T05:27:27.854Z",
    "expires_at": "2024-04-08T05:27:28.510Z",
    "test": true,
    "paid": true,
    "refundable": false,
    "metadata": {

    },
    "authorization_details": {
        "rrn": "810024534780176",
        "auth_code": "434181",
        "three_d_secure": {
            "applied": false,
            "method_completed": false,
            "challenge_completed": false
        }
    }
}
     */

    private String id;
    private String status;
    private Amount amount;
    private String description;
    private Recipient recipient;
    private PaymentMethod payment_method;
    private Date created_at;
    private Date expires_at;
    private boolean test;
    private boolean paid;
    private boolean refundable;
    private Metadata metadata;
    private AuthorizationDetails authorization_details;

    @Data
    public static class Amount{
        private String value;
        private String currency;
    }
    @Data
    public static class AuthorizationDetails{
        private String rrn;
        private String auth_code;
        private ThreeDSecure three_d_secure;
    }

    @Data
    public static class Card{
        private String first6;
        private String last4;
        private String expiry_year;
        private String expiry_month;
        private String card_type;
        private CardProduct card_product;
        private String issuer_country;
    }
    @Data
    public static class CardProduct{
        private String code;
    }
    @Data
    public static class Metadata{
    }
    @Data
    public static class PaymentMethod{
        private String type;
        private String id;
        private boolean saved;
        private String title;
        private Card card;
    }
    @Data
    public static class Recipient{
        private String account_id;
        private String gateway_id;
    }
    @Data
    public static class ThreeDSecure{
        private boolean applied;
        private boolean method_completed;
        private boolean challenge_completed;
    }
}
