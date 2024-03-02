package DatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Datepciker_demo2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//input[@id='dob']")).click();

        WebElement drpMonthElement = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

        Select drpmonth = new Select(drpMonthElement);
        drpmonth.selectByIndex(5);

        Thread.sleep(2000);

        WebElement drpYearElement = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        Select drpYear = new Select(drpYearElement);
        drpYear.selectByIndex(10);



    }
}
