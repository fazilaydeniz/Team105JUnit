package myPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;
import java.util.Set;

public class C21_WindowHandleHomeworkS153 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkSayfaUrl=driver.getCurrentUrl();
        //2."Login Portal" a kadar asagi inin
        // 1.yol
        Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(3000);
        // 2.yol
        WebElement loginPort=driver.findElement(By.id("login-portal"));
        loginPort.click();
        loginPort.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.bekle(3);
        String  ilksayfaWHD =driver.getWindowHandle();
        //3."Login Portal" a tiklayin
        // driver.findElement(By.id("login-portal")).click();
        // Thread.sleep(3000);
        Set<String > whDegerleri = driver.getWindowHandles();
        String ikinciWHD="";
        for (String each:whDegerleri
        ) {if(!each.equals(ilksayfaWHD)){
            ikinciWHD=each;
        }
        }
        //4.Diger window'a gecin
        driver.switchTo().window(ikinciWHD);
        ReusableMethods.bekle(3);
        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Huseyin");
        actions.sendKeys(Keys.TAB).
                sendKeys("Hsyn.1234").perform();
        ReusableMethods.bekle(3);
        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        ReusableMethods.bekle(3);
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopup = "validation failed";
        String actualPopup =driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopup,actualPopup);
        ReusableMethods.bekle(3);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(3);
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilksayfaWHD);
        //10.Ilk sayfaya donuldugunu test edin
        String BulundugumUrl=driver.getCurrentUrl();
        Assert.assertEquals(BulundugumUrl,ilkSayfaUrl);
    }
}

