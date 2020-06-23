package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import config.Setup;
import config.Url;
import object.Button;

public class Test_Radio extends Setup {
	
	@Test(priority = 0, testName = "Test Radio")
	public void radio_validate_url() {
		Url url = new Url(driver);
		
		System.out.println("Radio Test - Validate url direct");
		
		url.urls("/radio");
		String urlRadio = driver.getCurrentUrl();
		assert urlRadio.contains("radio");	
		System.out.println(urlRadio);
	}
	
	@Test(priority = 1, testName = "Integration Test Radio")
	public void radio_integration() throws InterruptedException {
		Url url = new Url(driver);
		Button button = PageFactory.initElements(driver, Button.class);
		
		System.out.println("Radio Test - Validate url direct");
		
		url.defaultUrl();
		button.byId("action-radio");
		Thread.sleep(2000);
		String urlRadio = driver.getCurrentUrl();
		assert urlRadio.contains("radio");
		System.out.println(urlRadio);
	}
}
