package Day1;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {


    public static void main(String[] args) throws InterruptedException {
          WebDriver driver;

          System.setProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
          driver = new EdgeDriver();
          Thread.sleep(5000);

          driver.get("https://opensource-demo.orangehrmlive.com");
          Thread.sleep(4000);

          driver.findElement(By.name("username")).sendKeys("Admin");
          driver.findElement(By.name("password")).sendKeys("admin123");

          driver.findElement(By.xpath("//button[@type='submit']")).click();

          String act_title = driver.getTitle();
          String exp_title = "OrangeHRM";

          if(act_title.equals(exp_title)){
              System.out.println("Test case got passed");
          }else {
              System.out.println("Test Case got failed!!!!");
          }

          driver.quit();


    }
}
