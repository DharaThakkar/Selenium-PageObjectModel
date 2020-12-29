package com.l2a.pages;

import org.openqa.selenium.By;
import com.l2a.superbase.Page;

public class LoginPage extends Page {

	public ZohoAppPage doLogin(String username, String password) throws InterruptedException {

		type("loginEmail_CSS", username);
		click("loginNextButton1_CSS");
		type("loginPassword_CSS", password);
		click("loginNextButton2_CSS");
		Thread.sleep(22000);
		//click("loginNextButton3_CSS");
		//click("loginTrustButton_CSS");
		Thread.sleep(12000);

		/*
		 * webDriver.findElement(By.cssSelector("input[id='login_id']")).sendKeys(
		 * username); webDriver.findElement(By.
		 * cssSelector("button[class='btn blue'][id='nextbtn'][tabindex='2']")).click();
		 * webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys(
		 * password); webDriver.findElement(By.
		 * cssSelector("button[class='btn blue'][id='nextbtn'][tabindex='2']")).click();
		 * Thread.sleep(22000); webDriver.findElement(By.
		 * cssSelector("button[class='btn blue'][id='nextbtn'][tabindex='2']")).click();
		 * webDriver.findElement(By.
		 * cssSelector("button[class='btn blue trustdevice trustbtn']")).click();
		 * Thread.sleep(12000);
		 */
		return new ZohoAppPage();

	}

}
