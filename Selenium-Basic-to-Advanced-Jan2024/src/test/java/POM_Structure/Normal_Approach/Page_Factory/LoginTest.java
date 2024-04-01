package POM_Structure.Normal_Approach.Page_Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage lp2;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @Test (priority = 1)
    void testLogo(){
        lp2 = new LoginPage(driver);
        Assert.assertEquals(lp2.checkLogoPresence(), true);

    }


    @Test (priority = 2)
    void testLogin() throws InterruptedException {

        lp2.setUsername("Admin");
        lp2.setPassword("admin123");
        lp2.submitBtn();

        Thread.sleep(4000);

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

    }



    @AfterClass
    void tearDown(){

        driver.close();
    }
}
