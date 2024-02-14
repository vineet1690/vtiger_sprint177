package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 
 */


public class WebDriverUtility 
{
	/**
	 * this is a method to wait for an element implicitely
	 * this method will handle AJAX call
	 * @param driver
	 */
	public void waitForElementsToLoaded(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
	}
	
	/**
	 * this method is used to maximize the browser window
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver) 
	{

		driver.manage().window().maximize();
	}
	
	/**
	 * it will check for the element in the GUI for polling time of 20 ms
	 * @param driver
	 * @param elementToClick
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement elementToClick )
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
	}
	
	/**
	 * it is used to select dropdown by using visible text
	 * @param dropdown
	 * @param option
	 */
	public void selectFromADropdown(WebElement dropdown,String option)
	{
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}
	
	/**
	 * it is used to select dropdown by using index
	 * @param dropdown
	 * @param index
	 */
	public void selectFromADropdown(WebElement dropdown,int index)
	{
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public void javaScriptClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(IPathConstant.JAVASCRIPT_COMMAND_FOR_CLICK,element );
	}
	
	public void javaScriptEnterValues(WebDriver driver,WebElement element,String value)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value="+value +"",element);
	}
	
	public static void takeAScreenShot(WebDriver driver,String filePath) throws WebDriverException, IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		Files.copy(ts.getScreenshotAs(OutputType.FILE), new File(filePath));
		
	}
	
	/**
	 * it is used to mouse over an element

	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnAElement(WebDriver driver,WebElement element)
	{
	  new Actions(driver).moveToElement(element).perform();
	}
	/**
	 * its used to switch to alert pop up and accept
	 * @param driver
	 */
	public void selectOkInAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * ts used to switch to alert pop up and dismiss
	 * @param driver
	 */
	public void selectCancelInAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 *  used to switch from one window to another window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToChildBrowser(WebDriver driver,String partialWindowTitle)
	{
		Set<String> allIDS = driver.getWindowHandles();
		
		for(String id:allIDS)
		{
			driver.switchTo().window(id);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	