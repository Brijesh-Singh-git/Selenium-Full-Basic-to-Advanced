package TESTNG_Framework.Parallel_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class parallelTest {


    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String br, String appurl) throws InterruptedException {

        if (br.equals("edge")) {
            WebDriverManager .edgedriver().setup();
            driver = new EdgeDriver();
        }else if(br.equals("chrome")){
            WebDriverManager .chromedriver().setup();
            driver = new EdgeDriver();
        }else {
            WebDriverManager .firefoxdriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(appurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    void testLogo(){

        try{
            boolean logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']/img")).isDisplayed();
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
