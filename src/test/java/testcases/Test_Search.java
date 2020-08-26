package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Search extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] datasearch() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Search");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Program")
	@Test(priority = 0, testName = "Test Search Program", dataProvider = "datasearch")
	public void search_program(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Program");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("programs");
		alert.byXpath("//h1[@class='content-title']", query);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Episode")
	@Test(priority = 1, testName = "Test Search Episode", dataProvider = "datasearch")
	public void search_episode(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Episode");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Episode')]");

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("episode");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Extra")
	@Test(priority = 2, testName = "Test Search Extra", dataProvider = "datasearch")
	public void search_extra(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Extra");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Extra')]");

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("extra");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Clip")
	@Test(priority = 3, testName = "Test Search Clip", dataProvider = "datasearch")
	public void search_clip(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Clip");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Clip')]");

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("clip");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Photo")
	@Test(priority = 4, testName = "Test Search Photo", dataProvider = "datasearch")
	public void search_photo(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Photo");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Photo')]");

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("photo");
	}
	

	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Program")
	@Test(priority = 5, testName = "Test Search Program", dataProvider = "datasearch")
	public void search_program_search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Program");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);

		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("programs");
		alert.byXpath("//h1[@class='content-title']", query);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Episode")
	@Test(priority = 6, testName = "Test Search Episode", dataProvider = "datasearch")
	public void search_episode_search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Episode");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Episode')]");

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("episode");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Extra")
	@Test(priority = 7, testName = "Test Search Extra", dataProvider = "datasearch")
	public void search_extra_search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Extra");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Extra')]");

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("extra");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Clip")
	@Test(priority = 8, testName = "Test Search Clip", dataProvider = "datasearch")
	public void search_clip_search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Clip");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Clip')]");

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("clip");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Search Photo")
	@Test(priority = 9, testName = "Test Search Photo", dataProvider = "datasearch")
	public void search_photo_search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);

		System.out.println("Test Search Photo");

		url.defaultUrl();
		Thread.sleep(5000);

		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);
		
		button.byXpath("//a[contains(text(),'Photo')]");

		alert.byXpath("//div[@class='tab-pane active']//p[@class='title'][contains(text(),'Search Result')]",
				"Search Result");

		button.byXpath("//div[@class='tab-pane active']//div[@class='content-list']//div[2]//img[1]");
		Thread.sleep(5000);
		
		alert.urlValidate("photo");
	}
}
