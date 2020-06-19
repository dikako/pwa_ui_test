package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Button {
	WebDriver driver;

	public Button(WebDriver driver) {
		this.driver = driver;
	}

	public void byId(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byXpath(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byClass(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byCss(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byTag(String selector) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		System.out.println("Button is Clicked!");
	}

	public void byIdGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byXpathGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byClassGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.className(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byTagGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byCssGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byNameGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byLinkTextGetText(String selector, String buttonText) {
		WebElement element = driver.findElement(By.linkText(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.getText().toLowerCase().replace(" ", ""), buttonText.toLowerCase().replace(" ", ""));
		actions.build().perform();
		System.out.println("Button Text: " + element.getText());
	}
	
	public void byIdDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.id(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button is Displayed");
	}
	
	public void byXpathDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.xpath(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed on Account Menu");
	}
	
	public void byTagDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.tagName(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed on Account Menu");
	}
	
	public void byCssDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.cssSelector(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed on Account Menu");
	}
	
	public void byNameDisplay(String selector, boolean display) {
		WebElement element = driver.findElement(By.name(selector));
		waitForVisible(driver, element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		Assert.assertEquals(element.isDisplayed(), display);
		actions.build().perform();
		System.out.println("Button Login is Displayed on Account Menu");
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
