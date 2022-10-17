package day15;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        // Amazon sayfasina gidelim ve tum sayfanin resmini alalim.
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        /*
        Bir web sayfasinin resmini alabilmek icin TakesScreenShot class'indan obje olusturup
        gecici bir file class'indan degiskene TakesScreenShot'dan olusturdugum obje'den getScreenShotAs()
        methodunu kullanarak gecici bir file olustururuz.
         */

        TakesScreenshot ts= (TakesScreenshot) driver;
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
    }
}
