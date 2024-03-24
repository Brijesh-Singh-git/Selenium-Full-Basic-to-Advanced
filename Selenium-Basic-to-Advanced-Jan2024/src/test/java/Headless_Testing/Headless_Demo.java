package Headless_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Headless_Demo {
    public static void main(String[] args) throws InterruptedException, IOException {


        //Approach 1 ) ---> Headless Mode
     /*   EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setHeadless(true);


        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(edgeOptions);
        
        */

        //Approach 2) ---> Headless Mode onwards WDM 5+

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setHeadless(true);

        WebDriver driver = WebDriverManager.edgedriver().capabilities(options).create();




        //1) Open Browser
        System.setProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");

        Thread.sleep(5000);

        //2) Open the Link
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        //3) Provide USername
        driver.findElement(By.name("username")).sendKeys("Admin");

        //4) Provide password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //5) Click the Submit Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //6) Verify the title of the page
        String act_title = driver.getTitle();
        String exp_title = "OrangeHRM";

        if(act_title.equals(exp_title)){
            System.out.println("Test case got passed");
        }else {
            System.out.println("Test Case got failed!!!!");
        }

        driver.quit();







    }

}
