import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ya.practicum.pom.AboutCustomer;
import ya.practicum.pom.AboutRent;
import ya.practicum.pom.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CreationOrderByMiddleButtonOrderTest {

    //Добавь необходимые поля
    private final String testName;
    private final String testSurname;
    private final String testAddress;
    private final String testPhone;
    private final String testDate;
    private final String daysCount;
    private final String testComment;
    private WebDriver webDriver;

    public CreationOrderByMiddleButtonOrderTest(String testName, String testSurname, String testAddress, String testPhone, String testDate, String daysCount, String testComment) {
        this.testName = testName;
        this.testSurname = testSurname;
        this.testAddress = testAddress;
        this.testPhone = testPhone;
        this.testDate = testDate;
        this.daysCount = daysCount;
        this.testComment = testComment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        // генерация тестовых данных
        return new Object[][]{
                {"Анна", "Марусина", "Москва ул Ленина 12", "89005553635", "27.07.2023", "двое суток", "Позвонить"},
                {"Илья", "Петрова", "Санкт-Петербург ул Ленина 11", "89005553678", "29.07.2023", "пятеро суток", "Не звонить"},
        };
    }

    @Before
    public void setUp() {
//        webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void clickOnOrderMiddleButton() {
        MainPage mainPage = new MainPage(webDriver);
        AboutCustomer aboutCustomer = new AboutCustomer(webDriver);
        AboutRent aboutRent = new AboutRent(webDriver);
        mainPage.open();
        mainPage.clickOnCookieButton();
        mainPage.scrollAndClickOrderButton();
        aboutCustomer.inputName(testName);
        aboutCustomer.inputSurname(testSurname);
        aboutCustomer.inputTestAddress(testAddress);
        aboutCustomer.clickSubway();
        aboutCustomer.clickChooseSubway();
        aboutCustomer.inputPhone(testPhone);
        aboutCustomer.clickOnButtonNext();
        aboutRent.inputDate(testDate);
        aboutRent.clickOnCountDays(daysCount);
        aboutRent.clickOnCheckColor();
        aboutRent.inputComment(testComment);
        aboutRent.clickOnButtonMakeOrder();
        aboutRent.clickOnButtonYes();
        String expected = "Заказ оформлен";
        String textOrderCreate = aboutRent.getTextOrderCreate();
        assertTrue(textOrderCreate.contains(expected));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        webDriver.quit();
    }
}