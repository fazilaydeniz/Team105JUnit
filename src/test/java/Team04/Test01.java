package Team04;

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

public class Test01 {
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
        //9. Sayfayi kapatin
        driver.close();
    }
    @Test
    public void test01(){
       // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
       // 2. Username kutusuna “standard_user” yazdirin
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

       // 3. Password kutusuna “secret_sauce” yazdirin
      driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

       // 4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

       // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        ilkUrun.click();
       // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
       // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[text()='1']")).click();
       // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement aldigimUrun=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        Assert.assertTrue(aldigimUrun.isDisplayed());
        WebElement aldigimUrunAdedi= driver.findElement(By.xpath("//*[text()='1']"));
        String aldigimUrunSayisi= aldigimUrunAdedi.getText();
        System.out.println("Aldığım Ürünün Sayısı :" + aldigimUrunSayisi);
        Assert.assertTrue(aldigimUrunAdedi.isDisplayed());
    }
}




