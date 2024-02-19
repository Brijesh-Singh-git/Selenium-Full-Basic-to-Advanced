package BrowserWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleBrowserWindows_Approach2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

        //https://the-internet.herokuapp.com/basic_auth
        //https://admin:admin@the-internet.herokuapp.com/basic_auth

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Thread.sleep(2000);


        //Capture ID's of both the windows
        Set<String> windIds = driver.getWindowHandles();


        //Approach2 - Using enhanced for loop
       for(String windid : windIds){
           String title = driver.switchTo().window(windid).getTitle();

           if(title.equals("OrangeHRM HR Software | OrangeHRM")){
               driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
               driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("Rohan Singh Rajput");
           }
       }



        driver.close();


    }
}
