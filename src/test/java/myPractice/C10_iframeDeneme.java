package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_iframeDeneme {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void iframeTest() throws InterruptedException {

         //  1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
         driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest. (Yukarıda yaptık method ismi)
        // 3 - “An IFrame containing….” textinin erisilebilir oldugunu test edin
        WebElement actualSayfaYazisiElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualSayfaYazisiElementi.isEnabled());
        //     ve  konsolda yazdirin.
       System.out.println(actualSayfaYazisiElementi.getText());
       //  - Text Box’a “Merhaba Dunya!” yazin.
       // WebElement metinKutusuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
       // metinKutusuElementi.clear();
       // metinKutusuElementi.sendKeys("Merhaba Dünya");
        // normal locate yapip yazdirmayi denedigimizde NoSuchElementException verdi
        // yani elementi bulamadi
        // kontrol ederken istedigimiz webelement'in bir iframe icinde oldugunu gorduk
        // Bu durumda once o iframe'e switchTo() yapmaliyiz
         driver.switchTo().frame("mce_0_ifr");
         WebElement metinKutusuElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
         metinKutusuElementi.clear();
         metinKutusuElementi.sendKeys("Merhaba Dünya");
         Thread.sleep(2000);
         //Textbox'ın altında bulunan "Elemental Selenium" linkinin görünür olduğunu doğrulayın ve konsolda yazdırın
        //Burada dikkat edilmesi gereken iframe'in içine girdikten sonra dışına çıkmak da gerekir. Şu an içindeyiz.
        //Dışına çıkmak için iki yol vardır.Bunlardan (parentframe) bir çok iframe olan sayfalarda kullanılır. DefaultContent
        //ise anasayfaya çıkmak için kullanılır. Biz burada default Content kullanacağız.
        driver.switchTo().defaultContent();
        WebElement actualElementalSeleniumYazisi= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(actualElementalSeleniumYazisi.isDisplayed());
        System.out.println(actualElementalSeleniumYazisi.getText());


    }
}
