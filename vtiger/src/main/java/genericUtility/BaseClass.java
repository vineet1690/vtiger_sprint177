package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.jdbc.Driver;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	public ExcelUtility eUtils=new ExcelUtility();
	public JavaUtility jUtils=new JavaUtility();	
	public WebDriverUtility wUtils=new WebDriverUtility();
	public DataBaseUtility dUtils=new DataBaseUtility();
	public static WebDriver sDriver;
	public Connection connection;
	@BeforeSuite(groups = {"smoke","regression"})
	public void bsConfig() throws SQLException
	{
		
		Driver dataBaseDriver = new Driver();
				
		DriverManager.registerDriver(dataBaseDriver);
				
		connection = DriverManager.getConnection(IPathConstant.DATA_BASE_URL,IPathConstant.DATA_BASE_USERNAME,IPathConstant.DATA_BASE_PASSWORD);
		System.out.println("Data base connection achieved");
	}
	
	@BeforeClass(groups = {"smoke","regression"})
	public void bcConfig() throws IOException
	{
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		System.out.println("the browser is launched");
		sDriver=driver;
		wUtils.maximizeTheWindow(driver);
		wUtils.waitForElementsToLoaded(driver);
		driver.get(url);
		System.out.println("the url is navigated");
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void bmConfig() throws IOException
	{
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("login to the application");
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void amConfig()
	{
		HomePage home = new HomePage(driver);
		home.signOutAction();
		System.out.println("signout from the application");
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("the Browser is closed");
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void asConfig() throws SQLException
	{
		connection.close();
		System.out.println("Data base connection is closed");
	}

}
