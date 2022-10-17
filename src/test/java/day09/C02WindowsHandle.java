package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02WindowsHandle {
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
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        String amazonWindowHandle=driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        Thread.sleep(1500);
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        String aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonucu.contains("Java"));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement bestBuyLogo = driver.findElement(By.xpath("//*[@class='logo']"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
        //9- Sayfaları Kapatalım
    }
}
