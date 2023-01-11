package myPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class C20_ActionsS136 extends TestBase {

    @Test
    public void test01() {
        Actions action = new Actions(driver);
        //1- Bir Class olusturalim KeyboardActions2++
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        action.sendKeys(Keys.PAGE_DOWN);
        action.sendKeys(Keys.PAGE_DOWN);
        action.moveToElement(driver.findElement(By.xpath("//div[@id='player']")));

               //4- videoyu izlemek icin Play tusuna basin
        driver.findElement(By.xpath("//div[@id='player']")).click();

        //5- videoyu calistirdiginizi test edin

    }
}
