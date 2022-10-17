package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class C02_Assertion {
        /*
    - Amazon sayfasına gidelim
    3 farklı test methodu oluşturalım
      a-Url'nin amazon içerdiğini test edelim
      b-Title'in facebook içermediğini test edelim
      c- sol üst köşede amazon logosunun göründüğünü test edelim
      d- Url'nin www.facebook.com olduğunu test edin
     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        driver.navigate().refresh();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test1(){
    // Url'nin amazon içerdiğini test edelim
        String exceptedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(exceptedUrl));
    }
    @Test
    public void test2(){
        // Title'in facebook içermediğini test edelim
        String expectedTitle="facebook";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        // sol üst köşede amazon logosunun göründüğünü test edelim
        Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
    }
    @Test
    public void test4(){
        // Url'nin www.facebook.com olduğunu test edin
        String expectedUrl="www.facebook.com";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertNotEquals(actualUrl,expectedUrl);
    }
}
