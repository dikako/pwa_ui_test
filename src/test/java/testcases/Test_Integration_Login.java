package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Integration_Login extends Setup {

	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";

	@DataProvider
	public String[][] login_success() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Success");
	}

	@DataProvider
	public String[][] login_alert_username() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Username");
	}

	@DataProvider
	public String[][] login_alert_password() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Login_Alert_Password");
	}

	@Test(priority = 2, testName = "Login Success From Account -> Login", dataProvider = "login_success")
	public void login_logout_from_account(String visitUrl, String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Login");

		url.urls(visitUrl.replace(visitUrl, ""));
		button.byId("action-account");
		button.byId("button-login");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Test(priority = 2, testName = "Login Success Account -> History", dataProvider = "login_success")
	public void login_logout_from_history(String visitUrl, String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> History");

		url.urls(visitUrl.replace(visitUrl, ""));
		button.byId("action-account");
		button.byId("action-history");
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Test(priority = 2, testName = "Login Success Account -> Mylist", dataProvider = "login_success")
	public void login_logout_from_mylist(String visitUrl, String username, String password, String displayName)
			throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Mylist");

		url.urls(visitUrl.replace(visitUrl, ""));
		button.byId("action-account");
		button.byId("action-mylist");
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}

	@Test(priority = 2, testName = "Login Success Account -> Continue Watching", dataProvider = "login_success")
	public void login_logout_from_Continue_Watching(String visitUrl, String username, String password, String displayName) throws InterruptedException {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);

		System.out.println("Login Test Integration - Login Success From Account -> Continue Watching");

		url.urls(visitUrl.replace(visitUrl, ""));
		button.byId("action-account");
		button.byId("action-continue-watching");
		button.byId("pop-up-action-sign-in");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdGetText("action-profile", displayName);
		button.byId("action-profile");
		button.byId("action-three-dot");
		button.byId("action-logout");
		Thread.sleep(5000);
		button.byId("action-account");
		button.byIdDisplay("button-login", true);
	}
}
