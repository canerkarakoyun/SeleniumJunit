package day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(cizgiliAlan).perform();
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Context Menu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualText=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        Assert.assertEquals(actualText, "Elemental Selenium");
    }
}
