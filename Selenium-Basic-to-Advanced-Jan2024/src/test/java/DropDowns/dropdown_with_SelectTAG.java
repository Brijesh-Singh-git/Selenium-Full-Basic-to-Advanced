package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdown_with_SelectTAG {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();


        WebElement drpElement = driver.findElement(By.xpath("//select[@id='country']"));

        Select drpCountry = new Select(drpElement);
        drpCountry.selectByIndex(3);
        Thread.sleep(2000);

        drpCountry.selectByVisibleText("France");
        Thread.sleep(2000);

        drpCountry.selectByValue("australia");
        Thread.sleep(2000);


        //Find total options in the dropdown
        List<WebElement> options = drpCountry.getOptions();
        System.out.println("Total options are: " + options.size());

        //to print all the options in console
       /* for(int i=0; i<options.size() ; i++){
            System.out.println(options.get(i).getText());
        }

        */

        for(WebElement op :options){
            System.out.println(op.getText());
        }











    }
}
