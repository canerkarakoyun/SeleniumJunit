package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_JunitCheckBox {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        Thread.sleep(2000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(1000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }

}
