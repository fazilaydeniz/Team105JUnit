package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {
    @Test
    public void test01(){
       //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
       //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement draggMeElementi= driver.findElement(By.id("draggable"));
        WebElement birakilacakAlanElementi=driver.findElement(By.id("droppable")) ;

        Actions actions= new Actions(driver);
        actions.dragAndDrop(draggMeElementi,birakilacakAlanElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYaziElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertTrue(droppedYaziElementi.isDisplayed());
        ReusableMethods.bekle(5);
    }

}
