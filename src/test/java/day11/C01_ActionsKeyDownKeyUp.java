package day11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_ActionsKeyDownKeyUp extends TestBaseBeforeAfter {
    /*
    Bir Class olusturalim KeyboardActions1
    https://www.amazon.com sayfasina gidelim
    Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
    aramanin gerceklestigini test edin

     */

    @Test
    public void test1() {
    driver.get("https://www.amazon.com");
    driver.navigate().refresh();
        Actions actions=new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").
                keyDown(Keys.SHIFT). // shift'e bastik
                sendKeys("a").
                keyUp(Keys.SHIFT). // shift'i biraktik
                sendKeys("7").
                sendKeys("1").
                sendKeys(Keys.ENTER).
                perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());
    }
}
