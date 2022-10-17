package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowMultiHandle {
    /*
    Tests package’inda yeni bir class olusturun: WindowHandle2
    https://the-internet.herokuapp.com/windows adresine gidin.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    Click Here butonuna basın.
    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
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
    public void test01(){
        //    Tests package’inda yeni bir class olusturun: WindowHandle2
        //    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String herokuappWindoeHandle= driver.getWindowHandle();
        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText="Opening a new window";
        Assert.assertEquals(actualText,expectedText);
        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //    Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        System.out.println("Window Handle Degerleri: "+windowList);
        driver.switchTo().window(windowList.get(1));
        //    Acilan yeni pencerenin sayfa başlığının (title) “New Window”
        Assert.assertEquals(driver.getTitle(),"New Window");
        //    Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("New Window"));
        //    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }
}
