package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C05_Odev {
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
        driver.get("https://automationpractice.com/index.php");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("canerkarakoyun");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed();
    }

}
