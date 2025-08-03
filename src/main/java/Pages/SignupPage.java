package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SignupPage {
	WebDriver driver;
	WebDriverWait wait;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void navigateToSingup() {
		driver.findElement(By.linkText("Signup / Login")).click();
	}

	public void enterNameAndEmail(String name, String email) {
		driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
	}

	public void selectGender() {
		int choice = new java.util.Random().nextInt(2);
		if (choice == 0)
			driver.findElement(By.id("id_gender1")).click();
		else
			driver.findElement(By.id("id_gender2")).click();
	}

	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void selectDateOfBirth(String day, String month, String year) {
		new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[data-qa='days']"))))
				.selectByValue(day);
		new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[data-qa='months']"))))
				.selectByValue(month);
		new Select(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[data-qa='years']"))))
				.selectByValue(year);
	}

	public void checkNewsletter() {
		WebElement newsletter = driver.findElement(By.id("newsletter"));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
	}

	public void enterAddressDetails(String firstName, String lastName, String company, String address, String country,
			String state, String city, String zip, String phone) {
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
		new Select(driver.findElement(By.id("country"))).selectByVisibleText(country);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(zip);
		driver.findElement(By.id("mobile_number")).sendKeys(phone);
	}

	public void clickCreateAccount() {
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
	}

	public void clickContinue() {
		driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
	}

	public boolean isUserLoggedIn(String expectedName) {
		WebElement userInfo = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
		return userInfo.getText().contains(expectedName);
	}

}
