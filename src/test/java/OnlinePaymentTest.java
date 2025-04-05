import io.github.bonigarcia.wdm.WebDriverManager;
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

    public class OnlinePaymentTest {
        private static WebDriver driver;
        private WebDriverWait wait;
        private MainPage mainPage;
        private PaymentFrame paymentFrame;

        @BeforeAll
        static void setupAll() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setup() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            mainPage = new MainPage(driver, wait);
            paymentFrame = new PaymentFrame(driver, wait);

            mainPage.open();
            mainPage.acceptCookiesIfPresent();
        }

        @Test
        void testBlockTitle() {
            assertEquals("Онлайн пополнение\nбез комиссии", mainPage.getPaymentBlockTitle());
        }

        @Test
        void testPaymentLogos() {
            mainPage.getPaymentLogos().forEach(logo -> assertTrue(logo.isDisplayed()));
        }

        @Test
        void testDetailsLink() {
            String initialUrl = mainPage.getCurrentUrl();
            mainPage.clickDetailsLink();
            assertNotEquals(initialUrl, mainPage.getCurrentUrl());
        }

        @Test
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
        void tearDown() {
            driver.quit();
        }
    }
