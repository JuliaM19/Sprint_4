package ya.practicum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AboutRent {
    private final WebDriver webDriver;
    private final By datePicker = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By countDays = By.className("Dropdown-placeholder");
    private final By countDaysItem = By.className("Dropdown-option");
    private final By checkColor = By.xpath("//label[text()='чёрный жемчуг']");
    private final By comment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By createOrder = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By buttonYes = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By textOrderCreated = By.className("Order_ModalHeader__3FDaJ");

    public AboutRent(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputDate(String date) {
        WebElement element = webDriver.findElement(datePicker);
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    public void clickOnCountDays(String testCount) {
        webDriver.findElement(countDays).click();
        List<WebElement> menu = webDriver.findElements(countDaysItem);
        for (WebElement item : menu) {
            if (item.getText().equals(testCount)) {
                item.click();
                return;
            }
        }

        throw new RuntimeException("Не нашли нужное количество дней в выпадающем списке");
    }

    public void clickOnCheckColor() {
        webDriver.findElement(checkColor).click();
    }

    public void inputComment(String testComment) {
        webDriver.findElement(comment).sendKeys(testComment);
    }

    public void clickOnButtonMakeOrder() {
        webDriver.findElement(createOrder).click();
    }

    public void clickOnButtonYes() {
        webDriver.findElement(buttonYes).click();
    }

    public String getTextOrderCreate() {
        return webDriver.findElement(textOrderCreated).getText();
    }

}
