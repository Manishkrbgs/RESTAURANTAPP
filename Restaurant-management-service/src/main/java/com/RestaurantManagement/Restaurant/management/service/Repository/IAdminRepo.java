package com.RestaurantManagement.Restaurant.management.service.Repository;

import com.RestaurantManagement.Restaurant.management.service.Model.Admin;
import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Long> {
    Admin findFirstByAdminEmail(String newEmail);
}
