package com.RestaurantManagement.Restaurant.management.service.Service;

import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodRepo ifoodrepo;
    public List<FoodItem> getall() {
       return ifoodrepo.findAll();

    }
}
