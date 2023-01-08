package myPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_yanlisEmailTesti {

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
    public void yanlisEmailTesti(){
        //1. https://automationexercise.com/ sayfasina gidelim
        driver.get("https://automationexercise.com/");
        //2. Sign Up/ Login butonuna basalım
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //3. Sign in butonuna basalim
         driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Fazıl");
        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
        //email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fazilhotmail.com");

    }
}
