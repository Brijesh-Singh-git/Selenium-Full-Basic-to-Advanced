package POM_Structure.Normal_Approach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;



    //Constructor
    LoginPage(WebDriver driver){
        this.driver = driver;
    }




    //Locators
    By logo_img = By.xpath("//div[@class='orangehrm-login-branding']/img");
    By txt_username = By.xpath("//input[@placeholder='Username']");
    By txt_password = By.xpath("//input[@placeholder='Password']");

    By btn_submit = By.xpath("//button[@type='submit']");





    //Action Methods
    public void setUsername(String username){
        driver.findElement(txt_username).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }

    public void submitBtn(){
        driver.findElement(btn_submit).click();
    }
    public boolean checkLogoPresence(){
        boolean status = driver.findElement(logo_img).isDisplayed();
        return status;
    }

}
