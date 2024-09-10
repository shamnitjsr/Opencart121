package testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {

		logger.info("***** Starting TC_002_LoginTest *****");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			
			logger.info("Entering valid email and password");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			
			
			
			lp.clickLogin();
			logger.info("Clicked on login button");

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);

			boolean targetPage = macc.isMyAccountPageExits();
			
			Assert.assertEquals(targetPage, true, "Login Failed");

			//Assert.assertTrue(targetPage); 

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC_002_LoginTest *****");
	}
}
