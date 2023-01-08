package myPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;
import java.util.TreeSet;

public class C17_ActionsS128 extends TestBase {

    @Test
    public void test01() {
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions action = new Actions(driver);
        WebElement cizilialan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        action.contextClick(cizilialan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertYazisi = driver.switchTo().alert().getText();
        String expectedAlertYazisi = "You selected a context menu";
        Assert.assertEquals(actualAlertYazisi, expectedAlertYazisi);
        ReusableMethods.bekle(5);
        String ilkSayfaWHD = driver.getWindowHandle();
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        System.out.println(ilkSayfaWHD);
        ReusableMethods.bekle(3);
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> ikisayfaninWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD :ikisayfaninWHD) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }
        ReusableMethods.bekle(3);
        driver.switchTo().window(ikinciSayfaWHD);
        String expectedYeniSayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);
        ReusableMethods.bekle(5);


    }
}

