package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_tekrarTesti {
    //1- C01_TekrarTesti isimli bir class olusturun
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
       // 8- Sayfayi kapatin
        driver.close();
    }
    @Test
    public void test01(){
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedbaslık= driver.getTitle();
        Assert.assertEquals(expectedbaslık,"Google");
        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.className("gLFyf")).sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi= driver.findElement(By.id("result-stats"));
        String sonucYazisi=sonucSayisi.getText();
        System.out.println(sonucYazisi);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String [] sonucYazisiniBol= sonucYazisi.split(" ");
        int sonuc=Integer.parseInt(sonucYazisiniBol[1].replace(".", ""));
        Assert.assertTrue(sonuc>1000000);
    }
}
