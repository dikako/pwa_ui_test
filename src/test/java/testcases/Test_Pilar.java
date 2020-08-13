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
	public String[][] menu_pilar() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Menu_Pilar_Tampil");
	}

	@DataProvider
	public String[][] menu_pilar_() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Menu_Pilar_Not");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Pilar", dataProvider = "menu_pilar")
	public void test_pilar_tampil_menu_footer(String menu) throws InterruptedException {
		Button button = PageFactory.initElements(driver, Button.class);
		Url url = PageFactory.initElements(driver, Url.class);

		url.defaultUrl();
		button.byId(menu);
		Thread.sleep(5000);
		button.byClassGetSize("img-menu-icon", 5);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, testName = "Pilar", dataProvider = "menu_pilar_")
	public void test_pilar_tak_tampil_menu_footer(String menu) throws InterruptedException {
		Button button = PageFactory.initElements(driver, Button.class);
		Url url = PageFactory.initElements(driver, Url.class);

		url.defaultUrl();
		button.byId(menu);
		Thread.sleep(5000);
		button.byClassGetSize("img-menu-icon", 0);
	}

}
