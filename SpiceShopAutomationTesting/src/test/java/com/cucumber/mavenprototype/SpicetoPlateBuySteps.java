package com.cucumber.mavenprototype;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SpicetoPlateBuySteps extends SavorySpiceAbstractStepDefinition
{

	@When("^I search for  spice to plate$")
	public void I_type_in_combo_list() throws Throwable
	{
		System.out.println("typing spice to plate  in search box...");
		driver.findElement(By.xpath("//input[@name='SearchPhrase']")).sendKeys("spice to plate");
		driver.findElement(By.xpath("//input[2]")).click();
		Assert.assertTrue(driver.getPageSource().contains("Your results for \"spice to plate\""));
		Assert.assertTrue(driver.getPageSource().contains("Spice to Plate..."));

	}

	@And("^click on spice to plate link$")
	public void scroll_to_the_combo_items() throws Throwable
	{
		System.out.println("clicking spice to plate link...");
		driver.findElement(By.linkText("Spice to Plate")).click();

		// Actions class
		Actions action = new Actions(driver);

		// press page down key
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Assert.assertTrue(driver.getPageSource().contains(
				"Spice to Plate book with custom 4-jar pack"));
		// Thread.sleep(2000);

	}

	@And("^select four items for combopack$")
	public void select_items() throws Throwable
	{
		// select four blends
		System.out.println("selecting four blends...");
		driver.findElement(By.xpath("//input[@id = 'Options[]'][1]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][2]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][3]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][4]")).click();
	}

	@And("^click buy$")
	public void click_buy() throws Throwable
	{

		// click buy
		driver.findElement(By.xpath("//form[2]/div[2]/div/input")).click();

	}

	@Then("^item should be added to cart$")
	public void item_should_be_added_to_cart() throws Throwable
	{
		// verify items added to shopping cart
		Assert.assertTrue(driver.getPageSource().contains("Shopping Cart"));
		Assert.assertTrue(driver.getPageSource().contains(
				"Blend 1: \"Baker's Brew Coffee Spice -4floz Glass\""));
		Assert.assertTrue(driver.getPageSource().contains(
				"Blend 2: \"Barrier Reef Caribbean Seasoning -4floz Glass\""));

		Assert.assertTrue(driver.getPageSource().contains(
				"Blend 3: \"Bohemian Forest European Seasoning -4floz Glass\""));
		Assert.assertTrue(driver.getPageSource().contains(
				"Blend 4: \"Chimayo Chorizo Sausage Spice -4floz Glass\""));

	}

	@Given("^I am on the Spice to Plate book with custom four-jar pack page$")
	public void I_am_on_the_Spice_to_Plate_book_with_custom_four_jar_pack_page() throws Throwable
	{
		driver.get("http://www.savoryspiceshop.com/spice-books/spice-to-plate.html");
	}

	@When("^I choose only three jars$")
	public void I_choose_only_three_jars() throws Throwable
	{
		// select three blends
		System.out.println("selecting three blends...");
		driver.findElement(By.xpath("//input[@id = 'Options[]'][5]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][6]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][1]")).click();

	}

	@Then("^a message should be displayed$")
	public void a_message_should_be_displayed() throws Throwable
	{
		// display alert that only four blends are to be selected
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// driver.quit();
	}

	@When("^I choose five jars$")
	public void I_choose_five_jars() throws Throwable
	{
		// select five blends
		System.out.println("selecting five blends...");
		driver.findElement(By.xpath("//input[@id = 'Options[]'][10]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][9]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][8]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][1]")).click();
		driver.findElement(By.xpath("//input[@id = 'Options[]'][3]")).click();

	}

	// @After
	public void teardown()
	{
		System.out.println("Quitting Web driver from comboitem class...");

	}

}
