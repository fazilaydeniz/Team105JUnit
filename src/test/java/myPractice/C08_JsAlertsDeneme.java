package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_JsAlertsDeneme {
    /*
    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){

        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedAlertYazisi="I am a JS Alert";
        String actualAlertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        driver.switchTo().alert().accept();
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String beklenenSonucYazisi="You clicked: Cancel";
        String actualsonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        Assert.assertEquals(beklenenSonucYazisi,actualsonucYazisi);

    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Fazıl Aydeniz");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String beklenenEkranYazisi="Fazıl Aydeniz";
        String actualEkranYazisi=driver.findElement(By.xpath("//*[text()='You entered: Fazıl Aydeniz']")).getText();
        Assert.assertTrue(actualEkranYazisi.contains(beklenenEkranYazisi));

    }
}
