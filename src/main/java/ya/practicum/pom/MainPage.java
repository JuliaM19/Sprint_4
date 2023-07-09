package ya.practicum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver webDriver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    private final By bottomOrderButton = By.className("Home_FinishButton__1_cWm");
    private final By faqLocator = By.className("Home_FourPart__1uthg");
    private final By buttonCookie = By.id("rcc-confirm-button");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(url);
    }

    public void clickOnButtonOrder() {
        webDriver.findElement(orderButtonTop).click();
    }

    public void clickOnCookieButton() {
        webDriver.findElement(buttonCookie).click();
    }

    public void scrollAndClickOrderButton() {
        WebElement button = webDriver.findElement(bottomOrderButton);
        // Прокрути страницу до футера
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.className("Home_StatusBrick__1PsW9")));
        button.click();
    }

    public void scrollUntilFAQ() {
        WebElement faqElement = webDriver.findElement(faqLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", faqElement);
    }

}
