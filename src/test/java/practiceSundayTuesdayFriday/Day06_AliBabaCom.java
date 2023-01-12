package practiceSundayTuesdayFriday;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day06_AliBabaCom extends TestBase {

    @Test
            public void aliBabaTest() throws InterruptedException {
        driver.get("https://www.alibaba.com/");
        String ilksayfahandle = driver.getWindowHandle();
        //cookies i kabul edin veya reddedin
        driver.findElement(By.xpath("//*[text()='Reject']")).click();
        Actions actions = new Actions(driver);
        WebElement shipto = driver.findElement(By.xpath("(//label[@class='ellipsis'])[3]"));
        actions.moveToElement(shipto).clickAndHold(shipto).perform();
        Thread.sleep(1000);
        WebElement country = driver.findElement(By.xpath("//div[@data-role='select-country']"));
        actions.moveToElement(country).click(country).perform();
        Thread.sleep(1000);
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@placeholder='Enter keyword to search.']"));
        actions.sendKeys(aramakutusu, "Turkey").perform();
        driver.findElement(By.xpath("(//li[@data-value='TR'])[1]")).click();
        driver.findElement(By.xpath("(//button[@data-role='save'])[3]")).click();
        Thread.sleep(2500);
        //sayfanin en altina inerek dil olarak turkceyi secelim
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Türk']")).click();
        //categori kismina giderek tarim seceneginin ustune gelelim ve acilan yan sayfadan tarim ekipmanlarini secelim
        WebElement kategori = driver.findElement(By.xpath("(//h3[@class='header-category-trigger'])[2]"));
        actions.moveToElement(kategori).clickAndHold(kategori).perform();
        WebElement tarim = driver.findElement(By.xpath("(//div[@class='title'])[33]"));
        actions.scrollToElement(tarim).clickAndHold(tarim).perform();
        WebElement tarimekipman = driver.findElement(By.xpath("(//*[text()='Tarım Ekipmanları'])[2]"));
        actions.moveToElement(tarimekipman).click(tarimekipman).perform();
        driver.switchTo().window(ilksayfahandle);
    }
}
