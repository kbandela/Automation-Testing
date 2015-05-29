package com.cucumber.mavenprototype;

import org.openqa.selenium.By;

import cucumber.api.java.en.When;

public class LoginSteps  extends SavorySpiceAbstractStepDefinition{

	@When("^I login to the system$")
	public void I_login_to_the_system() throws Throwable {
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("fakhri");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("fakhri");
		driver.findElement(By.xpath("//input[@src='/images/login.png']")).click();
	}

	@When("^I logout from the system$")
	public void I_logout_from_the_system() throws Throwable {
		driver.findElement(By.partialLinkText("Logout")).click();
	}
}
