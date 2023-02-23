package utils;

import org.openqa.selenium.WebDriver;

public class BasePageClass {
    protected WebDriver driver;

    public BasePageClass(WebDriver driver) {
        this.driver = driver;
    }
}
