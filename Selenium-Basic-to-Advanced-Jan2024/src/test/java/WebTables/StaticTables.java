package WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaticTables {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1. Find total no of rows
        //2. Find total no of cols
        //3. Read specific row and columns
        //4. Read data from all the rows and columns
        //5. Print book names written by Amit
        //6. To calculate the sum of prices for all the books


        //1. Find total no of rows
        //Approach 1
        //List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("No of Rows: " + rows);

        //Approach 2
        //By tag name "tr" --> only be followed when we have only single table
        int rows1 = driver.findElements(By.tagName("tr")).size();
        System.out.println("No of Rows: " + rows1);




        //2. Find total no of columns
        //List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th"));
        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
        System.out.println("No of Columns: " + cols);




        //3. Read specific row and columns
        String data1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[2]")).getText();
        System.out.println(data1);




        //4. Read data from all the rows and columns
        for(int r=2; r<=rows ; r++){
            for(int c=1; c<=cols; c++){
                String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print("  " + value + "  ");
            }
            System.out.println();
        }




        //5. Print book names written by Amit
        for(int r=2; r<=rows ; r++){
                String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();

                if(author.equals("Amit")){
                    String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                    System.out.println("Book Name:--> " + bookName);
                }

        }


        //6. To calculate the sum of prices for all the books
        int sum=0;
        for(int r=2; r<=rows ; r++){

            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();

            //convert string to int
            sum = sum + Integer.parseInt(price);
        }

        System.out.println("Total price of the books: " + sum);






        driver.quit();




    }
}