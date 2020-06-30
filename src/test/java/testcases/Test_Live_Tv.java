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
import utility.ReadExcel;

public class Test_Live_Tv extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] live_tv_active_tab() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Live_Tv_Active_Tab");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("Live Tv Test - Validate Live Tv")
	@Test(priority = 0, testName = "Validate Live Tv", dataProvider = "live_tv_active_tab")
	public void live_tv_active_tab(String liveTv) throws InterruptedException {
		Url url = new Url(driver);
		// Input input = PageFactory.initElements(driver, Input.class);
		// Button button = PageFactory.initElements(driver, Button.class);
		Alert alerts = PageFactory.initElements(driver, Alert.class);

		System.out.println("Live Tv Test - Validate Live Tv");

		url.urls("/" + liveTv);
		Thread.sleep(5000);
		alerts.byXpathByAttrValidateValueAttr("//button[contains(text(),'" + liveTv + "')]", "class", "selected");
	}
}
