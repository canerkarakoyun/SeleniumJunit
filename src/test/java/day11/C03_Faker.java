package day11;

import Utilities.TestBaseBeforeClassAfterClass;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Faker extends TestBaseBeforeClassAfterClass {
        /*
        1-"https://facebook.com"  Adresine gidin
        2-"create new account"  butonuna basin
        3-"firstName" giris kutusuna bir isim yazin
        4-"surname" giris kutusuna bir soyisim yazin
        5-"email" giris kutusuna bir email yazin
        6-"email" onay kutusuna emaili tekrar yazin
        7-Bir sifre girin
        8-Tarih icin gun secin
        9-Tarih icin ay secin
        10-Tarih icin yil secin
        11-Cinsiyeti secin
        12-Kaydol butonuna basın
        13-Sayfayi kapatin
         */
    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Faker faker=new Faker();
        String email=faker.internet().emailAddress(); // ayni mail adresini iki kere girebilmesi icin
                                                      // String bir degiskene atama yaptik
        /*
        Faker class'ini kullanabilmek icin mvnrepository kutuphanesinden Java Faker aratip
        en cok kullanilani pom.xml dosyamiza ekleriz.
        Faker class'indan bir obje olusturup;
        isim icin       -> faker().name().firstname()
        Soyisim icin    -> faker().name().lastname()
        Email icin      -> faker().internet().emailAddress()
        Password icin   -> faker().internet().password()

        ve benzeri daha bir cok sey kullanabiliriz.

        Form doldurmamiz gereken sitelerde defalarca bizim icin fake veri olusturarak hesap girisi yapar.

        Password ya da e-mail gibi verify edilmesi gereken verileri String bir variable olusturup atama yapar
        bu variable'i gireriz direkt.
         */
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(isim)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("30")
                .sendKeys(Keys.TAB)
                .sendKeys("Temmuz")
                .sendKeys(Keys.TAB)
                .sendKeys("1983")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
