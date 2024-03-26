package TESTNG_Framework.Parametrization_Using_DataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviders_Demo {
    WebDriver driver;

    @BeforeClass
    void steup(){

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

    }

    @Test(dataProvider = "dp")
    void login(String email, String password){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

        String exp_title = "nopCommerce demo store";
        String act_title = driver.getTitle();

        Assert.assertEquals(exp_title, act_title);

    }

    @AfterClass
    void tearDown(){

        driver.close();

    }



    @DataProvider(name = "dp" , indices = {0,4})   //if we specify the indices it will execute only those data
    String [][] loginData(){
        String data [][] = {

                {"abc12@gmail.com", "test@test"},
                {"Pankaj@gmail.com", "corona@12345"},
                {"mohit.jain@amazon.com", "test@123"},
                {"mohitjain@gmail.com", "mohit@jain"},
                {"priyarajput@gmail.com", "test@123"},

        };

        return data;
    }



}
