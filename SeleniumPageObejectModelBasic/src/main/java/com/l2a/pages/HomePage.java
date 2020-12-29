package com.l2a.pages;

import org.openqa.selenium.By;
import com.l2a.superbase.Page;

public class HomePage extends Page {

	public LoginPage goToLogin() {

		// driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/a[4]")).click();

		click("homeLogin_CSS");
		// webDriver.findElement(By.cssSelector("a[class='zh-login']")).click();
		return new LoginPage();

	}

	public void goToSignup() {

		click("homeSignUp_CSS");
		// webDriver.findElement(By.cssSelector("a[class='zh-signup']")).click();

	}

	public void goToSupport() {

		click("homeSupport_CSS");
		// webDriver.findElement(By.cssSelector("a[class='zh-support']")).click();

	}

}
