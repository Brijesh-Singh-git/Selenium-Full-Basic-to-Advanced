package Invocation_Count;

import org.testng.annotations.Test;

public class Count {

    @Test(invocationCount = 10)
    void test(){
        System.out.println("Testing.....");
    }
}
