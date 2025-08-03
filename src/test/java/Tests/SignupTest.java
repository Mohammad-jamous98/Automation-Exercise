package Tests;

import Bases.BaseTest;
import Pages.SignupPage;
import Utils.DatabaseUtils;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SignupTest extends BaseTest {

	@Test
	public void testSignupFromDatabase() throws Exception {

		List<Map<String, String>> users = DatabaseUtils.getSignupUsers();

		for (Map<String, String> user : users) {
			String fullName = user.get("firstName") + " " + user.get("lastName");
			String email = user.get("firstName") + user.get("lastName") + "@mail.com";
			String[] dobParts = user.get("date_of_birth").split("-");
			String year = dobParts[0];
			String month = dobParts[1].startsWith("0") ? dobParts[1].substring(1) : dobParts[1];
			String day = dobParts[2].startsWith("0") ? dobParts[2].substring(1) : dobParts[2];

			SignupPage signupPage = new SignupPage(driver);

			signupPage.navigateToSingup();

			signupPage.enterNameAndEmail(fullName, email);
			signupPage.selectGender();
			signupPage.enterPassword("P@ssw0rd123");
			signupPage.selectDateOfBirth(day, month, year);
			signupPage.checkNewsletter();
			signupPage.enterAddressDetails(user.get("firstName"), user.get("lastName"), user.get("company"),
					user.get("addressLine"), user.get("country"), user.get("state"), user.get("city"),
					user.get("postalCode"), user.get("phone"));
			signupPage.clickCreateAccount();
			signupPage.clickContinue();

			Assert.assertTrue(signupPage.isUserLoggedIn(fullName), "User not logged in after signup");

			break; // remove break if you want to sign up multiple users from DB
		}
	}
}
