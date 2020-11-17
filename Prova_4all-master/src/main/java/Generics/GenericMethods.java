package Generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Pages.PageObject;

public class GenericMethods extends PageObject {

	public GenericMethods() {
		super(setChrome());		
	}
	
	public GenericMethods(WebDriver driver) {
		super(driver);
	}
	
	public static String getOS() {
		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.indexOf("win") >= 0) {
			return "win";
		}else if (os.indexOf("mac") >= 0) {
			return "mac";
		}

		return "";
	}
	
	public static WebDriver setChrome() {
		switch (getOS()) {
		case "mac":
			System.setProperty("webdriver.chrome.driver","drivers//chromedriver");		
			break;
		default:
			System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
			break;
		}
		return new ChromeDriver();
	}
	
	public static WebDriver setFirefox() {
		switch (getOS()) {
		case "mac":
			System.setProperty("webdriver.gecko.driver","drivers//geckodriver");		
			break;
		default:
			System.setProperty("webdriver.gecko.driver","drivers//geckodriver.exe");
			break;
		}
		return new ChromeDriver();
	}
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void getHomePage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void selectByVisibleText(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}

}
