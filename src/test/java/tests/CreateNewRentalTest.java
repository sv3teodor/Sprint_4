package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import utils.BaseTest;
import utils.WebTestUtils;

@RunWith(Parameterized.class)
public class CreateNewRentalTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String dateStartRent;
    private final String rentPeriod;
    private final String colorScooter;
    private final String comment;

    public CreateNewRentalTest(String name, String surname, String address, String subwayStation, String phoneNumber,
                               String dateStartRent, String rentPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.dateStartRent = dateStartRent;
        this.rentPeriod = rentPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestDate() {
        return new Object[][]{
                {"Иван", "Шниперсон", "ул. Никольская, дом 1", "Бульвар Рокоссовского", "+799988776655", WebTestUtils.getDateForTest(0), "пятеро суток", "чёрный жемчуг", "Не привозите, он мне не нужен"},
                {"Вано", "Иванов", "ул. западный тупик, дом 1", "Театральная", "+74541154777", WebTestUtils.getDateForTest(10), "сутки", "серая безысходность", "осторожно злой клиент"}
        };
    }

    //Проверяем позитивный сценарий заказа.
    // При проверке через Chrome возникнет ошибка т.к. не появляется окно с подтверждением заказа
    @Test
    public void createNewRental() {
        //Проверяем возможность перехода к форме заказа через нижнюю кнопку "заказать"
        //Считаю, что достаточно убедится в появлении формы заказа, нет смысла делать полный заказ через каждую кнопку.
        //Оптимальным вариантом будет вынести проверку перехода с этих двух кнопок заказа в отдельны не параметризованный тест
        Assert.assertTrue(new HomePage(driver)
                .btnRentScooterButtonClick()
                .isPageHeader());

        //Возвращаемся на главную страницу и заполняем заказ через верхнюю кнопку
        Assert.assertTrue(new HomePage(driver)
                .goToScooterHomePage()
                .btnRentScooterTopClick()
                .addCustomerInfo(name, surname, address, subwayStation, phoneNumber)
                .addRentInfo(dateStartRent, rentPeriod, colorScooter, comment)
                .btnConfirmNewRentClick()
                .isPageRentConfirmed());
    }

}
