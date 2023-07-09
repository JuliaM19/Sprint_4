package ya.practicum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutCustomer {
    private final WebDriver webDriver;
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    private final By surname = By.xpath("//input[@placeholder='* Фамилия']");
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subway = By.xpath("//input[@placeholder='* Станция метро']");
    private final By chooseSubway = By.className("Order_Text__2broi");
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonCookie = By.id("rcc-confirm-button");
    private final By next = By.xpath("//button[text()='Далее']");


    public AboutCustomer(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputName(String testName) {//Создать переменную testName
        webDriver.findElement(name).sendKeys(testName);
    }

    public void inputSurname(String testSurname) {//Создать переменную
        webDriver.findElement(surname).sendKeys(testSurname);
    }

    public void inputTestAddress(String testAddress) {//Создать переменную
        webDriver.findElement(address).sendKeys(testAddress);
    }

    public void clickSubway() {
        webDriver.findElement(subway).click();
    }

    public void clickChooseSubway() {
        webDriver.findElement(chooseSubway).click();
    }

    public void inputPhone(String testPhone) {//Создать переменную
        webDriver.findElement(phone).sendKeys(testPhone);
    }

    public void clickOnButtonCookie() {
        webDriver.findElement(buttonCookie).click();
    }

    public void clickOnButtonNext() {
        webDriver.findElement(next).click();
    }

}