package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C13_DropDownSayfa103 {
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
    public void test01() throws InterruptedException {
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");
        //4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        //6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(2);
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDownElementi= driver.findElement(By.id("pc_currency"));
        Select select=new Select(dropDownElementi);
        select.selectByIndex(6);
        Thread.sleep(2);
       //9. “amount” kutusuna bir sayi girin
         driver.findElement(By.id("pc_amount")).sendKeys("100");
        Thread.sleep(2);
        //10. “US Dollars” in secilmedigini test edin
        WebElement dollarYazisi=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(dollarYazisi.isSelected());
        Thread.sleep(2);
        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(2);
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs"));
        Thread.sleep(2);
        driver.findElement(By.id("purchase_cash")).click();
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement basariliYazisi=driver.findElement(By.id("alert_content"));
        Assert.assertTrue(basariliYazisi.isDisplayed());
    }
}
