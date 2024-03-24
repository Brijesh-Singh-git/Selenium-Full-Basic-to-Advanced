package DataDriven_Testing_UtilFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FixedDepositCalcualtor {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver;

        System.getProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
        driver.manage().window().maximize();

        String File = System.getProperty("user.dir")+ "\\TestData\\FixedDeposit Data.xlsx";

        //Row Count
        int rows=Excel_Utils.getRowCount(File, "Sheet1");


        for(int i=1;i<=rows;i++)
        {
            //read data from excel
            String princ=Excel_Utils.getCellData(File,"Sheet1",i,0);
            String rateofinterest=Excel_Utils.getCellData(File,"Sheet1",i,1);
            String per1=Excel_Utils.getCellData(File,"Sheet1",i,2);
            String per2=Excel_Utils.getCellData(File,"Sheet1",i,3);
            String fre=Excel_Utils.getCellData(File,"Sheet1",i,4);
            String exp_mvalue=Excel_Utils.getCellData(File,"Sheet1",i,5);


            //pass data to the app
            driver.findElement(By.id("principal")).sendKeys(princ);
            driver.findElement(By.id("interest")).sendKeys(rateofinterest);
            driver.findElement(By.id("tenure")).sendKeys(per1);

            Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
            perdrp.selectByVisibleText(per2);

            Select fredrp=new Select(driver.findElement(By.id("frequency")));
            fredrp.selectByVisibleText(fre);

            JavascriptExecutor js=(JavascriptExecutor)driver;
            WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
            js.executeScript("arguments[0].click();",calculate_btn);  // clicking on calculate button

            //validation & update results in excel
            String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
            {
                System.out.println("Test Passsed");
                Excel_Utils.setCellData(File, "Sheet1",i,7,"Passed");
                Excel_Utils.fillGreenColor(File, "Sheet1",i,7);
            }
            else
            {
                System.out.println("Test Failed");
                Excel_Utils.setCellData(File, "Sheet1",i,7,"Failed");
                Excel_Utils.fillRedColor(File, "Sheet1",i,7);
            }
            Thread.sleep(3000);

            WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
            js.executeScript("arguments[0].click();",clear_btn);  // clicking on clear button


        }



        driver.quit();


    }
}
