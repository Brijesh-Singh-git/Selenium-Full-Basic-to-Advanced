package WebDriver_Methods.getMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class GetMethods_demo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        String curentURL = driver.getCurrentUrl();
        System.out.println(curentURL);

        //System.out.println(driver.getPageSource());

        //System.out.println(driver.getWindowHandle());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windIds=driver.getWindowHandles();

        for(String windid : windIds){
            System.out.println(windid);
        }




        driver.quit();
    }
}
