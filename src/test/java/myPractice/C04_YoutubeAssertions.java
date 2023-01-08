package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1) Bir class oluşturun: YoutubeAssertions
public class C04_YoutubeAssertions {
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
    @Before
    public void before(){
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedKelime= "YouTube";
        String actualsonuc= driver.getTitle();
        Assert.assertEquals(actualsonuc,expectedKelime);
    }
    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement youtubeLogo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
        WebElement seachBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(seachBox.isEnabled());
    }
    @Test
    public void searchBooxTesti(){
        //○ wrongTitleTest => Sayfa basliginin “//○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin” olmadigini dogrulayin
        String expectedbaslik="youtube";
        String actualbaslik= driver.getTitle();
        Assert.assertNotEquals(expectedbaslik,actualbaslik);
    }
}
