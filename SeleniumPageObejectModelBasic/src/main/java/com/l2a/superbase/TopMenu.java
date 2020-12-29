package com.l2a.superbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.l2a.pages.crm.CrmHopePage;
import com.l2a.pages.crm.account.CrmAccountPage;

public class TopMenu {

	public WebDriver webDriver;

	public TopMenu(WebDriver webDriver) {

		this.webDriver = webDriver;
	}

	public CrmHopePage gotoHome() {
		
		webDriver.findElement(By.cssSelector("div[class='lyteMenuActive lyteItem'][data-value='Home']")).click();
		return new CrmHopePage();
	}

	public void gotoLeads() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Leads']")).click();

	}

	public void gotoContacts() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Contacts']")).click();

	}

	public CrmAccountPage gotoAccounts() {
		
		Page.click("topMenuAccount_XPATH");
		//webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Accounts']")).click();
		return new CrmAccountPage();
	}

	public void gotoDeals() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Potentials']")).click();

	}

	public void gotoActivities() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Activities']")).click();

	}

	public void gotoAnalytics() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Dashboards']")).click();

	}

	public void gotoReports() {
		
		webDriver.findElement(By.cssSelector("div[class=' lyteItem'][data-value='Reports']")).click();

	}

	public void gotoSignOut() {
		
		webDriver.findElement(By.cssSelector("lyte-button[class='profile-btn w50per'][data-zcqa='profilePicture_signOut']")).click();

	}

}
