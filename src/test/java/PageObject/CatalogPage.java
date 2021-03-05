package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends  page{
    public CatalogPage(WebDriver driver) {super(driver); PageFactory.initElements(driver, this);}

    @FindBy(xpath="//a[contains(text(),'Личные вещи')]")
    public WebElement PersonalItems;

    @FindBy(css="span[data-marker='delivery-filter/text']")
    public WebElement DeliveryFilter;

    @FindBy(css="button[data-marker='search-filters/submit-button']")
    public WebElement SubmitButton;
}
