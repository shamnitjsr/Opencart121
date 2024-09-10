package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("**** Starting TC001_AccountRegistrationTest *****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("**** Clicked on MyAccount Link *****");

			hp.clickRegister();
			logger.info("**** Clicked on Register Link *****");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("**** Providing Customer details *****");

			// regpage.setFirstName("John");
			regpage.setFirstName(randomString().toUpperCase());

			// regpage.setLastName("David");
			regpage.setLastName(randomString().toUpperCase());

			// regpage.setEmail("hedf123456789@gmail.com"); // randomly generate the email
			regpage.setEmail(randomString() + "@gmail.com");

			// regpage.setTelephone("1234567890");
			regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();

			// regpage.setPassword("NewYorkLife@456");
			regpage.setPassword(password);

			// regpage.setConfirmPassword("NewYorkLife@456");
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("**** Validating expected message.. *****");
			String confmsg = regpage.getConfirmationMsg();

//		if(confmsg.equals("Your Account Has Been Created!123")) {
//			Assert.assertTrue(true);
//		}
//		else {
//			logger.error("Test Failed..");
//			logger.debug("Debug logs..");
//			Assert.assertTrue(false);
//		}
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}

		logger.info("**** Finished TC001_AccountRegistrationTest *****");
	}

}
