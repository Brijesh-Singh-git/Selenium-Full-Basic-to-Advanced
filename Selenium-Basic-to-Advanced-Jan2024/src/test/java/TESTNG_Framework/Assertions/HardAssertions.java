package TESTNG_Framework.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

    @Test
    void test(){
        int x=20;
        int y =30;

        /*

        if(x==y){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

         */

        //Assert.assertEquals(x,y);
        //Assert.assertTrue(true); //passed
        //Assert.assertTrue(false); //failed
        //Assert.assertFalse(false); //passed
        //Assert.assertEquals(x>y,true,"x is not greater than y"); //false


        String s1 = "abc";
        String s2 = "abc";

        //Assert.assertEquals(s1,s2, "Strings are equal");
        //Assert.assertNotEquals(s1,s2,"Strings are not equal");

        if(false){
            Assert.assertTrue(true);
        }else {
            //Assert.assertTrue(false);
            Assert.fail();  // It will directly fail the test method
        }




    }


}
