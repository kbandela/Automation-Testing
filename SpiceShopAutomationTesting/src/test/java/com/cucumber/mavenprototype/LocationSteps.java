package com.cucumber.mavenprototype;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocationSteps extends SavorySpiceAbstractStepDefinition
{

	@Given("^when I am on location page$")
	public void I_am_on_location_page() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.savoryspiceshop.com");

		// click locations tab
		System.out.println("Clicking location tab...");
		driver.findElement(By.xpath("//div[@class='nav']/ul/li[4]/a")).click();
		Assert.assertTrue(driver.getPageSource().contains("Savory Spice Shop Locations"));

	}

	// List<WebElement> purchasedItems = driver.findElements(By
	// .xpath("//tr[td[2] and @class = 'item']"));

	@When("^I click on the image of Illinois map$")
	public void I_click_on_image() throws Throwable
	{
		System.out.println("clicking on Illinois map...");

		// click on Illinois map
		driver.findElement(By.xpath("//area[5]")).click();
	}

	@And("^Click on the Chicago Lincoln Square link$")
	public void Click_on_the_Chicago_Lincoln_Square_link() throws Throwable
	{

		// click chicago lincoln square
		System.out.println("Clicking on Chicago Lincoln street link...");
		driver.findElement(By.linkText("Chicago - Lincoln Square")).click();
	}

	@Then("^Chicago Lincoln Square store details should be displayed$")
	public void Chicago_Lincoln_Square_store_details_should_be_displayed() throws Throwable
	{

		Thread.sleep(2000);
		// verify address
		Assert.assertTrue(driver.getPageSource().contains("Lincoln Square"));
		Assert.assertTrue(driver.getPageSource().contains("4753 North Lincoln"));
		Assert.assertTrue(driver.getPageSource().contains("Chicago, Illinois 60625"));

		// driver.quit();
	}

}
