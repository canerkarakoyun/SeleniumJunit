package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim ve Click for JS Allerts
    butonuna tiklayalim.
    - Tikladiktan sonra cikan uyari mesajina (allerte) tamam diyelim
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
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept(); // cancel yapmak istiyorsak .dismiss() ile bitiriyoruz

    }
}
