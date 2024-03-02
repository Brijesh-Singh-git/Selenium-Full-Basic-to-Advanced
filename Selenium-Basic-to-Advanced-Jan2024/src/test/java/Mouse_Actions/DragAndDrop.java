package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {
    public static void main(String[] args) {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

       WebElement rome = driver.findElement(By.id("box6"));
       WebElement italy = driver.findElement(By.id("box106"));

       act.dragAndDrop(rome,italy).perform();

       WebElement seoul = driver.findElement(By.id("box5"));
       WebElement korea = driver.findElement(By.id("box105"));

       act.dragAndDrop(seoul, korea).perform();

    }
}
