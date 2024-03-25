package TESTNG_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstDemo {
    WebDriver driver;
    @BeforeClass
    void openApp(){


        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void login(){
    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
    driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    @AfterClass
    void close(){

        driver.quit();
    }
}
