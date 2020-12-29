package com.l2a.pages.crm.account;

import com.l2a.superbase.Page;

public class CrmCreateAccount extends Page {
	
	public void gotoAddAccount(String accountName) {
		
		click("addAccountName_CSS");
		//webDriver.findElement(By.cssSelector("input[id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(accountName);
	}

}
