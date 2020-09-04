package testcases;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import config.Setup;
import config.Url;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import object.Button;
import utility.ReadExcel;

public class Test_Pilar extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] menu_footer_pilar_tampil() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Menu_Pilar_Tampil");
	}

	@DataProvider
	public String[][] menu_footer_pilar_tak_tampil() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Menu_Pilar_Tak_Tampil");
	}

	@DataProvider
	public String[][] pilar() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Pilar");
	}

	@DataProvider
	public String[][] pilar_hida_news() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "News_Content");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Pilar", dataProvider = "menu_footer_pilar_tampil")
	public void test_pilar_tampil_menu_footer(String menu) throws InterruptedException {
		Button button = PageFactory.initElements(driver, Button.class);
		Url url = PageFactory.initElements(driver, Url.class);

		url.defaultUrl();
		button.byId(menu);
		Thread.sleep(5000);
		button.byClassGetSize("img-menu-icon", 5);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, testName = "Pilar", dataProvider = "menu_footer_pilar_tak_tampil")
	public void test_pilar_tak_tampil_menu_footer(String menu) throws InterruptedException {
		Button button = PageFactory.initElements(driver, Button.class);
		Url url = PageFactory.initElements(driver, Url.class);

		url.defaultUrl();
		button.byId(menu);
		Thread.sleep(5000);
		button.byClassGetSize("img-menu-icon", 0);
	}

//	@Severity(SeverityLevel.CRITICAL)
//	@Test(priority = 0, testName = "Pilar", dataProvider = "menu_pilar")
//	public void test_pilar_video(String menu) throws InterruptedException {
//		Button button = PageFactory.initElements(driver, Button.class);
//		Url url = PageFactory.initElements(driver, Url.class);
//		Alert alert = PageFactory.initElements(driver, Alert.class);
//		
//		url.defaultUrl();
//		button.byId(menu);
//		Thread.sleep(5000);
//		
//		alert.byXpath("//button[@class='btn-nav-menu active btn btn-outline-secondary']", "Videos");
//	}
//
//	@Severity(SeverityLevel.CRITICAL)
//	@Test(priority = 0, testName = "Pilar", dataProvider = "pilar_hida_news")
//	public void test_pilar_news(String content) throws InterruptedException {
//		Button button = PageFactory.initElements(driver, Button.class);
//		Url url = PageFactory.initElements(driver, Url.class);
//		Alert alert = PageFactory.initElements(driver, Alert.class);
//
//		url.defaultUrl();
//		button.byXpath("//p[contains(text(),'News')]");
//		Thread.sleep(5000);
//
//		alert.byXpath("//button[@class='btn-nav-menu active btn btn-outline-secondary']", "News");
//
//		button.byClass(content);
//		Thread.sleep(10000);
//
//		if (alert.urlValidated("/detail")) {
//			button.byClassGetSize("img-menu-icon", 0);
//		} else {
//			if (alert.urlValidated("/channels")) {
//				button.byClassGetSize("img-menu-icon", 0);
//			}
//		}
//	}

//	@Severity(SeverityLevel.CRITICAL)
//	@Test(priority = 0, testName = "Pilar", dataProvider = "pilar")
//	public void test_pilar_klik(String pilar, String direct) throws InterruptedException {
//		Button button = PageFactory.initElements(driver, Button.class);
//		Url url = PageFactory.initElements(driver, Url.class);
//		Alert alert = PageFactory.initElements(driver, Alert.class);
//		
//		url.defaultUrl();
//		button.byXpath("//p[contains(text(),'"+ pilar +"')]");
//		Thread.sleep(5000);
//		
//		alert.urlValidate(direct);
//		alert.byXpath("//button[@class='btn-nav-menu active btn btn-outline-secondary']", pilar);
//	}

}
