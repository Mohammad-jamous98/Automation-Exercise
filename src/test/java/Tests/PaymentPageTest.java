package Tests;

import Bases.BaseTest;
import Pages.LoginPage;
import Pages.ProductsPage;
import Pages.PaymentPage;
import Utils.DatabaseUtils;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class PaymentPageTest extends BaseTest {

	@Test(priority = 3)
	public void testCompleteOrder() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigateToLoginPage();

		Map<String, String> user = DatabaseUtils.getSignupUsers().get(0);
		String email = user.get("firstName") + user.get("lastName") + "@mail.com";
		loginPage.enterEmail(email);
		loginPage.enterPassword("P@ssw0rd123");
		loginPage.clickLogin();

		// 2. Move To Cart Page
		driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

		// 3. Proceed to Checkout
		driver.findElement(By.cssSelector("a.check_out")).click();

		// 4. Place Order
		driver.findElement(By.xpath("//a[contains(@href, '/payment') and contains(text(), 'Place Order')]")).click();

		// 5. Fill Payment Form
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.enterNameOnCard("Your Name");
		paymentPage.enterCardNumber("1234123412341234");
		paymentPage.enterCVC("123");
		paymentPage.enterExpiryMonth("12");
		paymentPage.enterExpiryYear("2026");
		paymentPage.clickPayAndConfirm();
		

		Assert.assertTrue(paymentPage.isOrderConfirmed(), "Order was not confirmed!");
		
		paymentPage.clickContinueAfterOrder();
	}
}
