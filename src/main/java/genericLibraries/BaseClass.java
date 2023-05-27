package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomClasses.ContactUsPage;
import PomClasses.SeleniumTrainingPage;
import PomClasses.SkillRaryHomePage;
import PomClasses.SkillraryDemoAppPage;
import PomClasses.TestingPage;
import genericLib.IConstantPath;

public class BaseClass {
	protected ExcelUtility excel;
	protected PropertiesUtilities property;
	protected WebDriverUtility web;
	protected WebDriver driver;

	protected SkillRaryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected ContactUsPage contact;

//@BeforeSuite
//@AfterSuite
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtilities();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);

	}

	@BeforeMethod
	public void methodConfig() {
		driver = web.launchBrowser(property.readData("browser"));
		web.maximizeBrowser();
		web.navigateToApp(property.readData("url"));
		web.waitUntilElementFound(Long.parseLong(property.readData("time")));

		home = new SkillRaryHomePage(driver);
		demoApp = new SkillraryDemoAppPage(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPage(driver);
		contact = new ContactUsPage(driver);

		home.chooseEnglish();
	}

	@AfterMethod
	public void methodTearDown() {
		web.quitAllWindow();
	}

	@AfterClass
	public void classTearDown() {
		excel.closeExcel();
	}
//AfterTest
//AfterSuit
}
