package day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends TestBaseBeforeAfter {
    /*
    1- https://www.facebook.com adresine gidelim
    2- Yeni hesap olustur butonuna basalim
    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    4- Kaydol tusuna basalim
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isim=driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Caner");
        Thread.sleep(500);
        actions.sendKeys(Keys.TAB)
                .sendKeys("Karakoyun")
                .sendKeys(Keys.TAB)
                .sendKeys("caner@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("caner@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("sifre123")
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
