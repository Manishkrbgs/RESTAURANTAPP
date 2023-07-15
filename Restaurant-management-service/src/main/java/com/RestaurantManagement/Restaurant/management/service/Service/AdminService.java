package com.RestaurantManagement.Restaurant.management.service.Service;

import com.RestaurantManagement.Restaurant.management.service.Model.AuthenticationToken;
import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignInInput;
import com.RestaurantManagement.Restaurant.management.service.Model.Dto.SignUpOutput;
import com.RestaurantManagement.Restaurant.management.service.Model.Admin;
import com.RestaurantManagement.Restaurant.management.service.Model.FoodItem;
import com.RestaurantManagement.Restaurant.management.service.Repository.IAdminRepo;
import com.RestaurantManagement.Restaurant.management.service.Repository.IAuthenticationRepo;
import com.RestaurantManagement.Restaurant.management.service.Repository.IFoodRepo;
import com.RestaurantManagement.Restaurant.management.service.Service.HashingUtility.PasswordEncrypter;
import org.omkar.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    IFoodRepo ifoodRepo;

    @Autowired
    AuthenticationService authenticationService;

    public SignUpOutput signUpAdmin(Admin admin) throws NoSuchAlgorithmException {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = admin.getAdminEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }


        Admin existingAdmin = adminRepo.findFirstByAdminEmail(newEmail);

        if (existingAdmin != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }


        String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());


        admin.setAdminPassword(encryptedPassword);
        adminRepo.save(admin);

        return new SignUpOutput(signUpStatus, "Admin registered successfully!!!");
    }




    public String signInAdmin(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }


        Admin existingAdmin = adminRepo.findFirstByAdminEmail(signInEmail);

        if(existingAdmin == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }


        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingAdmin.getAdminPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and admin id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingAdmin);
                authenticationService.saveAuthToken(authToken);

                MailHandler.sendmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }


    public String sigOutAdmin(String email) {

        Admin admin = adminRepo.findFirstByAdminEmail(email);
        AuthenticationToken token = authenticationService.findFirstByAdmin(admin);
        authenticationService.removeToken(token);
        return "Admin Signed out successfully";
    }

    public String addfooditem(FoodItem foodlist, String email) {
        Admin admin = adminRepo.findFirstByAdminEmail(email);
        AuthenticationToken token = authenticationService.findFirstByAdmin(admin);
        if(token != null){
            ifoodRepo.save(foodlist);
          return   "foodlist update sucessfully";
        }
        else{
            return "not a admin";
        }
    }
}
