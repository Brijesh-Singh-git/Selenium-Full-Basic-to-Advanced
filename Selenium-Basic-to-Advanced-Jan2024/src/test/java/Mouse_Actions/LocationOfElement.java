package Mouse_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class LocationOfElement {
    public static void main(String[] args) {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));

        System.out.println("Before maximizing the window: " + logo.getLocation()); //(252, 54)

        driver.manage().window().maximize();
        System.out.println("After maximizing the window: " + logo.getLocation()); //(385, 40)

        driver.manage().window().minimize();
        System.out.println("After minimizing the window: " + logo.getLocation()); //(385, 40)

        driver.manage().window().fullscreen();
        System.out.println("After fullscreen the window: " + logo.getLocation()); //(408, 78)

        Point p = new Point(100,100);
        driver.manage().window().setPosition(p);
        System.out.println("After setting the point resolution to 100 * 100: " + logo.getLocation()); //(252, 40)




    }
}
