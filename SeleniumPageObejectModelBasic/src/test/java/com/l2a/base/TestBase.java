package com.l2a.base;

import org.testng.annotations.AfterSuite;

import com.l2a.superbase.Page;

public class TestBase {


	@AfterSuite

	public void tearDown() {

		Page.quit();

	}

}
