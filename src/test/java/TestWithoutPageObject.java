import com.ibm.icu.impl.UResource;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestWithoutPageObject {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(800, TimeUnit.MILLISECONDS);
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

    @Test
    public void TestAvito() throws InterruptedException{
        driver.get("https://avito.ru");
        driver.findElement(By.cssSelector("a[data-marker='header/login-button']")).click();
        driver.findElement(By.cssSelector("input[data-marker='login-form/login']")).sendKeys("+79778085487",
                Keys.TAB, "Zx4Cv6Bn8", Keys.ENTER);
        Thread.sleep(50000);
        driver.findElement(By.xpath("//a[contains(text(),'Личные вещи')]")).click();
        driver.findElement(By.cssSelector("span[data-marker='delivery-filter/text']")).click();
        driver.findElement(By.cssSelector("button[data-marker='search-filters/submit-button']")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        driver.findElement(By.cssSelector("div[data-marker='item'] div div")).click();
        String newWindow = wait.until(anyWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);

        driver.findElement(By.cssSelector("button[data-marker='delivery-item-button-main']")).click();
        String phone = driver.findElement(By.cssSelector("input[data-marker='sd/order-widget-field/phone']")).getAttribute("value");
        assertTrue(phone.equals(""));

    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
