package pages;
//Класс с элементами общими для разных страниц
import config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePageClass;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class CommonHeaderClass extends BasePageClass {

    //Ссылка для перехода на главную страницу яндекса. (Учитывая новые реалии на dzen.ru)
    private final By linkToYandex = By.className("Header_LogoYandex__3TSOI");
    //Ссылка для перехода на главную страницу сервиса для заказа самокатов
    private final By linkToScooterHomePage = By.cssSelector(".Header_LogoScooter__3lsAR");


    public CommonHeaderClass(WebDriver driver) {
        super(driver);
    }

    //Клик по ссылке на главную страницу яндекса
    public YandexPage goToYandexHomePageClick() {
        //Запоминаем хэндл окна сервиса самокатоы
        String originalScooterWindow = driver.getWindowHandle();
        driver.findElement(linkToYandex).click();
        //Ждем появления второго окна
        new WebDriverWait(driver, TestConfig.IMPLICIT_WAIT_SECONDS).until(numberOfWindowsToBe(2));
        //Перебираем все(да, все два)) окна в поисках нового и переключаемся на него
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalScooterWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        return new YandexPage(driver);
    }
    //Клик по ссылке на главную странице сервиса самокат
    public HomePage goToScooterHomePage() {
        driver.findElement(linkToScooterHomePage).click();
        return new HomePage(driver);
    }

}
