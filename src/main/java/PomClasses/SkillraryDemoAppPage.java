package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class SkillraryDemoAppPage {
/**
 * This contains elements and respective business libraries of skillrary Demo App
 */
	//Declaration
	@FindBy(xpath = "//a[@class='navbar-brand'")
	private WebElement logo;
	
	@FindBy(id = "course")
	private WebElement courseTab;
	
	@FindBy(xpath = "//span/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	 
	@FindBy(name ="addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactus;
	
	
	//Initialization
	
	public SkillraryDemoAppPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * This method is used to return text on the logo
	 * @return
	 */
	public String getLogoText()
	{
		return logo.getText();
	}
	
	/**
	 * This method is used to mouseHover on courseTab
	 * @param web
	 */
	public void mouseHoverToCourse(WebDriverUtility web)
	{
		web.mouseOver(courseTab);
	}
	
	/**
	 * This method is used to click on selenium Training
	 */
	public void clickSeleniumTraining()
	{
		seleniumTrainingLink.click();
	}
	/**
	 * This method is used to select category from drop down based on index
	 * @param web
	 * @param index
	 */
	
	public void selectCategory(WebDriver web,int index)
	{
		web.dropDown(categoryDD,index);
	}
	
	/**
	 * This method is used to return contactUs link
	 * @return
	 */
	public WebElement getContactUs()
	{
		return contactus;
	}
	
	public void clickContactUs()
	{
		contactus.click();
	}
}
