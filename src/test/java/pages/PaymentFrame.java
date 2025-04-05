package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentFrame {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String getCardFieldPlaceholder(String labelText) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format("//label[contains(., '%s')]", labelText)))).getText();
    }

    public PaymentFrame(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void switchToFrame() {
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));
        driver.switchTo().frame(iframe);
    }

    public String getPaymentDescription() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'pay-description__text')]//span"))).getText();
    }

    public String getPaymentAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'pay-description__cost')]//span"))).getText();
    }

    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(@class, 'colored')]"))).getText().trim();
    }

    public Map<String, String> getCardInputPlaceholders() {
        Map<String, String> placeholders = new HashMap<>();
        placeholders.put("cardNumber", getCardFieldPlaceholder("Номер карты"));
        placeholders.put("expiryDate", getCardFieldPlaceholder("Срок действия"));
        placeholders.put("cvc", getCardFieldPlaceholder("CVC"));
        placeholders.put("cardHolder", getCardFieldPlaceholder("Имя держателя"));
        return placeholders;
    }

    public boolean arePaymentSystemIconsDisplayed() {
        try {
            List<WebElement> icons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class, 'cards-brands__container')]//img")));
            return !icons.isEmpty();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
