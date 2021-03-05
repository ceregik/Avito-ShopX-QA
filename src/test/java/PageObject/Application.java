package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Application {

    private WebDriver driver;
    private WebDriverWait wait;

    private MainPage mainPage;
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private ItemPage itemPage;

    public Application() {

        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        itemPage = new ItemPage(driver);

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
    }

    public void OpenAvito() {
        mainPage.open();
    }

    public void Login(String login, String password){
        loginPage.LoginButton.click();
        loginPage.LoginInput.sendKeys(login,
                Keys.TAB, password, Keys.ENTER);
    }


    public void GoToShipping(){
       catalogPage.PersonalItems.click();
        catalogPage.DeliveryFilter.click();
        catalogPage.SubmitButton.click();
    }

    public void OpenFirstItem(){
        itemPage.OpenItem();
    }

    public void GoToItemShip(){
        itemPage.DeliveryButton.click();
    }

    public void CheckPhone(){
        String phone = itemPage.PhoneInput.getAttribute("value");
        assertTrue(phone.equals(""));
    }

    public void quit(){
        driver.quit();}
}
