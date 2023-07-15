package com.RestaurantManagement.Restaurant.management.service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderentid;
    private Long orderQuantity;
    private OrderStatus  orderStatus;




    @ManyToOne
   User user;

    @OneToMany
    List<FoodItem> foodItem;

}
