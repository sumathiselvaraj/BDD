package stepDefinitions;

import java.util.Iterator;
import java.util.List;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import testUtils.TestSetUp;

public class LandingStepDef {


	TestSetUp testSetUp;
	LandingPage shopPg;
	
	public LandingStepDef(TestSetUp testSetUp)
	{
		this.testSetUp = testSetUp;
		this.shopPg = testSetUp.pgMngr.getShoppingPage();
	}
	@Given("User lands in Green Cart Home Page")
	public void user_lands_in_green_cart_home_page() {
		Assert.assertTrue(shopPg.getTitleLandingPage().contains("Green"));
	}
	@When("User click Top deal link")
	public void user_click_top_deal_link() {
		shopPg.selectTopDealsPage();
		}

	
	@When("User search the product from {string} and rownumber {string}")
	public void user_search_the_product_from_and_rownumber(String SheetName, String RowNumber) throws Throwable {

		//*********   data from excel  **********  //
		
		
	
		List<String> lst = Hooks.m.get(RowNumber);
        Iterator<String> itr = lst.iterator();
        String shortName=itr.next();
      


		
		shopPg.searchItem(shortName);
		System.out.println(testSetUp.shortName);
		Thread.sleep(1000);
		testSetUp.productName = shopPg.getProductName().split("-")[0].trim();
		
		
		System.out.println("testsetup.productname :" + testSetUp.productName);
	}
	@Then("User exctract the actual name of the product")
	public void user_exctract_the_actual_name_of_the_product() {
		Assert.assertEquals(testSetUp.productName, testSetUp.originalName);
	}
	
	
}
