package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

@Test

public class SendContactDetailsTest extends BaseClass {

	public void sendContactDetailsTest() {
		SoftAssert soft=new SoftAssert();
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		
		web.scrollToElement(demoApp.getContactUs());
		demoApp.clickContactUs();
		
		soft.assertTrue(contact.getPageLogo().isDisplayed());
		Map<String,String> map=excel.readDataFromExcel("Sheet1");
		contact.sendDetails(map.get("FullName"),map.get("Email"),map.get("Subject") ,map.get("Message"));
		
		soft.assertAll();
	}

}
