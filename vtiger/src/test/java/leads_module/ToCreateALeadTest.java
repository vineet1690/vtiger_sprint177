package leads_module;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.IPathConstant;
import pomRepository.CreatingNewLeadPage;
import pomRepository.HomePage;
import pomRepository.LeadsInformationPage;
import pomRepository.LeadsPage;
/**
 * 
 * @author DELL
 *
 */
@Listeners(genericUtility.ListenersImplementationClass.class)
public class ToCreateALeadTest extends BaseClass
{
	@Test(priority=1,retryAnalyzer = genericUtility.RetryAnalyzerImplementationClass.class,groups="smoke")
	
	public void toCreateALeadAndToVerifyTheLeadDetails() throws EncryptedDocumentException, FileNotFoundException, IOException, SQLException
	{
		//Test Data
		String leadSalutation = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 0);
		String leadFirstName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 1);
		String leadLastName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 2);
		String leadCompanyName = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 3);
		String leadAssignedToGroupOption = eUtils.fetchStringDataFromExcelSheet(IPathConstant.LEAD_SHEET_NAME, 1, 4);
		
		//object creation statement of all rquired pom class for this test case
		
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		CreatingNewLeadPage createLeads = new CreatingNewLeadPage(driver);
		LeadsInformationPage leadInfo = new LeadsInformationPage(driver);
		
		//Assert.fail();
		//actual test script
		
		home.clickOnLeadsModule();
		leads.clickOnLeadsPlusButton();
		createLeads.selectLeadSalutation(leadSalutation);
		createLeads.enterLeadsFirstName(leadFirstName);
		createLeads.enterLeadsLastName(leadLastName);
		createLeads.enterLeadsCompanyName(leadCompanyName);
		createLeads.clickOnAssignedToGroupsRadioButton();
		createLeads.selectFromAssignToGroupDropDown(leadAssignedToGroupOption);
		createLeads.clickOnSaveButton();
		
		String actualLeadInfo = leadInfo.verifyLeadInformation(leadFirstName, leadLastName);
		
		Assert.assertTrue(actualLeadInfo.contains(leadLastName));
		System.out.println("pass the lead has been created ");
		
		System.out.println(dUtils.fetchDataFromDataBase(connection, "select * from lead;"));
		
		
		
		
		
		
	}

}
