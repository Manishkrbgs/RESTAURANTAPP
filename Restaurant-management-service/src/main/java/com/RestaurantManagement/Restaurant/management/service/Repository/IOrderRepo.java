package com.RestaurantManagement.Restaurant.management.service.Repository;

import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<OrderEntity,Long> {
}
