package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Input {
	WebDriver driver;
	
	public Input(WebDriver driver) {
		this.driver = driver;
	}
	
	public void byId(String selector, String value) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byXpath(String selector, String value) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byClass(String selector, String value) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byTag(String selector, String value) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byCss(String selector, String value) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byName(String selector, String value) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		System.out.println("Input Value: " + value);
	}
	
	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	public void byClassDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Form Input is Displayed");
	}
	
	private void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(5000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
