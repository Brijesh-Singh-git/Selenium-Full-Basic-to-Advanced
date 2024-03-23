package JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Scrolling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Approach 1 --> Scroll down using Excel
//        js.executeScript("window.scrollBy(0,750)", "");
//        System.out.println(js.executeScript("return window.pageYOffset;")); //750



        //Approach 2 --> Scroll down the page till the element is present
//        WebElement flag = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Table']"));
//
//        js.executeScript("arguement[0].scrollIntoView();", flag);
//        System.out.println(js.executeScript("return window.pageYOffset;"));


        //Scroll till end of the page
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));

        Thread.sleep(2000);


        //Go back to intial position
        js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));


    }
}
