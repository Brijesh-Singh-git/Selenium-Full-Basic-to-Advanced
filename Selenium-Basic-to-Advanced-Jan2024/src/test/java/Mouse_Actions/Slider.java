package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Slider {
    public static void main(String[] args) {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/#google_vignette");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
        System.out.println("Cuurent Location of Min-Slider: " + min_slider.getLocation());

        act.dragAndDropBy(min_slider, 100,0).perform();
        System.out.println("Cuurent Location of Min-Slider: " + min_slider.getLocation());



        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        System.out.println("Cuurent Location of Max-Slider: " + max_slider.getLocation());

        act.dragAndDropBy(max_slider, -150,0).perform();
        System.out.println("Cuurent Location of Max-Slider: " + max_slider.getLocation());


//        driver.quit();
    }
}
