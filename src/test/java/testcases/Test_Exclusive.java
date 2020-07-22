package testcases;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import io.qameta.allure.Description;
import object.Button;
import utility.ReadExcel;

public class Test_Exclusive extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] list_share() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Share");
	}

	@DataProvider
	public String[][] list_tab_menu_exclusive() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "List_Tab_Menu_Exclusive");
	}

	@Test(priority = 5, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void integration_exclusive_list_tab_menu_klik(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu");

		url.defaultUrl();
		Thread.sleep(4000);
		button.byId("action-exclusive");
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
		button.byClassByIndex("exclusive-item", indexToInteger);
		Thread.sleep(2000);
		button.byClassByTagByAttrToString("exclusive-item", indexToInteger, "a", "class", "active nav-link");
	}

	@Description("Exclusive Test - Validate List Tab Menu Klik")
	@Test(priority = 4, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void exclusive_list_tab_menu_klik(String index, String textValue) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu Klik");

		url.urls("/exclusive");
		Thread.sleep(4000);
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
		button.byClassByIndex("exclusive-item", indexToInteger);
		Thread.sleep(2000);
		button.byClassByTagByAttrToString("exclusive-item", indexToInteger, "a", "class", "active nav-link");
	}

	@Description("Exclusive Test - Validate List Tab Menu")
	@Test(priority = 3, testName = "Validate Tab Menu", dataProvider = "list_tab_menu_exclusive")
	public void exclusive_list_tab_menu(String index, String textValue) {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Tab Menu");

		url.urls("/exclusive");
		button.byClassesGetText("exclusive-item", indexToInteger, textValue);
	}

	@Description("Exclusive Test - Validate Thumbnail")
	@Test(priority = 0, testName = "Exclusive Test - Validate Thumbnail")
	public void exclusive_validate_thumbnail() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Exclusive Test - Validate Thumbnail");

		url.urls("/exclusive");
		Thread.sleep(4000);
		button.byClassDisplay("program-thumbnail", true);
	}

	@Description("Exclusive Test Integration - Validate Thumbnail ")
	@Test(priority = 1, testName = "Exclusive Test Integration - Validate Thumbnail")
	public void integration_exclusive_validate_thumbnail() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Exclusive Test Integration - Validate Thumbnail ");

		url.defaultUrl();
		Thread.sleep(4000);
		button.byId("action-exclusive");
		button.byClassDisplay("program-thumbnail", true);
	}

	@Description("Exclusive Test - Validate List Share")
	@Test(priority = 2, testName = "Validate List Share", dataProvider = "list_share")
	public void exclusive_validate_list_share(String index, String listShare) {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Integer indexToInteger = Integer.valueOf(index);

		System.out.println("Exclusive Test - Validate List Share");

		url.urls("/exclusive");
		button.byClass("program-share-button");
		button.byClassByTagByAttrToString("sheet-action-button-share", indexToInteger, "div", "aria-label", listShare);
	}
}
