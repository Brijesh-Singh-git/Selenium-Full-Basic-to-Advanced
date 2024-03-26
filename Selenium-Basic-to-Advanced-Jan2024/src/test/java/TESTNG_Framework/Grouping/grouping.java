package TESTNG_Framework.Grouping;

import org.testng.annotations.Test;

public class grouping {

    @Test(priority = 1, groups = {"sanity", "regression"})
    void loginbyEmail(){
        System.out.println("This is login by email...");
    }
    @Test(priority = 2, groups = {"sanity"})
    void loginbyFacebook(){
        System.out.println("This is login by facebook...");
    }
    @Test(priority = 3, groups = {"sanity"})
    void loginbyTwitter(){
        System.out.println("This is login by twitter...");
    }

    @Test(priority = 4, groups = {"sanity", "regression"})
    void signupbyEmail(){
        System.out.println("This is signup by email...");
    }
    @Test(priority = 5, groups = {"regression"})
    void signupbyFacebook(){
        System.out.println("This is signup by facebook...");
    }
    @Test(priority = 6 , groups = {"regression"})
    void signupbyTwitter(){
        System.out.println("This is signup by twitter...");
    }

    @Test(priority = 7 , groups = {"sanity", "regression"})
    void paymentinRupees(){
        System.out.println("This is payment by Rupees...");
    }
    @Test(priority = 8, groups = {"sanity"})
    void paymentinDollars(){
        System.out.println("This is payment by Dollars...");
    }
    @Test(priority = 9, groups = {"regression"})
    void paymentinEuros(){
        System.out.println("This is payment by Euros...");
    }
}
