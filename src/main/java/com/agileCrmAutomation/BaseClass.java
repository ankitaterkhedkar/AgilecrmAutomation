package com.agileCrmAutomation;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public static WebDriver driver = null;

	public static void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":// System.setProperty("webdriver.chrome.driver","F:\\\\Ankita\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = setChromeCapabilities();
			driver = new ChromeDriver(options);
			break;
		case "edge":
			// System.setProperty("webdriver.edge.driver",
			// "C:\\Users\\hp\\Desktop\\Selenium
			// driver\\edgedriver_win64\\msedgedriver.exe");
			// driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			EdgeOptions options2 = setEdgeCapabilities();
			driver = new EdgeDriver(options2);
			break;
//		case "mozila":System.setProperty("webdriver.gecko.driver","C:\\Users\\hp\\Desktop\\Selenium driver\\geckodriver-v0.31.0-win64.zip\\geckodriver.exe");
		case "mozila":
			// System.setProperty("webdriver.gecko.driver",
			// "C:\\Users\\hp\\Desktop\\Selenium
			// driver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			// driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options1 = setFirefoxCapabilities();
			driver = new FirefoxDriver(options1);
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "F:\\\\Ankita\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	public static void click(By by, String msg) {
		boolean flag = true;
		while (flag) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(by));
				driver.findElement(by).click();
				System.out.println(msg);
				flag = false;

			} catch (StaleElementReferenceException e) {

			}

		}

	}

	public static void click(WebElement element, String msg) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//driver.findElement(element).click();
		System.out.println(msg);
	}

	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBeClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void fluentWait(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("Waiting for element to be available........");
				return driver.findElement(by);

			}

		});
	}

	public static void selectDroppdownValByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectDroppdownValByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectDroppdownValByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	private static ChromeOptions setChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.setHeadless(false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;

	}

	private static FirefoxOptions setFirefoxCapabilities() {
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("start-maximized");
		option.setHeadless(false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setCapability("prefs", prefs);
		// option.setExperimentalOption("prefs", prefs);
		// option.setExperimentalOption("excludeSwitches",
		// Arrays.asList("disable-popup-blocking"));
		return option;

	}

	private static EdgeOptions setEdgeCapabilities() {
		EdgeOptions option = new EdgeOptions();
		option.addArguments("start-maximized");
		option.setHeadless(false);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;

	}

}
