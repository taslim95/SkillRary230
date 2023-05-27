package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *This class contains elements and respective business libraries of Testing page
 * @author Hp
 *
 */
public class TestingPage {
	// Declaration
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement pageHeader;

	@FindBy(id = "Python")
	private WebElement pythonImage;

	@FindBy(id = "cartArea")
	private WebElement myCart;

	@FindBy(xpath = "//ul/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;

	// Initialisation
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilisation
	/**
	 * This method returns page header of selenium Training page
	 * 
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}

	/**
	 * This method is used to get Python Image
	 	* 
	 * @return
	 */
	public WebElement getPythonImage() {
		return pythonImage;
	}

	/**
	 * this method is used to get MYCart area
	 * 
	 * @return
	 */
	public WebElement getMyCart() {
		return myCart;
	}

	/**
	 * this method is used to get facebook icon
	 * 
	 * @return
	 */
	public WebElement getFacebookIcon() {
		return facebookIcon;
	}

	/**
	 * this method is used to click on facebook
	 * 
	 * @return
	 */
	public void clickFacebook() {
		facebookIcon.click();
	}

}