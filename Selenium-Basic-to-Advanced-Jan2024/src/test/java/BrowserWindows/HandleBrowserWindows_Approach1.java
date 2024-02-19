package BrowserWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleBrowserWindows_Approach1 {
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


        //Approach1 - Using List Collections
        //convert SET collection to List collection
        List<String> windowIds = new ArrayList(windIds);

        String parentWinId = windowIds.get(0);
        String childWinId = windowIds.get(1);

        //switch to child window
        driver.switchTo().window(childWinId);

        driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
        driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("Rohan Das");

        //Switch to parent window
        driver.switchTo().window(parentWinId);

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin12");


        driver.quit();


    }
}
