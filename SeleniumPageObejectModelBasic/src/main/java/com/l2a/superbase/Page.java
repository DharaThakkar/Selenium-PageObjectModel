package com.l2a.superbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.l2a.utilities.ExcelReader;
import com.l2a.utilities.ExtentManager;
import com.l2a.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {

	public static WebDriver webDriver;
	public static TopMenu topMenu;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(Page.class.getName());
	public static Date d = new Date();
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");

	public static ExtentTest test;
	public ExtentReports rep = ExtentManager.getInstant();

	public static WebDriverWait wait;
	public static String browser;

	public Page() {

		if (webDriver == null) {

			System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));
			PropertyConfigurator.configure(
					"/Users/RaviAmlani/eclipse-workspace-Dhara/Projects/SeleniumPageObejectModelBasic/src/test/resources/properties/log4j.properties");
			FileInputStream fis = null;
			try {

				fis = new FileInputStream(
						"/Users/RaviAmlani/eclipse-workspace-Dhara/Projects/SeleniumPageObejectModelBasic/src/test/resources/properties/Config.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			try {

				config.load(fis);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.info("Config file loaded");

			try {

				fis = new FileInputStream(
						"/Users/RaviAmlani/eclipse-workspace-Dhara/Projects/SeleniumPageObejectModelBasic/src/test/resources/properties/OR.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			try {

				or.load(fis);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			log.info("OR file loaded");

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}
			config.setProperty("browser", browser);

			if (config.getProperty("browser").equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				// System.setProperty("webdriver.gecko.driver",
				// "/Users/RaviAmlani/eclipse-workspace-Dhara/Projects/SeleniumProjectOne/src/test/resources/executables/geckodriver");
				webDriver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();

				// Following few lines are for configure chrome how we need and handle
				// notification, extensions etc.
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("prefs", prefs);
				chromeOptions.addArguments("--disable-extensions");
				chromeOptions.addArguments("--disable-infobars");

				// initialized driver
				webDriver = new ChromeDriver(chromeOptions);

				log.info("Chrome Launched");

			}

			webDriver.get("https://www.zoho.com/");
			webDriver.get(config.getProperty("testurl"));
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			
			topMenu = new TopMenu(webDriver);
			
			wait = new WebDriverWait(webDriver, 5);

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {
		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// Report NG
			Reporter.log("<br>" + "Verification failure: " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"blank\" href=" + TestUtil.screenshotName + "><image src="
					+ TestUtil.screenshotName + " height= 200 width=200></image></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(LogStatus.FAIL, " Verification Failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}
	}

	public static void click(String locator) {

		if (locator.endsWith("_CSS")) {
			webDriver.findElement(By.cssSelector(or.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			webDriver.findElement(By.xpath(or.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			webDriver.findElement(By.id(or.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clicking on:" + locator);

	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			webDriver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			webDriver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			webDriver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		}
		test.log(LogStatus.INFO, "Typing in:" + locator + " entered value as " + value);

	}

	public static WebElement dropdown;

	public static void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = webDriver.findElement(By.cssSelector(or.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = webDriver.findElement(By.xpath(or.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = webDriver.findElement(By.id(or.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO, "Selecting from dropdown:" + locator + " entered value: " + value);

	}

	public static boolean isElementPresent(By by) {

		try {

			webDriver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;
		}

	}

	public static void quit() {

		if (webDriver != null) {

			webDriver.quit();
		}
		log.info("Chrome Closed");

	}

}
