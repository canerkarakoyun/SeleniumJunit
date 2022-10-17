package day12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C02_FileExistUpload extends TestBaseBeforeAfter {
    /*
    Tests packagenin altina bir class oluşturun : C05_UploadFile
    https://the-internet.herokuapp.com/upload adresine gidelim
    chooseFile butonuna basalim
    Yuklemek istediginiz dosyayi secelim.
    Upload butonuna basalim.
    “File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        // chooseFile butonuna basalim
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */

        // Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\IBO_K\\Desktop\\Test.txt";
        dosyaSec.sendKeys(dosyaYolu);
        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        // “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='example']")).isDisplayed());
    }
}
