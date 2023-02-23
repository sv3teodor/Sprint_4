package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import utils.BaseTestClass;

public class CheckIncorrectOrderTest extends BaseTestClass {


    @Test //Тест проверяет, что при вводе неверного номера заказа будет выведен страница с сообщение "Такого заказа нет"
    public void checkIncorrectOrder()  {
        Assert.assertTrue(new HomePage(driver)
                            .btnSwitchToCheckRentStatusClick()
                            .setOrderNum(TestConfig.INCORRECT_ORDER_NUMBER.toString())
                            .btnCheckRentStatus()
                            .isTrackNoFound());
    }





}
