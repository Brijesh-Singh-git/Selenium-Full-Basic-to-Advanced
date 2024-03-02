package DatePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class datepcikerdemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0);

        /*
        //Approach 1 -- direct using the Send keys
        driver.findElement(By.id("datepicker")).sendKeys("10/15/2008"); //mm/dd//yyyy

         */

        //Approach 2

        String year = "2021";
        String month = "December";
        String date = "30";

        driver.findElement(By.id("datepicker")).click();

        //Select month and year
        while(true){

        String mon =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String yr =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if(mon.equals(month) && (yr.equals(year))){
                break;
            }

//            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Future Date
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Past Date

        }

        //Select dates
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for(WebElement dt : allDates){

            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }

        driver.quit();

    }
}
