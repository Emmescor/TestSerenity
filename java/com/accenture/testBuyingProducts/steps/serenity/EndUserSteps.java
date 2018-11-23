package com.accenture.testBuyingProducts.steps.serenity;

import com.accenture.testBuyingProducts.pages.HomePage;
import net.thucydides.core.annotations.Step;


public class EndUserSteps {

    HomePage homePage;

    @Step
    public void OpenHomePage() {
        homePage.open();
    }
    
    @Step
    public void LoginMenu() {
    	homePage.EnterLoginMenu();
    }
    
    @Step
    public void EnterUser(String user) {
        homePage.Enter_User(user);
    }

    @Step
    public void EnterPassword(String password) {
        homePage.Enter_Password(password);
    }

    @Step
    public void LookUpForProducts(String items) {
    	homePage.Search_Items(items);
    }
    
    @Step
    public void ClearSearchTextBox() {
    	homePage.Clear_Search_Textbox();
    }
    
    @Step
    public void AddProductToShoppingCart() {
    	homePage.Add_To_Shopping_Cart();
    }

    @Step
	public void ReviewCart() {
		homePage.Enter_Review_Cart();		
	}

	public boolean ValidateCheckout() {
		return homePage.Validate_Checkout_Exists();
	}
}