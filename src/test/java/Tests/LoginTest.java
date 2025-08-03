package Tests;

import Bases.BaseTest;
import Pages.LoginPage;
import Utils.DatabaseUtils;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1 , enabled = true)
    public void testValidLoginFromDB () throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
       
        List<Map<String, String>> users = DatabaseUtils.getSignupUsers();
        for (Map<String, String> user : users) {
        	 
        	 String fullName = user.get("firstName") + " " + user.get("lastName");
             String email = user.get("firstName") + user.get("lastName") + "@mail.com";
        	loginPage.enterEmail( email);
        	loginPage.enterPassword("P@ssw0rd123");
        
        
        loginPage.clickLogin();

        
        Assert.assertTrue(loginPage.isUserLoggedIn(fullName), "User not logged in after signup");
        
        break;
    }
    }
}
