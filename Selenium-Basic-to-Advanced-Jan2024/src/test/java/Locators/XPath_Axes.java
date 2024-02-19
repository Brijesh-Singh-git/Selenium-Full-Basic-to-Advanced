package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class XPath_Axes {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        System.setProperty("webdriver.edge.driver", "driver.exe");
        driver = new EdgeDriver();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        Thread.sleep(4000);

        //Self node --> Select the current node
        String s1 = driver.findElement(By.xpath("//a[contains(text(),'IFCI Ltd.')]/self::a")).getText();
        System.out.println("Self Node: " + s1);

        //Parent node ---> It will be always one
        String s2 = driver.findElement(By.xpath("//a[contains(text(),'IFCI Ltd.')]/parent::td")).getText();
        System.out.println("Parent Node: " + s2);

        //Child node --> Select all the children of the current node
        List <WebElement> s3 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/child::td"));
        System.out.println("No of Child elements: " + s3.size());

        //Ancestor -- Selects all ancestors(Parent, granparents etc)
        String s4 = driver.findElement(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr")).getText();
        System.out.println("Ancestor: " + s4);

        //Descendant --> Selects all descendants(Children, grandchildren, etc)
        List <WebElement> s5 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/descendant::*"));
        System.out.println("No of Descendent elements: " + s5.size());

        //Following --> Selects everything in the documnet after the closing tag of the current node
        List <WebElement> s6 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/following::tr"));
        System.out.println("No of Following elements: " + s6.size());

        //Following-siblings --> Selects all siblings after the current node
        List <WebElement> s7 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/following-sibling::tr"));
        System.out.println("No of Following-siblings elements: " + s7.size());

        //Preceding --> Selects all node that appear before the current node in the document
        List <WebElement> s8 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/preceding::tr"));
        System.out.println("No of Preceding elements: " + s8.size());

        //Preceding-sibling --> Selects all siblings before the current node
        List <WebElement> s9 = driver.findElements(By.xpath("//a[contains(text(),'IFCI Ltd.')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("No of Preceding-sibling elements: " + s9.size());



        driver.quit();




    }



}
