package WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicTables {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);
        //Dialog box pop up
        if(driver.findElement(By.xpath("//h5[normalize-space()='Important Security Notification!']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        }

        Thread.sleep(2000);

        //Customer page click
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
        Thread.sleep(2000);


        //Check the total no of pages
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText(); // Showing 1 to 10 of 18166 (1817 Pages)

        int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));

        System.out.println("Total no of Pages: " + total_pages);

        for(int p=1; p<=5 ; p++){   //for(int p=1; p<=total_pages ; p++)
            if(total_pages>1){
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li/*[text()="+p+"]"));
                System.out.println("Active Page: " + active_page.getText());
                active_page.click();
                Thread.sleep(4000);
            }

            int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Total no of rows on Active Page: " + noOfRows);

            for(int r=1; r<=noOfRows ; r++){
                String custName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
                String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
                String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();

                System.out.print(custName + "              "  + email + "                " + status);
            }
            System.out.println();
        }

        driver.quit();


    }
}
