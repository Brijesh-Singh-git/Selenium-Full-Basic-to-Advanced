package TESTNG_Framework.TestNG_Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class myListeners implements ITestListener {

//    https://testng.org/logging_and_results.html#_logging_listeners


    public void onTestStart(ITestResult result){
        System.out.println("Test is started .......");
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test got passed .......");

    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test got failed .......");

    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Test got skipped .......");

    }

    public void onFinish(ITestContext context){
        System.out.println("Test is Finished .......");

    }



}
