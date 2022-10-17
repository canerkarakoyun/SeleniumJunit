package day16;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        // Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // Arama sonucunun ekran resmini alalim
        /*
        Goruntusunu almak istedigimiz web elementi locate ederek bir WebElement variable'a atama yapariz.
        Ardindan bu variable ile .getScreenShotAs() methodunu kullanarak gecici bir file'a alip, ardindan
        FileUtil.copyFile() ile asagidaki gibi kaydedebiliriz.
         */
        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu, new File("target//ekranGoruntusu//WebESS.jpeg"));
    }
}
