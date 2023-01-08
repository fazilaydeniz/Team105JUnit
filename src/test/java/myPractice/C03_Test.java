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

public class C03_Test {
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
        //9. Sayfayi kapatin
        driver.close();
    }
    @Test
    public void test03() throws InterruptedException {
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        Thread.sleep(2000);
        WebElement ilkUrun= driver.findElement(By.className("inventory_item_name"));
        ilkUrun.click();
        //6. Add to Cart butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_badge")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Thread.sleep(2000);
        WebElement aldigimUrun= driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue(aldigimUrun.isDisplayed());
    }
}
