package com.cucumber.mavenprototype;

import org.openqa.selenium.WebDriver;

public class SavorySpiceAbstractStepDefinition
{

	static WebDriver driver;
	String ename = "john";

	public WebDriver getDriver()
	{

		// if (driver == null)
		// {
		//
		// driver = new FirefoxDriver();
		//
		// }

		return driver;

	}

}
