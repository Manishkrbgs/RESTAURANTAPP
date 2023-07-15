package com.RestaurantManagement.Restaurant.management.service.Controller;

import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Validated
@RestController
public class VisitorController {
    @Autowired
    FoodItemService Foodservice;
    @GetMapping()
    public List<FoodItem> getall(){
     return Foodservice.getall();
    }
}
