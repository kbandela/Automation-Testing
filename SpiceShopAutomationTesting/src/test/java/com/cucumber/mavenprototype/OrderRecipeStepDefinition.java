package com.cucumber.mavenprototype;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderRecipeStepDefinition extends
		SavorySpiceAbstractStepDefinition {

	@When("^I choose recipe$")
	public void I_choose_recipe() throws Throwable {
		driver.findElement(By.partialLinkText("Recipes")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2")).getText().contains("Recipes"));
		driver.findElement(By.linkText("Appetizer")).click();
		Assert.assertTrue(driver.getPageSource().contains("Appetizer"));
		
		// Recipe web element
		WebElement recipeItem = driver.findElements(By.xpath("//div[@class='searchResultsRow']")).get(0);
		String recipeTitle = recipeItem.getText();
		System.out.println(recipeTitle);
		driver.findElement(By.linkText(recipeTitle.substring(0, recipeTitle.length()-9))).click();
		Assert.assertTrue(recipeTitle.split(" ")[0].equals(driver.getTitle().split(" ")[0]));
	}

	@Then("^I should be able to order ingredients for that recipe$")
	public void I_should_be_able_to_order_ingredients_for_that_recipe() throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@src='/images/recipes/buychecked1.png']")) != null);
	}

	
}