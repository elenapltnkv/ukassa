package ukassa.model;

import lombok.Data;

@Data
public class ErrorModel {
    private String type;
    private String id;
    private String code;
    private String description;
    private String parameter;
}
