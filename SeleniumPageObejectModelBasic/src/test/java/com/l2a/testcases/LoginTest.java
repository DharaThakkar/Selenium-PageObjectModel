package com.l2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;
import com.l2a.utilities.TestUtil;

import com.l2a.base.TestBase;
import com.l2a.pages.HomePage;
import com.l2a.pages.LoginPage;
import com.l2a.pages.ZohoAppPage;
import com.l2a.pages.crm.account.CrmAccountPage;
import com.l2a.pages.crm.account.CrmCreateAccount;
import com.l2a.superbase.Page;

public class LoginTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider ="dp")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException {

		HomePage home = new HomePage();
		Thread.sleep(4000);
		LoginPage login = home.goToLogin();
		login.doLogin(data.get("username"), data.get("password"));
		//zohoAppPage.goToCRM();
		// Thread.sleep(2000);
		// CrmAccountPage crmAccountPage = Page.topMenu.gotoAccounts();
		// CrmCreateAccount crmCreateAccount = crmAccountPage.gotoAddAccount();
		// crmCreateAccount.gotoCreateAccount("Dhara");

		/*
		 * LoginPage login = new LoginPage(); login.doLogin("damlani2106@gmail.com",
		 * "dhararavi"); ZohoAppPage zohoAppPage = new ZohoAppPage();
		 * zohoAppPage.goToCRM(); Thread.sleep(3000); Page.topMenu.gotoAccounts();
		 * CrmAccountPage crmAccountPage = new CrmAccountPage();
		 * crmAccountPage.gotoAddAccount(); CrmCreateAccount crmCreateAccount = new
		 * CrmCreateAccount(); crmCreateAccount.gotoCreateAccount("Dhara");
		 */

	}

}
