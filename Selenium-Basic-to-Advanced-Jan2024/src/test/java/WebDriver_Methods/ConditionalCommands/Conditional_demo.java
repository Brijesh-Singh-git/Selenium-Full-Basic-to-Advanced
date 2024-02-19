package WebDriver_Methods.ConditionalCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Conditional_demo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        Boolean logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
        System.out.println("Logo status: " + logo);

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Display Status: " + inputBox.isDisplayed());
        System.out.println("Enabled Status: " + inputBox.isEnabled());



        WebElement male = driver.findElement(By.id("gender-male"));
        WebElement female = driver.findElement(By.id("gender-female"));
        System.out.println("Before Selection-----> ");
        System.out.println("Male radio: " + male.isSelected());
        System.out.println("Female radio: " + female.isSelected());

        System.out.println();

        female.click();
        System.out.println("After Selection-----> ");
        System.out.println("Male radio: " + male.isSelected());
        System.out.println("Female radio: " + female.isSelected());

        driver.quit();

    }
}
