package CheckBoxes;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class checkBox {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();

        //Select only 1 check box
//        driver.findElement(By.xpath("//input[@id='sunday']")).click();
//
//        driver.findElement(By.xpath("//input[@id='monday']")).click();


        //Total no of checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
        System.out.println("Total no of checkboxes are: " + checkboxes.size());
        Thread.sleep(4000);

        //Select all the checkboxes in a multiple shot

       /* for(int i=0; i<checkboxes.size(); i++){

            checkboxes.get(i).click();
        }

        */


      /*  for(WebElement check  :checkboxes){

            check.click();
        }


        Thread.sleep(4000);

       */


        //Select last 2 checkboxes
        //Total no of checkboxes - how mnay checkboxes to be seletced  = Starting index
        //7-2=5 (Starting index)

       /* for(int i=5;i <checkboxes.size(); i++){
            checkboxes.get(i).click();
        }

        */

        //To select the first  checkboxes
    /*    for(int i=0; i<checkboxes.size()-5 ; i++){
            checkboxes.get(i).click();
        }

     */


        //clear/unclear all the checkboxes

 /*       for(WebElement check  :checkboxes){

            check.click();
        }
        Thread.sleep(2000);
        for(WebElement check  :checkboxes){

            check.click();
        }

  */


        //Selected 3 checkboxes and unselect only  checkboxes

        for(int i=0;i <3; i++){
            checkboxes.get(i).click();
        }
        Thread.sleep(3000);

        for(int i=0;i <checkboxes.size(); i++){
            if(checkboxes.get(i).isSelected())
            checkboxes.get(i).click();
        }



//        driver.quit();





    }
}
