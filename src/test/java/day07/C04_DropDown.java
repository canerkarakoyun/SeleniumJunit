package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //Tüm dropdown değerleri(value) yazdırın
    //Dropdowun boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın.

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
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //driver.findElement(By.xpath("//*[text()='Option 1']")).click();
        WebElement ddmlist=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddmlist);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================================");

        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //driver.findElement(By.xpath("//*[text()='Option 2']")).click();
        Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================================");

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("=========================================");

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmList=select.getOptions();
        ddmList.forEach(t-> System.out.println(t.getText()));

        //Dropdowun boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int expectedSize=4;
        int actualSize= ddmList.size();
        if (actualSize==expectedSize){
            System.out.println("True");
        } else System.out.println("False");
        Assert.assertNotEquals(actualSize,expectedSize);
    }

}
