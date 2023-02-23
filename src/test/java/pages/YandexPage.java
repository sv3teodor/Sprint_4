package pages;
//POD для главной страницы яндекса(дзена)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePageClass;

public class YandexPage extends BasePageClass{

    //Локатор страницы дзена
    private final By yandexPageLocator = By.cssSelector(".zen-page");


    public YandexPage(WebDriver driver) {
        super(driver);
    }
    //Проверяем, что окно яндекса открыто
    public boolean isYandexPageOpen()  {
        return driver.findElement(yandexPageLocator).isDisplayed();
    }
}
