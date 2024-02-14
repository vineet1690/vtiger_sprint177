package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewOpportunityPage 
{
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="potentialname")
	private WebElement opportunitiesNameTextField;
	
	@FindBy(xpath="//select[@id='related_to_type']/../..//img[@src='themes/softed/images/select.gif']")
	private WebElement OrganizationLookUpButton;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[2]")
	private WebElement CompaignSourceLookUpButton;
	
	@FindBy(name="closingdate")
	private WebElement closingDateCalenderTextField;
	
	@FindBy(name="search_text")
	private WebElement organizationLookPageSearchTextField;
	
	@FindBy(name="search")
	private WebElement organizationLookUpPageSearchButton;
	
	@FindBy(name="search_text")
	private WebElement campaignLookPageSearchTextField;
	
	@FindBy(name="search")
	private WebElement campaignLookUpPageSearchButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement CreatingNewOpportunitySaveButton;

	public WebElement getOpportunitiesNameTextField() {
		return opportunitiesNameTextField;
	}

	public WebElement getOrganizationLookUpButton() {
		return OrganizationLookUpButton;
	}

	public WebElement getCompaignSourceLookUpButton() {
		return CompaignSourceLookUpButton;
	}

	public WebElement getClosingDateCalenderTextField() {
		return closingDateCalenderTextField;
	}
	
	public WebElement getOrganizationLookPageSearchTextField() {
		return organizationLookPageSearchTextField;
	}

	public WebElement getOrganizationLookUpPageSearchButton() {
		return organizationLookUpPageSearchButton;
	}
	
	public WebElement getCampaignLookPageSearchTextField() {
		return campaignLookPageSearchTextField;
	}

	public WebElement getCampaignLookUpPageSearchButton() {
		return campaignLookUpPageSearchButton;
	}

	public WebElement getCreatingNewOpportunitySaveButton() {
		return CreatingNewOpportunitySaveButton;
	}

	public void enterOpportunitiesName(String opportunityName)
	{
		opportunitiesNameTextField.sendKeys(opportunityName);
	}
	
	
	
	public void enterOrganizationDetailsinOrganizationLookUpPage(String titleOfPageToSwitch,String organizationName)
	{
		String parentWindowTitle = driver.getTitle();
		OrganizationLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBrowser(driver,titleOfPageToSwitch);
		organizationLookPageSearchTextField.sendKeys(organizationName);
		organizationLookUpPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		wUtils.switchToChildBrowser(driver,parentWindowTitle);
	}
	
	public void enterCampaignDetailsinCampaignSourceLookUpPage(String titleOfPageToSwitch,String campaignName)
	{
		String parentWindowTitle = driver.getTitle();
		CompaignSourceLookUpButton.click();
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToChildBrowser(driver,titleOfPageToSwitch);
		campaignLookPageSearchTextField.sendKeys(campaignName);
		campaignLookUpPageSearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		wUtils.switchToChildBrowser(driver,parentWindowTitle);
	}
	
	
	public void enterClosingDate(String dateInYYYY_MM_DD_Format)
	{
		closingDateCalenderTextField.sendKeys(dateInYYYY_MM_DD_Format);
		
	}
	
	public void clickOnSaveButton()
	{
		CreatingNewOpportunitySaveButton.click();
	}
	
	
	
	
	
	
	
	
}
