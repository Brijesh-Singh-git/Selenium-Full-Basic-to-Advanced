package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DoubleClick {
    public static void main(String[] args) {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult"); //switch to frame

        driver.findElement(By.xpath("//input[@id='field1']")).clear();
        driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Welcome to Programming");

        WebElement clickBtn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        Actions act = new Actions(driver);
        act.doubleClick().perform();

    }

}
