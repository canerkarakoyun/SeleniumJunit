package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.time.Duration;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        // 2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        // 3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphones", Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        //WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        //System.out.println(sonucYazisi.getText());
        String [] sonucYazisi=driver.findElement
                (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"))
                .getText().split(" ");
        System.out.println("Samsung headphone icin arama sonuc sayisi: "+sonucYazisi[2]);
        // 5- Ilk urunu tiklayalim
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        // 6- Sayfadaki tum basliklari yazdiralim
        WebElement basliklarH1 = driver.findElement(By.tagName("h1"));
        WebElement basliklarH2 = driver.findElement(By.tagName("h2"));
        WebElement basliklarH3 = driver.findElement(By.tagName("h3"));
        System.out.print(basliklarH1.getText());
        System.out.println("");
        System.out.print(basliklarH2.getText());
        System.out.println("");
        System.out.print(basliklarH3.getText());

        // Sayfayi kapat
        Thread.sleep(2000);
        driver.close();

    }
}
