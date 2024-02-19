package Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FramesDemo {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

        //https://the-internet.herokuapp.com/basic_auth
        //https://admin:admin@the-internet.herokuapp.com/basic_auth

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();


        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);

        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Thi is Frame 1 demo");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();  //this is used to come out of frames


        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);

        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("This is frame 3 demo !!!");

        WebElement frameInsideFrame = driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        driver.switchTo().frame(frameInsideFrame);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
        driver.findElement(By.xpath("//div[@id='i22']//div[@class='uHMk6b fsHoPb']")).click();

        Thread.sleep(3000);
        driver.quit();
    }

}
