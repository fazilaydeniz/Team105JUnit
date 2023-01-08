package myPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C15_DemoGuru extends TestBase {
    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        //2) sayfadaki iframe sayısını bulunuz.
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        //==========================================================
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/ ");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        int iframeCount = iframes.size();
        System.out.println(iframeCount);
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframeElementi=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        ilkIframeElementi.click();
        ReusableMethods.bekle(5);
        driver.switchTo().frame(ilkIframeElementi);
        ReusableMethods.bekle(5);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        ReusableMethods.bekle(5);
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement ikinciIframeElementi=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(ikinciIframeElementi);
        ReusableMethods.bekle(5);
    }
}
