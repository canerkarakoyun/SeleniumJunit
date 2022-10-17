package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    /*
           ●https://www.amazon.com/ adresinegidin.
           -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
           oldugunu testedin
           -Test2
           1.Kategori menusunden Books seceneginisecin
           2.Arama kutusuna Java yazin vearatin
           3.Bulunan sonuc sayisiniyazdirin
           4.Sonucun Java kelimesini icerdigini testedin
     */
    static WebDriver driver;
    Select select;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        // oldugunu testedin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz WebElementi'ni select class'ina tanimlariz ve
        getOption() methodunu kullanarak DropDown'u bir liste atarak DropDown
        menunun butun elemanlarinin sayisina ulasabiliriz.
         */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualDds=ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDds);
    }
    @Test
    public void test02(){
        // 1.Kategori menusunden Books seceneginisecin
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        select.selectByVisibleText("Books");
        // 2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
        // 4.Sonucun Java kelimesini icerdigini testedin
        String expectedValue="Java";
        String actualSonucYazisi= sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedValue));
        /*
        DropDown menude sectigimiz option'a ulasmak istersek select.getFirstSelectedOption()
        methodunu kullaniriz.
         */

    }
}
