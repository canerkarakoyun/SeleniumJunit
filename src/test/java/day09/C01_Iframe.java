package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

        WebElement textBox = driver.findElement(By.id("mce_0_ifr")); // Once frame'i locate ediyoruz
        driver.switchTo().frame(textBox); // ardindan bu yontemle frame'e geciyoruz
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));
        textBoxFrame.clear();
        Thread.sleep(2000);
        textBoxFrame.sendKeys("Merhaba dunya");

        driver.switchTo().defaultContent();
        WebElement elemental=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());
    }
}

