package com.RestaurantManagement.Restaurant.management.service.Repository;

import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IFoodRepo extends JpaRepository<FoodItem,Long> {

}
