package day16;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // Asagidaki carreers butonunu gorunceye kadar JSExecutor ile scroll down yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement careers= driver.findElement(By.xpath("//*[text()='Careers']"));
        jse.executeScript("arguments[0].scrollIntoView(true)",careers);
        // Carriers butonuna JS ile click yapalim
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();",careers);

    }
}
