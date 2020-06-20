package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Setup;
import config.Url;
import object.Alert;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Register extends Setup {
	
	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";
	
	@DataProvider
	public String[][] register_email_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Email_Alert");
	}
	
	@DataProvider
	public String[][] register_phone_alert() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Phone_Alert");
	}
	
	@DataProvider
	public String[][] register_password1_alert_email() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password1_Alert_Email");
	}
	
	@DataProvider
	public String[][] register_password2_alert_email() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password2_Alert_Email");
	}
	
	@DataProvider
	public String[][] register_password1_alert_phone() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password1_Alert_Phone");
	}
	
	@DataProvider
	public String[][] register_password2_alert_phone() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Register_Password2_Alert_Phone");
	}
	
	@Test(priority = 3, testName = "Register Phone Number Alert", dataProvider = "register_phone_alert")
	public void register_alert_phone(String phone, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Phone Number");
		
		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-phone-number", alertText);
	}
	
	@Test(priority = 3, testName = "Register Password1 Alert Phone", dataProvider = "register_password1_alert_phone")
	public void register_phone_alert_password1(String phone, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Phone Password Form 1");
		
		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-num-chars", alertText);
	}
	
	@Test(priority = 3, testName = "Register Password 2Alert Phone", dataProvider = "register_password2_alert_phone")
	public void register_phone_alert_password2(String phone, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Phone Password Form 2");
		
		url.urls("/register");
		button.byId("register-phone");
		input.byId("phone_number", phone);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-not-match", alertText);
	}
	
	@Test(priority = 0, testName = "Register Email Alert", dataProvider = "register_email_alert")
	public void register_alert_email(String email, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Email");
		
		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-email", alertText);
	}
	
	@Test(priority = 0, testName = "Register Password1 Alert", dataProvider = "register_password1_alert_email")
	public void register_email_alert_password1(String email, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Password Form 1");
		
		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-num-chars", alertText);
	}
	
	@Test(priority = 0, testName = "Register Password 2Alert", dataProvider = "register_password2_alert_email")
	public void register_email_alert_password2(String email, String password, String rePassword, String alertText) {
		Url url = new Url(driver);
		Input input = PageFactory.initElements(driver, Input.class);
		Button button = PageFactory.initElements(driver, Button.class);
		Alert alert = PageFactory.initElements(driver, Alert.class);
		
		System.out.println("Register Test - Alert Password Form 2");
		
		url.urls("/register");
		input.byId("email", email);
		input.byId("password", password);
		input.byId("password2", rePassword);
		button.byId("button-next");
		alert.byId("invalid-password-not-match", alertText);
	}
}
