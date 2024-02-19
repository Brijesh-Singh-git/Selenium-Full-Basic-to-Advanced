package Alerts_PopUps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert_with_InputBox {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        //Explicit Wait cux soemtimes the alert takes time to pop-up
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);

        Alert alrtWindow = myWait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alrtWindow.getText());
        Thread.sleep(3000);

        alrtWindow.sendKeys("welcome");
        Thread.sleep(3000);
        alrtWindow.accept();

        //validation

        String act_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println(act_text);
        String exp_text = "You entered: welcome";


        if(act_text == exp_text){
            System.out.println("Test is Passed!!!");
        } else  {
            System.out.println("Test got failed !!!");
        }

    }
}
