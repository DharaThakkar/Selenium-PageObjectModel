package com.l2a.pages.crm.account;

import com.l2a.superbase.Page;

public class CrmAccountPage extends Page {

	public void gotoImport() {

	}

	public void gotoEdit() {

	}

	public void gotoView() {

	}

	public CrmCreateAccount gotoCreateAccount() {

		click("accountTopMenuAddButton_CSS");
		click("addAccountButton_CSS");
		//webDriver.findElement(By.cssSelector("crm-create-menu[class='lyteItem']")).click();
		//webDriver.findElement(By.cssSelector("a[id='submenu_Accounts']")).click();
		return new CrmCreateAccount();

	}

}
