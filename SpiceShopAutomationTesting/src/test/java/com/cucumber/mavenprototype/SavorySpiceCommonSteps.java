package com.cucumber.mavenprototype;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class SavorySpiceCommonSteps extends SavorySpiceAbstractStepDefinition
{

	// executed before each test scenario is run
	@Before
	public void setup()
	{
		System.out.println("initializing  Web driver in commonsteps class...");
		driver = new FirefoxDriver();

	}

	// This method is used by many scenarios and feature files
	@Given("^I am on the home page$")
	public void when_I_am_on_the_home_page() throws Throwable
	{
		// Open the home page
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.savoryspiceshop.com");
		Thread.sleep(2000);
	}

	// executed after each test scenario is run
	@After
	public void teardown()
	{
		System.out.println("Quitting Web driver from common steps class...");
//		driver.quit();
	}

}
