package com.l2a.rough;

import com.l2a.pages.ZohoAppPage;
import com.l2a.pages.crm.account.CrmAccountPage;
import com.l2a.pages.crm.account.CrmCreateAccount;
import com.l2a.superbase.Page;
import com.l2a.base.TestBase;
import com.l2a.pages.HomePage;
import com.l2a.pages.LoginPage;

public class LoginTest extends TestBase {

	public static void main(String[] args) throws InterruptedException {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		ZohoAppPage zohoAppPage = login.doLogin("damlani2106@gmail.com", "dhararavi");
		zohoAppPage.goToCRM();
		Thread.sleep(2000);
		CrmAccountPage crmAccountPage = Page.topMenu.gotoAccounts();
		CrmCreateAccount crmCreateAccount = crmAccountPage.gotoCreateAccount();
		crmCreateAccount.gotoAddAccount("Dhara");

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
