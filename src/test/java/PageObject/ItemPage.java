package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

public class ItemPage extends  page{
    public ItemPage(WebDriver driver) {super(driver); PageFactory.initElements(driver, this);}

    @FindBy(css="button[data-marker='delivery-item-button-main']")
    public WebElement DeliveryButton;

    @FindBy(css="input[data-marker='sd/order-widget-field/phone']")
    public WebElement PhoneInput;

    public void OpenItem() {
        Set<String> oldWindows = driver.getWindowHandles();
        driver.findElement(By.cssSelector("div[data-marker='item'] div div")).click();
        String newWindow = wait.until(anyWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String>oldWindows){
        return new ExpectedCondition<String>() {
            public String apply(WebDriver webDriver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size()>0 ? handles.iterator().next() : null;
            }
        };
    }
}
