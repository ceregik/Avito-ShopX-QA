package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  page{
    public LoginPage(WebDriver driver) {super(driver); PageFactory.initElements(driver, this);}

    @FindBy(css="a[data-marker='header/login-button']")
    public WebElement LoginButton;

    @FindBy(css="input[data-marker='login-form/login']")
    public WebElement LoginInput;
}
