package JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class InteractWithWebElements {
    public static void main(String[] args) {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        JavascriptExecutor js = (JavascriptExecutor) driver;


        //First Name
        WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
        js.executeScript("arguemnts[0].setAttribute('value','Brijesh')", inputbox);


        //Radio Button
        WebElement radiobtn = driver.findElement(By.id("male"));
        //radiobtn.click();
        js.executeScript("arguemnts[0].click();",  radiobtn);



        driver.quit();


    }
}
