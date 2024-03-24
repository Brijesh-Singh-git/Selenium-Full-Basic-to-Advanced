package Headless_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Headless_Demo {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        




    }

}
