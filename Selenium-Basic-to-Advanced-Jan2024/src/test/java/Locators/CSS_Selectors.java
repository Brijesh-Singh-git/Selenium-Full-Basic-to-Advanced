package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CSS_Selectors {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
        Thread.sleep(5000);

        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(4000);

        //Tag with id
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Macbook");

        //Just id
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Macbook");


        //Tag and class
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Macbook");

        //Tag with attribute
        //driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Macbook");

        //Tag, class & attribute
        driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("Mackbook");



        driver.quit();
    }
}
