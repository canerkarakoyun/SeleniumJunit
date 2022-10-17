package day10;

import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01(){
        driver.get("https://amazon.com");
    }

}
