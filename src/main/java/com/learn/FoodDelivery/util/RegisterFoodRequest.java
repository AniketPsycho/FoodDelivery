package com.learn.FoodDelivery.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterFoodRequest {

    private String name;
    private long price;

    @JsonProperty("imageurl")
    private String imageUrl;

    private String description;
}
