package day10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // Amazon sayfasina gidelim
        // Account menusunden create a list linkine tiklayalim
        driver.get("https://amazon.com");
        WebElement accountList= driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions action=new Actions(driver);
        action.moveToElement(accountList).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
