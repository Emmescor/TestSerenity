package com.accenture.testBuyingProducts.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import java.util.List;

@DefaultUrl("http://tutorialsninja.com/demo/index.php")
public class HomePage extends PageObject {

	@FindBy(xpath = "//*[@title=\"My Account\"]")
	private WebElementFacade accountButton;

	@FindBy(xpath = "//li/a[contains(text(),'Login')]")
	private WebElementFacade selectLogin;

	@FindBy(id = "input-email")
	private WebElementFacade inputUser;

	@FindBy(id = "input-password")
	private WebElementFacade inputPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElementFacade loginButton;

	@FindBy(xpath = "//*[@id='search']/input")
	private WebElementFacade textSearch;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")
	private WebElementFacade addCartButton;

	@FindBy(xpath = "//*[@id='cart']/button")
	private WebElementFacade cartButton;
	
	@FindBy(xpath = "//*[text()=' View Cart']")
	private WebElementFacade viewCartButton;
	
	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElementFacade checkoutButton;
	
	public void EnterLoginMenu() {
		// Enter into the login menu
		accountButton.click();
		selectLogin.click();
	}

	public void Enter_User(String user) {
		// Enter user email
		inputUser.type(user);
	}

	public void Enter_Password(String password) {
		// Enter user password
		inputPassword.typeAndEnter(password);
	}

	public void Search_Items(String items) {
		// Search items within the search bar
		textSearch.typeAndEnter(items);
	}
	
	public void Clear_Search_Textbox() {
		textSearch.clear();
	}

	public void Add_To_Shopping_Cart() {
		// Add item to the shopping cart
		addCartButton.click();
	}
	
	public void Enter_Review_Cart() {
		// Add item to the shopping cart
		cartButton.click();
		viewCartButton.click();
	}

	public boolean Validate_Checkout_Exists() {
		// Validates if Checkout button exists
		return checkoutButton.isDisplayed();
	}

}