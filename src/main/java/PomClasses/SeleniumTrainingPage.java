package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.WebDriverUtility;

/**
 * This class contains element and respective business libraries and respective
 * page
 * 
 * @author Hp
 *
 */
public class SeleniumTrainingPage {
	// Declaration
	@FindBy(xpath = "//h1[@class='page-header']")
	private WebElement pageHeader;

	@FindBy(id = "add")
	private WebElement plusButton;

	@FindBy(id = "quantity")
	private WebElement quantity;

	@FindBy(xpath = "//button[.=' Add to Cart']")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='callout callout-success']/span")
	private WebElement message;

	// initialisation
	public SeleniumTrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilisation
	/**
	 * This method returns page header of Selenium Training page
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader.getText();

	}
	/**
	 * This method is used to double click on plus Button
	 * @param web
	 */
	public void doubleClickPlusButton(genericLibraries.WebDriverUtility web) {
    web.doubleClickOnElement(plusButton);
	}
    
	/**
	 * This method is used to get the quantity of added items
	 * @return
	 */
    public String getQuantity() {
    	return quantity.getAttribute("value");
    }
    
   /**
    * This method is used to click on add to cart button
    */
	public void clickAddToCart() {
    addToCartButton.click();
	}
	/**
	 * this method is used to get the text on the item added message
	 * @return
	 */
	public String getMessage() {
		return message.getText();
	}
}