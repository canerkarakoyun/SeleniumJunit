package day13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_WebTablesBAKBUNA extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();
        // Bir onceki class'daki adrese gidelim
        // login() methodnu kullanarak sayfaya giriş yapalım
        // input olarak verilen satır sayısı ve sütun sayisina sahip hücredeki text'i yazdiralim

        int satir = 3;
        int sutun = 4;
        WebElement cell= driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(cell.getText());

    }
}
