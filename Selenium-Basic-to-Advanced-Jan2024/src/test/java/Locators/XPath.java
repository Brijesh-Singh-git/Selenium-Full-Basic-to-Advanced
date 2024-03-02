package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XPath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.setProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();
        Thread.sleep(5000);

        driver.get("https://demo.opencart.com/");
        Thread.sleep(4000);

        String s1 = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
        System.out.println(s1);
        driver.quit();
    }
}
