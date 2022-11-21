package pages;

import org.openqa.selenium.WebDriver;

import testUtils.Genericutil;



public class PageManager {
	
	public WebDriver driver;
	public LandingPage shopPg;
	
	Genericutil genericutils;
	
	public PageManager(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	
	public LandingPage getShoppingPage()
	
	{
		shopPg = new LandingPage(driver);
		
		return shopPg;
	}
	
	

}
