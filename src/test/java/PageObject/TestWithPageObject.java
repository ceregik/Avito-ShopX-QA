package PageObject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWithPageObject extends TestBase {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void AvitoTest () throws InterruptedException{

        app.OpenAvito();

        app.Login("login","password");

        app.GoToShipping();

        app.OpenFirstItem();

        app.GoToItemShip();

        app.CheckPhone();

    }

}
