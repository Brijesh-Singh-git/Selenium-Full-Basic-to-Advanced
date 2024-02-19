package Alerts_PopUps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert_Authentication_popUp {
    public static void main(String[] args) {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        //Explicit Wait cux soemtimes the alert takes time to pop-up
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //https://the-internet.herokuapp.com/basic_auth
        //https://admin:admin@the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        driver.manage().window().maximize();

        String msg = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();

//        System.out.println(msg);

        if(msg.contains("Congratulations")){
            System.out.println("Successfull Login");
        }else {
            System.out.println("Login Failed!!");
        }


    }
}
