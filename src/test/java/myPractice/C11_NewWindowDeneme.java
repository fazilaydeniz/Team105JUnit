package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C11_NewWindowDeneme {
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
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(2000);
        String amazonAnaSayfaWHD= driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualURL= driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        Assert.assertTrue(actualURL.contains(expectedKelime));
        Thread.sleep(2000);
        // wisequarter testini yaptıktan sonra
        // yeniden amazonun açık olduğu TAB2a geçin
        // ve amazon anasayfanın açık olduğunu test edin
        driver.switchTo().window(amazonAnaSayfaWHD);
        actualURL=driver.getCurrentUrl();
        expectedKelime="amazon";
        Assert.assertTrue(actualURL.contains(expectedKelime));
        Thread.sleep(2000);

    }
}
