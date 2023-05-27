package testScripts;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddTestingCourseToMyCartTest {
	@Test
	public void addPythonToMyCart()
	{
		SoftAssert soft=new SoftAssert();
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		 soft.assertTrue(demoApp.getLogoText().contains("ECommerce"));
		 
		 demoApp.selectCategory(web,1);
		 soft.assertEquals(testing.getPageHeader(),"Testing");
		 
		 web.scrollToElement(testing.getPythonImage());
		 web.dragAndDropElement(testing.getPythonImage()),testing.getMyCart());
		  
		 web.scrollToElement(testing.getFacebookIcon());
		 testing.clickFacebook();
		  soft.assertAll();
		
		
	}

}
