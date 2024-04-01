package POM_Structure;

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
    LoginPage lp;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @Test (priority = 1)
    void testLogo(){
        lp = new LoginPage(driver);
        Assert.assertEquals(lp.checkLogoPresence(), true);

    }


    @Test (priority = 2)
    void testLogin() throws InterruptedException {

        lp.setUsername("Admin");
        lp.setPassword("admin123");
        lp.submitBtn();

        Thread.sleep(4000);

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

    }



    @AfterClass
    void tearDown(){

        driver.close();
    }
}
