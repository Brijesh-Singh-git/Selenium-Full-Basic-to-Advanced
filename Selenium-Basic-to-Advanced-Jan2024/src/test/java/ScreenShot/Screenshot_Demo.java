package ScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class Screenshot_Demo {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Screenshot of Full Page
     /*   TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Users\\HP\\Desktop\\Selenium Full Basic to Advanced\\Selenium-Basic-to-Advanced-Jan2024\\src\\Screenshots\\fullpage.png");

        FileUtils.copyFile(src,target);

        */


        //Screenshot of specific area from the webpage --- Selenium 4+
        WebElement featutredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

        File src = featutredProducts.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\Users\\HP\\Desktop\\Selenium Full Basic to Advanced\\Selenium-Basic-to-Advanced-Jan2024\\src\\Screenshots\\featuredProducts.png");
        FileUtils.copyFile(src,target);


        driver.quit();




    }
}
