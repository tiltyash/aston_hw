import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.PaymentFrame;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Онлайн платежи")
@Feature("Проверка функционала онлайн платежей")
public class OnlinePaymentTest {
    private static WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private PaymentFrame paymentFrame;

    @BeforeAll
    @Step("Настройка драйвера")
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    @Step("Инициализация тестового окружения")
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        mainPage = new MainPage(driver, wait);
        paymentFrame = new PaymentFrame(driver, wait);

        mainPage.open();
        mainPage.acceptCookiesIfPresent();
    }

    @Test
    @DisplayName("Проверка заголовка блока платежей")
    @Description("Проверяем, что заголовок блока платежей соответствует ожидаемому")
    @Severity(SeverityLevel.NORMAL)
    void testBlockTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getPaymentBlockTitle());
    }

    @Test
    @DisplayName("Проверка отображения логотипов платежных систем")
    @Description("Проверяем, что все логотипы платежных систем отображаются")
    @Severity(SeverityLevel.NORMAL)
    void testPaymentLogos() {
        mainPage.getPaymentLogos().forEach(logo -> assertTrue(logo.isDisplayed()));
    }

    @Test
    @DisplayName("Проверка ссылки 'Подробнее'")
    @Description("Проверяем, что ссылка 'Подробнее' ведет на другую страницу")
    @Severity(SeverityLevel.NORMAL)
    void testDetailsLink() {
        String initialUrl = mainPage.getCurrentUrl();
        mainPage.clickDetailsLink();
        assertNotEquals(initialUrl, mainPage.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка плейсхолдеров полей ввода")
    @Description("Проверяем плейсхолдеры полей ввода для разных типов платежей")
    @Severity(SeverityLevel.NORMAL)
    void testEmptyFieldsPlaceholders() {
        assertEquals("Номер телефона", mainPage.getPhoneFieldPlaceholder());
        assertEquals("Сумма", mainPage.getAmountFieldPlaceholder());

        mainPage.selectPaymentOption("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getSubscriberFieldPlaceholder());
        assertEquals("Сумма", mainPage.getAmountFieldPlaceholder());

        mainPage.selectPaymentOption("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getInstallmentPlanFieldPlaceholder());
        assertEquals("Сумма", mainPage.getAmountFieldPlaceholder());

        mainPage.selectPaymentOption("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getDebtFieldPlaceholder());
        assertEquals("Сумма", mainPage.getAmountFieldPlaceholder());
    }

    @Test
    @DisplayName("Проверка формы платежа")
    @Description("Проверяем форму платежа после заполнения данных")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Оплата услуг связи")
    void testPaymentForm() {
        mainPage.selectPaymentOption("Услуги связи");
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("0.10");
        mainPage.clickContinueButton();

        paymentFrame.switchToFrame();

        assertEquals("0.10 BYN", paymentFrame.getPaymentAmount());
        assertEquals("Оплатить 0.10 BYN", paymentFrame.getPayButtonText());
        assertTrue(paymentFrame.getPaymentDescription().contains("Услуги связи"));
        assertTrue(paymentFrame.getPaymentDescription().contains("375297777777"));

        Map<String, String> placeholders = paymentFrame.getCardInputPlaceholders();
        assertEquals("Номер карты", placeholders.get("cardNumber"));
        assertEquals("Срок действия", placeholders.get("expiryDate"));
        assertEquals("CVC", placeholders.get("cvc"));
        assertEquals("Имя держателя (как на карте)", placeholders.get("cardHolder"));

        assertTrue(paymentFrame.arePaymentSystemIconsDisplayed());
    }

    @AfterEach
    @Step("Завершение теста")
    void tearDown() {
        driver.quit();
    }
}
