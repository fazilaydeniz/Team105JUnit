package myPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C14_KeyboardSayfa134 extends TestBase {
    @Test
    public void testActionsClassHomeWork() {
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverBox).perform();
        // Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("//a[text()='Link 1']"));
        link1.click();
        // Popup mesajini yazdirin
        String popupYazisi=driver.switchTo().alert().getText();
        //WebElement popupMessage = driver.findElement(By.cssSelector("#action-confirmation-content"));
        System.out.println(popupYazisi);
        // Popup'i tamam diyerek kapatin
        // WebElement okButton = driver.findElement(By.cssSelector("#action-confirmation-button"));
         driver.switchTo().alert().accept();
        // “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldBox).perform();
        //“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHoldMessage = driver.findElement(By.id("click-box"));
        System.out.println(clickAndHoldMessage.getText());
        // “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButton).perform();
        ReusableMethods.bekle(3);
    }
}
