package day06;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class C03_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void test02(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test03(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());
    }
    @Test
    public void test04(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
    }
}
