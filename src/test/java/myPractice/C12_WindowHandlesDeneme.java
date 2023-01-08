package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C12_WindowHandlesDeneme {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
   // @After
   // public void tearDown(){
   //     driver.quit();
   // }
    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualYazi=driver.findElement(By.tagName("h3")).getText();
        String expectedYazi="Opening a new window";
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String beklenenTitle="The Internet";
        Assert.assertTrue(actualTitle.contains(beklenenTitle));

        String ilkSayfaWHDegeri= driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        /*
               Kontrolsuz acilan tab'a gecis yapmak icin
               1- ilk sayfada iken o sayfanin WHD alip kaydedin
               2- 2.sayfa acildiktan sonra getWindowhandles() kullanarak
                  acik olan tum sayfalarin WH degerlerini bir Set olarak kaydedin
               3- su anda elimizde 2 elementli bir Set var,
                  elementlerden bir tanesi 1.sayfanin WHD
                  1.sayfanin WHD'ine esit olmayan ise 2.sayfanin WHD olur
               4- bu sekilde 2.sayfanin WHD elde edildikten sonra
                  WHD'leri kullanilarak sayfalar arasinda gecis yapilabilir
         */
        Set<String> tumWHDegerleriSeti=driver.getWindowHandles();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualSayfaTitle= driver.getTitle();
        String beklenenSayfaTitle="New Window";
        Assert.assertTrue(actualSayfaTitle.contains(beklenenSayfaTitle));

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText= driver.getTitle();
        String beklenenText="The Internet";
        Assert.assertTrue(actualText.contains(beklenenText));
        //● Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu doğrulayın.


    }
}
