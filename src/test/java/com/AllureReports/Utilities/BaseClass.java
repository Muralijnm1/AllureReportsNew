package com.AllureReports.Utilities;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	/*
	 * public String username=readconfig.getUsername(); public String
	 * password=readconfig.getPassword();
	 */
	public static WebDriver driver;

	// public static Logger logger;

	public void setUp() {

		String br = readconfig.getBrowser();
		// logger = Logger.getLogger("ebanking");
		// PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			System.out.println("The chrome path is " + System.getProperty("webdriver.chrome.driver"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

		driver.get(baseURL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void tearDown() {
		driver.quit();
	}

	/*
	 * public void captureScreen(WebDriver driver, String tname) throws
	 * IOException { TakesScreenshot ts = (TakesScreenshot) driver; File source
	 * = ts.getScreenshotAs(OutputType.FILE); File target = new
	 * File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	 * FileUtils.copyFile(source, target); System.out.println("Screenshot taken"
	 * ); }
	 */

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public void hoverOverOnMenu(WebElement webElementHoverOver, WebElement webElementMenuEditOption)
			throws InterruptedException {

		// Thread.sleep(40);
		WebElement webElementClickable = waitUntilClickable(webElementHoverOver);
		int count = 0;
		try {
			Actions builder = new Actions(driver);
			Actions hoverOverRegister = builder.moveToElement(webElementClickable);
			hoverOverRegister.perform();
			if (isElementExist(webElementMenuEditOption)) {
				System.out.println("\n 1st time hoverover performed on " + webElementHoverOver.getText());
				return;
			}
		} catch (StaleElementReferenceException e) {
			if (count == 0) {
				Actions builder = new Actions(driver);
				Actions hoverOverRegister = builder.moveToElement(webElementClickable);
				hoverOverRegister.perform();
				if (isElementExist(webElementMenuEditOption)) {
				System.out.println("\n 2nd time hoverover performed on " + webElementHoverOver.getText());
				}
				count=+1;
				return;
			} else {
				System.out.println("\nnot able to hoverover performed on" + e.getMessage());
			}
		} catch (TimeoutException e) {
			if (count == 0 && (!isElementExist(webElementMenuEditOption))) {
				Actions builder = new Actions(driver);
				Actions hoverOverRegister = builder.moveToElement(webElementClickable);
				hoverOverRegister.perform();
			} else {
				System.out.println("\nnot able to hoverover performed on" + e.getMessage());
			}
		}

		Thread.sleep(50);
	}

	public boolean isElementExist(WebElement webElement) {

		if ((webElement.getSize().getHeight()) > 0 && (webElement.getSize().getWidth()) > 0) {
			System.out.println("The element does exist");
			return true;
		}
		return false;
	}

	public WebElement isElementExistWithElementReturn(WebElement webElement) {

		if ((webElement.getSize().getHeight()) > 0 && (webElement.getSize().getWidth()) > 0) {
			System.out.println("The element does exist");
			return webElement;
		}
		return webElement;
	}

	public WebElement waitUntilClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		int count = 0;
		try {
			WebElement webElementExist = waitUntilElementExist(webElement);
			WebElement webElementClickable = wait.until(ExpectedConditions.elementToBeClickable(webElementExist));
			return webElementClickable;
		} catch (StaleElementReferenceException e) {
			if (count == 0) {
				WebElement webElementExist = waitUntilElementExist(webElement);
				WebElement webElementClickable = wait.until(ExpectedConditions.elementToBeClickable(webElementExist));
				count = +1;
				return webElementClickable;
			}
			System.out.println("waitUntilClickable:" + webElement.getText() + " " + e.getMessage());
		}
		return null;
	}

	public void enterText(WebElement webElement, String txt) {
		WebElement webElementExist = waitUntilElementExist(webElement);
		webElementExist.clear();
		webElementExist.sendKeys(txt);		
	}
	
	public WebElement waitUntilElementExist(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement webElement1 = (WebElement) wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement1;
	}

	public WebElement smartWait(final WebElement webElement) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}

	/*
	 * public static void closeAllPopups() { String parentWindow =
	 * driver.getWindowHandle(); Set<String> allWindowHandles =
	 * driver.getWindowHandles(); for (String handle : allWindowHandles) { if
	 * (!handle.equals(parentWindow)) { driver.switchTo().window(handle);
	 * System.out.println(driver.getTitle()); driver.close(); } }
	 * driver.switchTo().window(parentWindow);
	 * System.out.println(driver.getTitle()); }
	 */
	public void closeAllPopups() {
		Object[] a;
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		a = allWindowHandles.toArray();
		int size = a.length;
		for (int i = 0; i < size; i++) {
			System.out.println(a[i]);
			if (i == 1) {
				driver.switchTo().window((String) a[i]);
				System.out.println(driver.getTitle());
				// driver.close();
			}
		}
		/*
		 * for (String handle : allWindowHandles) { if
		 * (!handle.equals(parentWindow)) { driver.switchTo().window(handle);
		 * System.out.println(driver.getTitle()); driver.close(); }
		 */
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
	}

	public void closeAllAlerts() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			alert.dismiss();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean isElementVisible(WebElement webElement) {
		int width = webElement.getSize().width;
		int height = webElement.getSize().height;
		return (width > 0 && height > 0) ? true : false;
	}

	public boolean isElementEnable(WebElement webElement) {
		return (webElement.isEnabled()) ? true : false;
	}

	/*
	 * public void waitUntilElementVisible(WebElement webElement){ WebDriverWait
	 * wait = new WebDriverWait(driver,30);
	 * wait.until(ExpectedConditions.visibilityOf(webElement)); }
	 */
	/*
	 * public void waitUntilElementClickable(WebElement webElement){
	 * WebDriverWait wait = new WebDriverWait(driver,30);
	 * wait.until(ExpectedConditions.elementToBeClickable(webElement)); }
	 */

	public void pageScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void pageScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
	}

	public void pageScrollDownTillBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.ScrollHeight)");
	}

	public void navigateForward() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.forward");
		wait(1000);
	}

	public void navigateBackward() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.history.backward");
		wait(1000);
	}

	public void wait(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickOn(WebElement webElement) {
		webElement = waitUntilClickable(webElement);
		webElement.click();
	}

}
