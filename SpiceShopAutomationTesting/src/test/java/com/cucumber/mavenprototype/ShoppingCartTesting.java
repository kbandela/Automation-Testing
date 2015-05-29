package com.cucumber.mavenprototype;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartTesting extends SavorySpiceAbstractStepDefinition{

	private String firstItemPrice;
	private String secondItemPrice;
	
	@Given("^user on the homepage$")
	public void user_on_the_homepage(){
		driver.get("http://www.savoryspiceshop.com/");
	}
	
	@When("^I choose Herbs & Spices item$")
	public void I_choose_Herbs_Spices_item() throws Throwable {
		// click on start shopping
		driver.findElement(By.partialLinkText("Start Shopping")).click();
		// Make sure on right page
		Assert.assertTrue(driver.getPageSource().contains(
				"Shop at Savory Spice Shop"));

		String[] spicesName = { "Herbs & Spices", "Baking Spices",
				"Allspice Berries, Jamaican" };

		for (String spiceName : spicesName) {
			// click on herbs and spices
			driver.findElement(By.linkText(spiceName)).click();
			// Make sure on right page
			Assert.assertTrue(driver.findElement(By.xpath("//h2")).getText()
					.contains(spiceName));
		}

		String tableRegex = "//div[@class='purchaseInGroup']/table/tbody/tr[1]/";
		firstItemPrice = driver.findElement(By.xpath(tableRegex + "td[3]")).getText();
		// click on buy
		driver.findElement(By.xpath(tableRegex + "td[4]/input[1]")).click();

	}

	@Then("^I should find one item in my cart$")
	public void I_should_find_one_item_in_my_cart() throws Throwable {
		String text = driver.findElement(By
				.xpath("//table[@id='viewcartTable']/tbody[1]/tr[2]/td[2]")).getText();
		Assert.assertTrue(text.contains("$"));
	}

	@Then("^I should find two items in my cart$")
	public void I_should_find_two_item_in_my_cart() throws Throwable {
		String text = driver.findElement(By.xpath("//table[@id='viewcartTable']/tbody[1]/tr[3]/td[2]")).getText();
		Assert.assertTrue(text.contains("$"));
	}

	@Then("^the cart page display the first item price$")
	public void the_cart_page_display_the_first_item_price() throws Throwable {
		String price = driver.findElement(By
				.xpath("//table[@id='viewcartTable']/tbody[1]/tr[2]/td[2]")).getText();
		Assert.assertTrue(price.equals(firstItemPrice));
	}

	@Then("^the cart page display the second item price$")
	public void the_cart_page_display_the_second_item_price() throws Throwable {
		String price = driver.findElement(By.xpath("//table[@id='viewcartTable']/tbody[1]/tr[3]/td[2]")).getText();
		Assert.assertTrue(price.equals(secondItemPrice));
	}

	@Given("^the cart has at least one item$")
	public void the_cart_has_at_least_one_item() throws Throwable {
		driver.findElement(By.partialLinkText("View Cart")).click();
		I_choose_Herbs_Spices_item();
	}

	@When("^I view the cart$")
	public void I_view_the_cart() throws Throwable {
		driver.findElement(By.partialLinkText("View Cart"));
		Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().contains("Shopping Cart"));
	}

	@When("^I change the quanity and click update$")
	public void I_change_the_quanity_and_click_update() throws Throwable {
		driver.findElement(By.id("Quantity_cart_0")).sendKeys("2");
		// read price before update quantity
		firstItemPrice = driver.findElement(By
				.xpath("//table[@id='viewcartTable']/tbody[1]/tr[2]/td[4]")).getText();
		driver.findElement(By.linkText("UPDATE")).click();
	}

	@Then("^the total price should be changed$")
	public void the_total_price_should_be_changed() throws Throwable {
		String newTotalPrice = driver.findElement(By
				.xpath("//table[@id='viewcartTable']/tbody[1]/tr[2]/td[4]")).getText();
		Assert.assertFalse(firstItemPrice.equals(newTotalPrice));
	}

	@When("^I choose to delete item$")
	public void I_choose_to_delete_item() throws Throwable {
		driver.findElement(By.linkText("REMOVE")).click();
	}

	@Then("^the item deleted$")
	public void the_item_deleted() throws Throwable {
		String text = driver.findElement(By.xpath("//table[@id='viewcartTable']/tbody[1]/tr[2]")).getText();
		Assert.assertTrue(text.contains("$0.00"));
	}

	@When("^I choose Spice Blends items$")
	public void I_choose_Spice_Blends_items() throws Throwable {
		// click on start shopping
		driver.findElement(By.partialLinkText("Start Shopping")).click();
		// Make sure on right page
		Assert.assertTrue(driver.getPageSource().contains(
				"Shop at Savory Spice Shop"));

		String[] spicesName = { "Spice Blends", "All Purpose",
				"Cantanzaro Herbs (Salt-Free)" };

		for (String spiceName : spicesName) {
			// click on herbs and spices
			driver.findElement(By.linkText(spiceName)).click();
			// Make sure on right page
			Assert.assertTrue(driver.findElement(By.xpath("//h2")).getText()
					.contains(spiceName));
		}

		String tableRegex = "//div[@class='purchaseInGroup']/table/tbody/tr[2]/";
		secondItemPrice = driver.findElement(By.xpath(tableRegex + "td[3]")).getText();
		driver.findElement(By.xpath(tableRegex + "td[4]/input[1]")).click();
	}

	
	
}
