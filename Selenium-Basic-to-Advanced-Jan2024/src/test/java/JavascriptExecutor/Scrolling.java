package JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Scrolling {
    public static void main(String[] args) {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
        driver.manage().window().maximize();
    }
}
