package com.RestaurantManagement.Restaurant.management.service.Controller;

import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignInInput;
import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignUpOutput;
import com.RestaurantManagement.Restaurant.management.service.Model.OrderEntity;
import com.RestaurantManagement.Restaurant.management.service.Model.User;
import com.RestaurantManagement.Restaurant.management.service.Service.AuthenticationService;
import com.RestaurantManagement.Restaurant.management.service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token) {
        if (authenticationService.authenticate(email, token)) {
            return userService.sigOutUser(email);
        } else {
            return "Sign out not allowed for non authenticated user.";
        }
    }

    @PostMapping("user/order")
    public String neworder(String email , OrderEntity orderEntity){
     return  userService.neworder(email,orderEntity);

    }
}
