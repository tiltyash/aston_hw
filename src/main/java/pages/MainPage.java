package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("http://mts.by");
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement cookieAcceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='cookie-agree' and contains(@class, 'cookie__ok')]")));
            cookieAcceptBtn.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cookie show']")));
        } catch (TimeoutException e) {}
    }

    public String getPaymentBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение')]"));
        return title.getText();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickDetailsLink() {
        driver.findElement(By.xpath("//a[contains(., 'Подробнее о сервисе')]")).click();
    }

    public void selectPaymentOption(String optionName) {
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'select__wrapper')]")));
        select.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class, 'select__list')]")));
    }

    public String getPhoneFieldPlaceholder() {
        return driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"))
                .getAttribute("placeholder");
    }

    public String getSubscriberFieldPlaceholder() {
        return driver.findElement(By.xpath("//input[@placeholder='Номер абонента']"))
                .getAttribute("placeholder");
    }

    public String getInstallmentPlanFieldPlaceholder() {
        return driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"))
                .getAttribute("placeholder");
    }

    public String getDebtFieldPlaceholder() {
        return driver.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"))
                .getAttribute("placeholder");
    }

    public String getAmountFieldPlaceholder() {
        return driver.findElement(By.xpath("//input[@placeholder='Сумма']"))
                .getAttribute("placeholder");
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).sendKeys(phone);
    }

    public void enterAmount(String amount) {
        driver.findElement(By.xpath("//input[@placeholder='Сумма']")).sendKeys(amount);
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//button[contains(., 'Продолжить')]")).click();
    }
}
