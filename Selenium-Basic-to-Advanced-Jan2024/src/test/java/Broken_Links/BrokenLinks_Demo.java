package Broken_Links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks_Demo {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "Drivers/msedgedriverlatest.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();


        //Capture all the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of Links: " + links.size());  //48


        int brokenLinks =0;

        for(WebElement linkEle:links){
            String targetLink = linkEle.getAttribute("href");
            System.out.println(targetLink);


            //pre-requisite for checking the broken links
            if(targetLink == null || targetLink.isEmpty()){
                System.out.println("It is is a Broken Link !!!");
                continue;
            }


            //checking link is broken or not
            URL linkurl = new URL(targetLink); //convert String to ---> URL Format

            //send request to server -- open, connect
            HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();

            conn.connect();

            if(conn.getResponseCode()>=400){
                System.out.println(targetLink + "      " + "=====>  Broken Link ");
                brokenLinks++;
            }
            else {
                System.out.println(targetLink + "      " + "=====>  Not a Broken Link ");

            }

        }
        System.out.println("Total number of Broken Links: " + brokenLinks);


        driver.quit();
    }
}
