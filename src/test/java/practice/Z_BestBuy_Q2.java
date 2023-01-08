package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBase;

public class Z_BestBuy_Q2 extends TestBase {
    //..Exercise2...
//  http://www.bestbuy.com 'a gidin,
//  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
//  Ayrica Relative Locator kullanarak;
//      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
//  Ayrica Relative Locator kullanarak;
//      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

    @Before
    public void beforeTest(){
        driver.get("http://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        String expectedTitle = "Best";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println(actualTitle);
    }
    @Test
    public void logoTest() {
        driver.get("http://www.bestbuy.com");

        // Ayrica Relative Locator kullanarak;
        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

        // Hello! yazisinin ustu
        WebElement hello = driver.findElement(By.xpath("//*[text()='Hello!']"));
        WebElement bestBuy = driver.findElement(RelativeLocator.with(By.xpath("(//img[@class='logo'])[1]")).above(hello));

        Assert.assertTrue(bestBuy.isDisplayed());
    }

    @Test
    public void mexicolinkTest() {
        driver.get("http://www.bestbuy.com");

        //  Ayrica Relative Locator kullanarak;
        //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        // United states'in sagi
        WebElement unitedStates = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.xpath("(//img[@alt='Mexico'])[1]")).toRightOf(unitedStates));

        Assert.assertTrue(mexicoLink.isDisplayed());

    }

}
