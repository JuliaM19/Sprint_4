import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ya.practicum.pom.MainPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FaqTest {

    private WebDriver driver;

    private final Map<String, String> faqMap = new HashMap<>() {{
        put("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        put("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        put("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        put("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        put("Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        put("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        put("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        put("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }};
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testFaq() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickOnCookieButton();
        mainPage.scrollUntilFAQ();

        List<WebElement> accordionItems = driver.findElements(By.className("accordion__item"));
        for (WebElement accordionItem : accordionItems) {
            accordionItem.click();
            WebElement faqHeader = accordionItem.findElement(By.className("accordion__heading"));
            WebElement faqValue = accordionItem.findElement(By.className("accordion__panel"));
            assertEquals(faqMap.get(faqHeader.getText()), faqValue.findElement(By.cssSelector("p:nth-child(1)")).getText());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
