package TESTNG_Framework.Annotations;

import org.testng.annotations.*;

public class Annotations {


    //@BeforeSuite -- > @BeforeTest --> @BeforeClass --> @BeforeMethod --> @Test --> @AfterMethod --> @AfterClass --> @AfterTest --> @AfterSuite

    @BeforeSuite
    public void test1(){
        System.out.println(" This is Before Suite");
    }
    @BeforeMethod
    public void test2(){
        System.out.println(" This is Before Method");
    }
    @BeforeClass
    public void test3(){
        System.out.println(" This is Before Class");
    }
    @BeforeTest
    public void test4(){
        System.out.println(" This is Before Test");
    }
    @Test
    public  void testMain(){
        System.out.println("This is the Main test!!");
    }
    @AfterTest
    public void test5(){
        System.out.println("This is After Test ");
    }
    @AfterClass
    public void test6(){
        System.out.println("This is After Class ");
    }
    @AfterMethod
    public void test7(){
        System.out.println("This is After Method ");
    }
    @AfterSuite
    public void test8(){
        System.out.println("This is After Suite");
    }





}
