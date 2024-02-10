package com.learn.FoodDelivery.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @JsonProperty("firstName")
    private String firstname;

    @JsonProperty("lastName")
    private String lastname;
    private String email;
    private String password;
    private String mobileNumber;
}
