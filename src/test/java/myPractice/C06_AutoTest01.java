package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_AutoTest01 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
   // @AfterClass
    //public static void tearDown(){
    //    driver.close();
  //  }
    @Test
    public void test01() throws InterruptedException {
        //Test Durumu 1: Kullanıcıyı Kaydet
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String expectedbaslik="Automation Exercise";
        String actualbaslik= driver.getTitle();
        Assert.assertEquals(actualbaslik,expectedbaslik);
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        String expectedYazi="New User Signup!";
        String YeniKullaniciKaydiYazisi= driver.getPageSource();
        Assert.assertEquals(actualbaslik,expectedbaslik);
        //6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Fazıl");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fazil@hotmail.com");
       //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        String expectedYazi1="ENTER ACCOUNT INFORMATION";
        String hesapBilgileriniGirinYazisi= driver.getPageSource();
        Assert.assertEquals(actualbaslik,expectedbaslik);
        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.id("id_gender1")).click();
       // driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Fazıl");
       // driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("fazil@hotmail.com");
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys("27122022");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("27");
        driver.findElement(By.id("months")).sendKeys("12");
        driver.findElement(By.id("years")).sendKeys("2021");
        driver.findElement(By.id("first_name")).sendKeys("Fazıl");
        driver.findElement(By.id("last_name")).sendKeys("Ay");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Cumhuriyet");
        driver.findElement(By.id("country")).sendKeys("Canada");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Canada");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Ottawa");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("35000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("905002555555");
        Thread.sleep(2000);
        WebElement createButonu= driver.findElement(By.xpath("//button[text()='Create Account']"));
        createButonu.submit();


        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam Et' düğmesini tıklayın
        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
    }

}
