package practiceSundayTuesdayFriday;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_ActionMethods {
    WebDriver driver;
    // https://www.booking.com/ sayfasina gidelim
    // para birimi olarak TL secelim
    // ulke olarak Turkiye yi secelim
    // sayfanin en altindan ulgeler kismini secelim
    // ulkeler sayfasindan turkiye yi secelim
    // turkiye sayfasinin secildigini test edin

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void TearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        // https://www.booking.com/ sayfasina gidelim
        driver.get("https://www.booking.com/");

    }



}
