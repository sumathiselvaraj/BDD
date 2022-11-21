package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testUtils.ExcelReader;
import testUtils.TestSetUp;

public class Hooks {

	TestSetUp testsetup;
	WebDriver driver;
	static Map<String, List<String>> m ;
	public Hooks(TestSetUp testsetup) 
	{

		this.testsetup = testsetup;
	}
	
	
//	@BeforeAll
//	public static void readExcel() throws IOException
//	{
//		//TestContext testContext;
//		String[][] data = ExcelReader.getExcelInfo("Sheet1");
//		System.out.println("!!!!!!!!!!!reading excel!!!!!!!!");		
//		for(int i=0;i<data.length;i++)
//		{			
//			List<String> lst = new ArrayList<String>();
//			for(int j=1;j<data[i].length;j++)
//		{
//			lst.add(data[i][j]);
//			//System.out.println(lst);
//		}
//			m.put(data[i][0], lst);
//			
//		}
//		
//		
//		
//	}
	
	@After
	public void AfterScenario() throws IOException 
	{
		
		testsetup.base.initialization().quit();
		
	}
	

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException 
	{
		driver = testsetup.base.initialization();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
	}
}
