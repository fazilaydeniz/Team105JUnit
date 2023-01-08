package myPractice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C19_ActionsS130 extends TestBase {

    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountListElementi= driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        Actions action = new Actions(driver);
        action.moveToElement(accountListElementi).perform();
        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualYourListsYazisi=driver.findElement(By.id("my-lists-tab")).getText();
        String expectedYourListsYazisi="Your Lists";
        Assert.assertTrue(actualYourListsYazisi.contains(expectedYourListsYazisi));

    }
}
