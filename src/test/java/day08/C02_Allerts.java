package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sitesine girdigimizde ya da sitede bir butona tikladigimizda karsimiza bir uyari mesaji cikabilir.
    Eger bu uyariya incele (inspect) yapabiliyorsak HTML Allert'dir, istedigimiz gibi locate edebiliriz.

    Ancak allert kutusuna sag-clik ile mudahale edip inceleme (inspect) yapamiyorsak JavaScript alerttir.

    JS allertlere mudahale etmek icin;
    - Tamam'i tiklamak icin             -> driver.swithTo().alert().accept()
    - Iptal etmek icin                  -> driver.swithTo().alert().dismiss()
    - Alert icindeki mesaji almak icin  -> driver.swithTo().alert().getText()
    - Alert kutusuna mesaj gondermek icin -> driver.swithTo().alert().sendKey("text")

    kullanilir.
     */

    /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin. Alert üzerindeki mesajı yazdırınız
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    */
    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
    driver.switchTo().alert().accept();
    String expectedMessage="You successfully clicked an alert";
    String actualMessage=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        String actualResultMessage = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertFalse(actualResultMessage.contains("successfuly"));

    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("caner karakoyun");
        driver.switchTo().alert().accept();
        String actualResultMessage = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actualResultMessage.contains("caner karakoyun"));
    }
}
