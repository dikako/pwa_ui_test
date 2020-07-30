package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Continue_Watching extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] continue_watching() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Continue_Watching");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Continue Watching Test - From Exlcuisve")
	@Test(priority = 0, testName = "Continue Watching Test - From Exlcuisve", dataProvider = "continue_watching")
	public void continue_watching_from_exclusive(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Continue Watching Test - From Exlcuisve");
		
		url.urls("/login");
		Thread.sleep(4000);
		alert.byClass("header-nav-verif", "Login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		button.byId("action-exclusive");
		Thread.sleep(4000);
		button.byXpath("//a[contains(text(),'Clip')]");
		Thread.sleep(5000);
		button.byXpath("//div[contains(@class,'tab-pane active')]//div[2]//div[1]//div[2]//img[1]");
		Thread.sleep(40000);
		button.byId("action-home");
		Thread.sleep(4000);
		button.byId("action-account");
		Thread.sleep(5000);
		button.byClassNotNull("list-item-thumbnail");
		
		//Delete Continue Watching
		button.byId("action-continue-watching");
		Thread.sleep(5000);
		alert.byClass("header-nav-verif", "Continue Watching");
		button.byClassByIndex("action-button", 0);
	}
}
