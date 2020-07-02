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
	@Description("Continue Watching Test - After Login")
	@Test(priority = 0, testName = "Continue Watching Afetr Login", dataProvider = "continue_watching")
	public void continue_watching_after_login(String username, String password) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		
		System.out.println("Continue Watching Test - After Login");
		
//		url.urls("/login");
//		input.byId("email", username);
//		input.byId("password", password);
//		button.byId("submit-login");
//		Thread.sleep(5000);
//		button.byId("action-exclusive");
//		button.byXpath("//a[contains(text(),'Clip')]");
//		button.byClassByIndex("program-thumbnail", 0);
//		Thread.sleep(10000);
//		url.defaultUrl();
//		button.byId("action-account");
//		button.byClassDisplay("list-item-thumbnail", true);
	}
}
