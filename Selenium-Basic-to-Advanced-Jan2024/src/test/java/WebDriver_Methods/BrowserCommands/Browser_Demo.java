package WebDriver_Methods.BrowserCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser_Demo {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Thread.sleep(2000);

        driver.quit();




    }
}
