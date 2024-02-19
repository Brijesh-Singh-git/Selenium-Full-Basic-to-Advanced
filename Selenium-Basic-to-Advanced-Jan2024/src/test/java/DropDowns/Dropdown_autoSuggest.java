package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Dropdown_autoSuggest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Selenium");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='mdzGzd']//div[@class='wM6W7d']//span")).click();








    }
}
