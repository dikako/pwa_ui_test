package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
	@Description("Test Search")
	public void search(String query) throws InterruptedException {

		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);

		System.out.println("Test Search");
		
		url.defaultUrl();
		Thread.sleep(5000);
		
		button.byXpath("//div[@class='search-input']");
		Thread.sleep(5000);
		
		input.byXpath("//input[@placeholder='Search for a program, genre, etc.']", query);
		Thread.sleep(5000);
	}
}
