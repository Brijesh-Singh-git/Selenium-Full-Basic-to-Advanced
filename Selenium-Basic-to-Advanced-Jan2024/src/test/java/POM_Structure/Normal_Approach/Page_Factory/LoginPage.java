package POM_Structure.Normal_Approach.Page_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {


    //By using the Page Factory
    WebDriver driver;



    //Constructor
    LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    //Locators
    @FindBy(xpath = "//div[@class='orangehrm-login-branding']/img")
    WebElement logo;
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement txt_username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn_submit;


    @FindBy(tagName = "a")
    List<WebElement> links;




    //Action Methods
    public void setUsername(String username){
       txt_username.sendKeys(username);
    }

    public void setPassword(String password){
        txt_password.sendKeys(password);
    }

    public void submitBtn(){
        btn_submit.click();
    }
    public boolean checkLogoPresence(){
        boolean status = logo.isDisplayed();
        return status;
    }

    

}
