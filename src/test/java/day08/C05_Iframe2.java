package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_Iframe2 {
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
    public void test1(){
        driver.get("https://html.com/tags/iframe");
        /*
        Bir web sitesinde bir video (youtube vs) varsa bunu direkt calistirmak mumkun..
        Ancak video linki degistiginde kodumuz patlar.

        Vide linki <iframe> tagi icerisinde ise link sw'tchTo() ile .frame() yapariz. Oncesinde WebElement
        olusturup bunun icerisine atariz, ondan sonra play tusunu locate edip .click() yapariz.

        Bir yontem de asagidaki gibi tum fram'leri bir array list'e atip 0. elementi cagirarak yapilabilir.
         */
        List<WebElement> frameList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(frameList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }
}
