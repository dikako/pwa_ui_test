package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Setup;
import config.Url;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Mylist extends Setup {
	
	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] mylist() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Mylist");
	}
	
	@Test(priority = 0, testName = "Mylis Test - After Login From Library", dataProvider = "mylist")
	public void mylist_after_login_library(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Mylis Test - After Login From Library");
		
		url.urls("/login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		
		url.urls("/explores");
		button.byClass("col-4");
		String getTitleBeforeAddMylist = alert.byClassGetText("content-title");
		System.out.println(getTitleBeforeAddMylist);
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);
		
		url.urls("/profile");
		button.byId("action-mylist");
		Thread.sleep(5000);
		button.byXpath("//strong[contains(text(),'" + getTitleBeforeAddMylist + "')]");
		String getTitleAfterAddMylist = alert.byClassGetText("content-title");
		Assert.assertEquals(getTitleBeforeAddMylist, getTitleAfterAddMylist);
		System.out.println(getTitleAfterAddMylist);
		
		//un Mylist
		button.byXpath("//h3[contains(text(),'My List')]");
	}
	
	@Test(priority = 1, testName = "Mylis Test Integration - After Login From Library", dataProvider = "mylist")
	public void integration_mylist_after_login_library(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Mylis Test Integration - After Login From Library");
		
		url.defaultUrl();
		button.byId("action-account");
		button.byId("button-login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-library");
		button.byClass("col-4");

		String getTitleBeforeAddMylist = alert.byClassGetText("content-title");
		System.out.println(getTitleBeforeAddMylist);
		button.byXpath("//h3[contains(text(),'My List')]");
		Thread.sleep(5000);
		
		button.byId("action-account");
		button.byId("action-mylist");
		Thread.sleep(5000);
		button.byXpath("//strong[contains(text(),'" + getTitleBeforeAddMylist + "')]");
		String getTitleAfterAddMylist = alert.byClassGetText("content-title");
		Assert.assertEquals(getTitleBeforeAddMylist, getTitleAfterAddMylist);
		System.out.println(getTitleAfterAddMylist);
		
		//un Mylist
		button.byXpath("//h3[contains(text(),'My List')]");
	}
}