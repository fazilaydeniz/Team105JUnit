package myPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.DriverManager;

public class C22_ExplicitWaitS151 extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitWait(){
        //1. Bir class olusturun : WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
           driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        WebElement removeButonu= driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButonu.click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneMesaji= driver.findElement(By.xpath("//p[@id='message']"));
        //6. Add buttonuna basin
        WebElement addButonu= driver.findElement(By.xpath("//button[normalize-space()='Add']"));
        addButonu.click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMesaji=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackMesaji.isDisplayed());

    }
    public void explicitWait(){

    }
}
