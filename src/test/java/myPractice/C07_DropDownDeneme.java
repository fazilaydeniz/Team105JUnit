package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C07_DropDownDeneme {
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
    public void test01(){
        // ilgili ayarlari yapip
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin
        driver.get("https://www.amazon.com");
        // 1 - select objesi olusturmadan once dropdown webelemntini locate etmeliyiz
        WebElement dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // 2- Select class'indan obje olusturmak
        Select select=new Select(dropdownWebElementi);
        select.selectByVisibleText("Computers");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("i7 laptop" + Keys.ENTER);
        String expectedKelime="i7 laptop";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));
        // dropdown menuden Books seceneginin secildigini test edin
        /*
           Locate ettigimiz elementi bulamazsa NoSuchElementException
           sayfa yenilendigi icin var olan bir elementi kullanamazsa
           StaleElementException verir
           bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */
        dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownWebElementi);
        select.selectByVisibleText("Computers");
        String expectedseciliOption="Computers";
        String actualseciliOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedseciliOption,(actualseciliOption));
        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin
        List<WebElement> optionsWebElementListesi=select.getOptions();
        int expectedOptionsWebElementSayisi=28;
        int actualoptionsWebelementSayisi=optionsWebElementListesi.size();
        Assert.assertTrue(expectedOptionsWebElementSayisi==actualoptionsWebelementSayisi);










    }
}
