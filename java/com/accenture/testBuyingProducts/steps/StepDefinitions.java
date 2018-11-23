package com.accenture.testBuyingProducts.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import net.thucydides.core.annotations.Steps;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.runner.RunWith;
import com.accenture.testBuyingProducts.ReadWriteFile;
import com.accenture.testBuyingProducts.steps.serenity.EndUserSteps;

@RunWith(Cucumber.class)
public class StepDefinitions {
	
	@Steps
	EndUserSteps johnDoe;

    @Given("^the user is logged in into the NinjaStore home page with the credentials \"([^\"]*)\" , \"([^\"]*)\"$")
    public void the_user_is_logged_in_into_the_ninjastore_home_page_with_the_credentials_something_something(String user, String password) throws Throwable {
    	johnDoe.OpenHomePage();
    	johnDoe.LoginMenu();
    	johnDoe.EnterUser(user);
    	johnDoe.EnterPassword(password);
    }

    @When("^the user looks up for the products and add them to the shopping cart$")
    public void the_user_looks_up_for_the_products_something_and_add_them_to_the_shopping_cart() throws Throwable {
    	//Read Excel File
    	ReadWriteFile file = new ReadWriteFile();
    	Map<Integer, java.util.List<String>> celdas = file.ReadFile();
    	for (int j = 0; j < celdas.get(0).size(); ) {
    		String items = celdas.get(0).get(j);
    		System.out.println(celdas.get(0).get(j));
			johnDoe.LookUpForProducts(items);
            johnDoe.AddProductToShoppingCart();
            johnDoe.ClearSearchTextBox();
            j++;
		}
    	johnDoe.ReviewCart();
    }

    @Then("^the user should see the shopping cart list$")
    public void the_user_should_see_the_shopping_cart_list() throws Throwable {
        assertTrue(johnDoe.ValidateCheckout());
    }
}
