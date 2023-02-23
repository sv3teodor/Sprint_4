package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.NewRentClientInfoPage;
import utils.BaseTestClass;

//Тест неверного заполнения полей форм заказа.
//При вводе неверной станции метро браузер улетает на пустую страницу, это баг
public class CheckErrorMessagesFieldsTest extends BaseTestClass {
    @Test
    public void testErrorInFields(){
        //Заполняем поля неверными значениями
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .btnRentScooterButtonClick()
                .inputName(TestConfig.INCORRECT_NAME)
                .inputSurname(TestConfig.INCORRECT_SURNAME)
                .inputAddress(TestConfig.INCORRECT_ADDRESS)
                .inputPhoneNumber(TestConfig.INCORRECT_PHONENUMBER)
                .inputSubwayStationClick("aaaa")
                .inputSubwayStationClick("aaaa");
        //Проверяем, что все ошибки видны
        Assert.assertTrue(clientInfoPage.isInputNameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputSurnameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputAddressErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputPhoneNumberError());
    }

}
