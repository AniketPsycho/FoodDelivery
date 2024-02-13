package com.learn.FoodDelivery.services;

import com.learn.FoodDelivery.models.Food;
import com.learn.FoodDelivery.repositories.FoodRepository;
import com.learn.FoodDelivery.util.RegisterFoodRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    public final FoodRepository foodRepository;

    public void registerFood(RegisterFoodRequest request){
        foodRepository.save(
                Food.builder()
                .name( request.getName() )
                .price(request.getPrice() )
                .imageUrl(request.getImageUrl() )
                .description(request.getDescription() )
                .build()
        );
    }

    public List<RegisterFoodRequest> getAllFood(){

        List<RegisterFoodRequest> responseList = new ArrayList<>();
        foodRepository.findAll().forEach( food -> {
                responseList.add(
                    RegisterFoodRequest
                        .builder()
                        .name( food.getName() )
                        .price( food.getPrice() )
                        .imageUrl(food.getImageUrl() )
                        .description(food.getDescription() )
                        .build()
                    );
            }
        );

        return responseList;
    }

}
