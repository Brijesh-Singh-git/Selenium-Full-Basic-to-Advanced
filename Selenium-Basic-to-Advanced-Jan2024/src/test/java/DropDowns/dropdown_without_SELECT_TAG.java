package DropDowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdown_without_SELECT_TAG {
    public static void main(String[] args) {


        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
//      driver.get("https://demoqa.com/checkbox");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@type='button']")).click();

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label"));

        //Find total no of options
        System.out.println("Total no fo Options: "  + options.size());

        //Print all the options
       /* for(int i=0 ; i<options.size() ; i++){
            System.out.println(options.get(i).getText());
        }

        */

        //Select options from the dropdown
      /*  for(int i=0 ; i<options.size() ; i++){

            String option = options.get(i).getText();

            if(option.equals("Java") && option.equals("Python") ){
                options.get(i).click();
                break;
            }

       */

        for(WebElement opt : options){

            String text = opt.getText();
            if(text.equals("Java") || text.equals("Python")){
                opt.click();
            }
        }





    }
}
