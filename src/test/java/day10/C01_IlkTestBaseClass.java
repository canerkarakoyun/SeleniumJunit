package day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void Test01(){
        driver.get("https://amazon.com");
    }
}
