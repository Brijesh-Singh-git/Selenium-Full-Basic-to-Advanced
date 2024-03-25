package TESTNG_Framework.DependecyMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentMethods {

    @Test(priority = 1)
    void openapp(){

        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"openapp"})

    void login(){
        Assert.assertTrue(false);

    }
    @Test(priority = 3, dependsOnMethods = {"login"})

    void search(){
        Assert.assertTrue(true);

    }

    @Test(priority = 3, dependsOnMethods = {"search"})

    void advsearch(){
        Assert.assertTrue(false);

    }
    @Test(priority = 4, dependsOnMethods = {"advsearch"})

    void logout(){
        Assert.assertTrue(true);

    }
}
