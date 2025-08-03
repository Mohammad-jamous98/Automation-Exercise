package Pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PaymentPage {
    WebDriver driver;
    WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterNameOnCard(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card")))
            .sendKeys(name);
    }

    public void enterCardNumber(String cardNumber) {
        driver.findElement(By.name("card_number")).sendKeys(cardNumber);
    }

    public void enterCVC(String cvc) {
        driver.findElement(By.name("cvc")).sendKeys(cvc);
    }

    public void enterExpiryMonth(String month) {
        driver.findElement(By.name("expiry_month")).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        driver.findElement(By.name("expiry_year")).sendKeys(year);
    }

    public void clickPayAndConfirm() {
        driver.findElement(By.id("submit")).click();
    }
    
    public void clickContinueAfterOrder() {
        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
    }


    public boolean isOrderConfirmed() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Order Placed!']")));
        return message.isDisplayed();
    }
}
