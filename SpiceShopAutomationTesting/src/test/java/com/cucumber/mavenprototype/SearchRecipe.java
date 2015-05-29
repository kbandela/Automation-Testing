package com.cucumber.mavenprototype;

import java.util.concurrent.TimeUnit;




import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchRecipe extends
		SavorySpiceAbstractStepDefinition {

	@Given("^User navigate to the recipe page$")
	public void NavigateToRecipePageClickBox() throws Throwable {
		driver.get("http://www.savoryspiceshop.com");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// click recipes tab
		driver.findElement(By.partialLinkText("Recipes")).click();
		Assert.assertTrue(driver.getPageSource().contains("Find a Recipe:"));
	}

	@When("^I enter tuna in keyword field$")
	public void TypeKeywordTuna() throws Throwable
	{
		driver.findElements(By.id("Keyword")).get(1).sendKeys("tuna");
		driver.findElements(By.xpath("//input[@src='/images/searchbutton.png']")).get(1).click();
	}

	@Then("^recepie page should display search results by keyword$")
	public void OpenRecipeWithTuna() throws Throwable {
		Assert.assertTrue(driver.getPageSource().contains("Search Phrase:"));
	}

	@When("^I choose Spanish for region$")
	public void I_choose_spanish_for_region() throws Throwable {
		driver.findElements(By.xpath("//select[@name='Region']/option[2]")).get(1).click();
		driver.findElements(By.xpath("//input[@src='/images/searchbutton.png']")).get(1).click();
	}

	@Then("^recepie page should display search results by region$")
	public void recepie_page_should_display_search_results_by_region() throws Throwable {
		Assert.assertTrue(driver.getPageSource().contains("Region:"));
	}
	
}