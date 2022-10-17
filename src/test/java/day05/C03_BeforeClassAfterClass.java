package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak olusturacagimiz method'u static yapmamiz gerekiyor
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void method1(){
        driver.get("https://amazon.com");
    }
    @Test
    @Ignore
    /*
    Calismasini istemedigimiz test icin @Ignore notasyonu kullanmamiz yeterlidir.
    @Ignore("Aciklama") seklinde de kullanilabilir
     */
    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
    }
}
