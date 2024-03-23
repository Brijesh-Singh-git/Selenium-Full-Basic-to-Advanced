package Keyboard_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Keyboard {
    public static void main(String[] args) {

            WebDriver driver;

            System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
            driver = new EdgeDriver();

            driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

            driver.get("https://text-compare.com/");

            //Text area
            driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome to Automation Tutorial");

            Actions act = new Actions(driver);

            //CTRL + A
            act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

            //CTRL + C
            act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

            //TAB
            //act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
            act.sendKeys(Keys.TAB).perform();  // Only if we want to press the single key

            //CTRL + V
            act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();



    }
}
