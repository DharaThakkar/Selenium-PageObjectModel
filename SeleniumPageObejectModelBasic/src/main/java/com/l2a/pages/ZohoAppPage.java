package com.l2a.pages;

import org.openqa.selenium.By;

import com.l2a.pages.crm.CrmHopePage;
import com.l2a.superbase.Page;

public class ZohoAppPage extends Page {
	
	
	public void goToBooks() {
		
		click("zohoBooks_XPATH");
		//webDriver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[1]/div/a/div")).click();
		
	}
	
	public void goToCalender() {
		
		click("zohoCalender_CSS");
		
		//webDriver.findElement(By.cssSelector("span[class='_logo-calendar _logo-x96 zod-app-logo']")).click();
		
	}
	
	public void goToCRM() {
		
		click("zohoCrm_XPATH");
		//webDriver.findElement(By.cssSelector("span[class='_logo-crm _logo-x96 zod-app-logo']")).click();
		
	}

}
