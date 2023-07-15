package com.RestaurantManagement.Restaurant.management.service.Repository;

import com.RestaurantManagement.Restaurant.management.service.Model.Admin;
import com.RestaurantManagement.Restaurant.management.service.Model.AuthenticationToken;
import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByAdmin(Admin admin);
}
