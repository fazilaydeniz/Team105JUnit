package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class C01_NewWindow {
    /*
    Selenium 4 ile window konusunda yeni bir özellik geldi

    Istersek kontrollu olarak driver icin yeni bir window yada tab olusturabiliriz.
    Bu durumda driver da otomatik olarak yeni sayfaya gelmis olur

    Testin ilerleyen asamalarinda yeniden eski sayfalara dönus göreve varsa
    o sayfada iken o sayfanin window handle degeri alinip kaydedilir ve
     o sayfaya gecmek istendiginde driver.switchTo().window(istenen sayfanin window handle degeri)
      kodu ile o sayfaya gecis yapilir
     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://amazon.com");

        Thread.sleep(3000);

        // Testin ilerleyen asamalarinda yeniden amazon
        // sayfasina dönmek gerekiyorsa amazon sayfasindayken bu windowun,
        // window handle degerini alip kaydetmeliyiz

        String ilkSayfaWindowDegeri = driver.getWindowHandle();

        // Yeni bir tab da wisequarter.com a gidin ve gittigimizi test edin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String actualUrl = driver.getCurrentUrl();
        String exectedKelime = "wisequarter";

        Assert.assertTrue(actualUrl.contains(exectedKelime));

        Thread.sleep(3000);

        // Wisequarter testini yaptiktan sonra yeniden amazonun acik oldugu
        // tab a gecin ve amazon ana sayfanin acik oldugunu test edin

        driver.switchTo().window(ilkSayfaWindowDegeri);

    }

}
