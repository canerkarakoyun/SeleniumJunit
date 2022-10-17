package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    @Before
    // Before notasyonu her testten once calisir
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    // After notasyonu her testten sonra calisir
    public void tearDown() {
        driver.close();
    }

    @Test
    public void method1() {
        // burada bir defa Before methodu calisir
        driver.get("https://amazon.com");
        // burada bir defa after calisir
    }

    @Test
    public void method2() {
        // burada bir defa Before methodu calisir
        driver.get("https://techproeducation.com");
        // burada bir defa after calisir
    }
}
