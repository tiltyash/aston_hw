import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest {
    private static WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("http://mts.by");
        try {


            WebElement cookieAcceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='cookie-agree' and contains(@class, 'cookie__ok')]")));
            cookieAcceptBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cookie show']")));
        } catch (TimeoutException e) {}
    }

    @Test
    void testBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение')]"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
        }

    @Test
    void testPaymentLogos() {
        var logos = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));
        logos.forEach(logo -> assertTrue(logo.isDisplayed()));
    }

    @Test
    void testDetailsLink() {
        String initialUrl = driver.getCurrentUrl();
        driver.findElement(By.xpath("//a[contains(., 'Подробнее о сервисе')]")).click();
        assertNotEquals(initialUrl, driver.getCurrentUrl());
    }

    @Test
    void testPaymentForm() {
        driver.findElement(By.xpath("//p[contains(., 'Услуги связи')]"));
        driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@placeholder='Сумма']")).sendKeys("0.10");
        driver.findElement(By.xpath("//button[contains(., 'Продолжить')]")).click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);

        //WebElement paymentContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
        //        xpath("//app-payment-container")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
