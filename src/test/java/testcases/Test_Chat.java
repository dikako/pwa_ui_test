package testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import config.Setup;
import config.Url;
import object.Button;
import object.Input;
import utility.ReadExcel;

public class Test_Chat extends Setup {
	
	public String path = "../pwa_ui_test/src/main/java/data/data_test.xlsx";
	
	@DataProvider
	public String[][] list_chat() throws InvalidFormatException, IOException {
		ReadExcel read = new ReadExcel();
		return read.getCellData(path, "Chat");
	}
	
	@Test(priority = 0, testName = "Test Chat > Before Login > Type Chat", dataProvider = "list_chat")
	public void chat_test_before_login(String urlLiveTv, String username, String password, String nickname, String chatText) throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		Input input = PageFactory.initElements(driver, Input.class);
		
		System.out.println("Chat Test - Test Chatting Before Login");
		
		url.urls("/tv/" + urlLiveTv);
		button.byIdDisplay("btn-expand", true);
		button.byId("btn-expand");
		button.byId("popup-action-signin");
		input.byId("email", username);
		input.byId("password", password);
		button.byId("submit-login");
		Thread.sleep(5000);
		
		url.urls("/tv/" + urlLiveTv);
		button.byId("btn-expand");
		Thread.sleep(5000);
		input.byIdDisplay("chat-input", true);
		input.byId("chat-input", chatText + Keys.ENTER);
		input.validateInputTextByClassByIndexone("username",  nickname);
		input.validateInputTextByClassByIndexone("message",  chatText);
	}
	
//	@Test(priority = 0, testName = "Test Chat > After Login", dataProvider = "list_chat")
//	public void chat_test_after_login(String urlLiveTv, String username, String password, String nickname, String chatText) throws InterruptedException {
//		Url url = new Url(driver);
//		Button button = PageFactory.initElements(driver, Button.class);
//		Input input = PageFactory.initElements(driver, Input.class);
//		
//		System.out.println("Chat Test - Test Chatting After Login");
//		
//		
//		url.urls("/login");
//		input.byId("email", username);
//		input.byId("password", password);
//		button.byId("submit-login");
//		
//		url.urls("/tv/" + urlLiveTv);
//		button.byId("btn-expand");
//		input.byIdDisplay("chat-input", true);
//		input.byId("chat-input", chatText + Keys.ENTER);
//		input.validateInputTextByClassByIndexone("username",  nickname);
//		input.validateInputTextByClassByIndexone("message",  chatText);
//	}
	
	
}
