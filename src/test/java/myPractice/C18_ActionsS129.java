package myPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C18_ActionsS129 extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement DropMeYazisi= driver.findElement(By.id("draggable"));
        WebElement DropHereYazisi=driver.findElement(By.xpath("//p[text()='Drop here']"));
        Actions action=new Actions(driver);
        action.clickAndHold(DropMeYazisi).perform();
        action.dragAndDrop(DropMeYazisi,DropHereYazisi).perform();
        ReusableMethods.bekle(5);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       String droppedYazisi=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        Assert.assertTrue(droppedYazisi.contains("Dropped!"));
    }

}
