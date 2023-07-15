package com.RestaurantManagement.Restaurant.management.service.Controller;

import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignInInput;
import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignUpOutput;
import com.RestaurantManagement.Restaurant.management.service.Model.Admin;
import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Service.AuthenticationService;
import com.RestaurantManagement.Restaurant.management.service.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@Validated
@RestController
public class AdminController {


        @Autowired
       private AdminService adminService;

        @Autowired
       private AuthenticationService authenticationService;

        @PostMapping("admin/signup")
        public SignUpOutput signUpInstaAdmin(@RequestBody Admin admin) throws NoSuchAlgorithmException {

            return adminService.signUpAdmin(admin);
        }

        @PostMapping("admin/signIn")
        public String sigInInstaAdmin(@RequestBody @Valid SignInInput signInInput)
        {
            return adminService.signInAdmin(signInInput);
        }

        @DeleteMapping("admin/signOut")
        public String sigOutInstaAdmin(String email, String token) {
            if (authenticationService.authenticate(email, token)) {
                return adminService.sigOutAdmin(email);
            } else {
                return "Sign out not allowed for non authenticated admin.";
            }
        }
        @PostMapping("admin/fooditem")
    public String addfooditem(FoodItem foodlist,String email){
           return adminService.addfooditem(foodlist, email);
        }



}
