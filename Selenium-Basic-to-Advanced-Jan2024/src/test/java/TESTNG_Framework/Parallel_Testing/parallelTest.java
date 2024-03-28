package TESTNG_Framework.Parallel_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class parallelTest {


    WebDriver driver;

    @BeforeClass
    void setup(){
        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void testLogo(){

        try{
            boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
            Assert.assertEquals(logo, true);
        } catch (Exception e){
            Assert.fail();
            System.out.println("Logo Element is not available !!!");
        }
    }

    @Test(priority = 2)
    void testHomePageTitle(){
        Assert.assertEquals(driver.getTitle(),"OrangeHRM", "Title did not matched!!!!" );

    }

    @AfterClass
    void tearDown(){

        driver.quit();
    }


}
