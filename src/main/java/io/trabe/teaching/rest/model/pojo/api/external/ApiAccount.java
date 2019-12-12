package io.trabe.teaching.rest.model.pojo.api.external;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ApiAccount {
    private Long id;
    private String code;
    private String description;
    private Double balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar creationDate;
    private ApiAccountKind kind;

}
