package Keyboard_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TabsAndWindows {
    public static void main(String[] args) {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.orangehrm.com/");

        driver.switchTo().newWindow(WindowType.TAB);      //Opens new Tab
        //driver.switchTo().newWindow(WindowType.WINDOW);  //Opens new Window

        driver.get("https://demo.opencart.com/admin/");



    }
}
