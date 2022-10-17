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

public class C04_Iframe {
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
        //driver.close();
    }
    @Test
    public void test01(){
        // https://html.com/tags/iframe sitesine gidin
        // site icerisindeki youtube videosunu calistirin
        driver.get("https://html.com/tags/iframe");
        WebElement youtubeFrame = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }
}
