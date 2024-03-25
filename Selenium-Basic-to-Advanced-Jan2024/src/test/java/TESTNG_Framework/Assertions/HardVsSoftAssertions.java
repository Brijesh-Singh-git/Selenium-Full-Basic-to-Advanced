package TESTNG_Framework.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

    @Test
    void HardAssertions(){

        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");

        Assert.assertEquals(1,2);

        System.out.println("Assertion is Completed!!!!");
    }

    @Test
    void SoftAssertions(){

        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");
        System.out.println("Testing .......");

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1,4);


        System.out.println("Soft Assertion is Completed!!!!");
        System.out.println("Soft Assertion is Completed!!!!");

        sa.assertAll(); //mandatory


    }
}
