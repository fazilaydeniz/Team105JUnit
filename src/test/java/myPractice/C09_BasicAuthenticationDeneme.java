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

public class C09_BasicAuthenticationDeneme {
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
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //  Username     : admin
        //  password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        String actualSonucYazisi= driver.findElement(By.tagName("p")).getText();
        String expectedKelime= "Congratulations";
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Thread.sleep(2000);
    }


}
