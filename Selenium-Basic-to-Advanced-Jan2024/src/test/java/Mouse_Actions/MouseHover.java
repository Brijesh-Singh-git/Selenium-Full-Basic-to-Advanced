package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHover {
    public static void main(String[] args) {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();

        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

        Actions act = new Actions(driver);

//        act.moveToElement(desktop).moveToElement(mac).click().build().perform();  //creating action then perform
        act.moveToElement(desktop).moveToElement(mac).click().perform(); //directly performing the action




    }

}
