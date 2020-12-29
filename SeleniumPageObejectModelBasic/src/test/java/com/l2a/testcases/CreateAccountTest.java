package com.l2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.l2a.pages.ZohoAppPage;
import com.l2a.pages.crm.account.CrmAccountPage;
import com.l2a.pages.crm.account.CrmCreateAccount;
import com.l2a.superbase.Page;
import com.l2a.utilities.TestUtil;

public class CreateAccountTest {
	
	@Test(dataProviderClass = TestUtil.class, dataProvider ="dp")
	public void createAccountTest(Hashtable<String, String> data) throws InterruptedException {
		
		ZohoAppPage zohoAppPage = new ZohoAppPage();
		zohoAppPage.goToCRM();
		Thread.sleep(2000);
		CrmAccountPage crmAccountPage = Page.topMenu.gotoAccounts();
		
		CrmCreateAccount crmCreateAccount = crmAccountPage.gotoCreateAccount();
		crmCreateAccount.gotoAddAccount(data.get("accountname"));
		
		
	}

}
