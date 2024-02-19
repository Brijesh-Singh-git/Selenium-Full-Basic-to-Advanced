package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class NormalLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver = new EdgeDriver();
        Thread.sleep(5000);

        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(4000);

        //finding number of sliders
        List<WebElement> slider = driver.findElements(By.className("homeslider-container"));
        System.out.println("No of slider are: " + slider.size());

        //find the total images on page
        List <WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("No of images are: " + images.size());

        //find total no of links
        List <WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No of links are: " + links.size());


        driver.quit();


    }
}
