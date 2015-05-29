package com.cucumber.mavenprototype;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features =
{ "src/test/resources/" }, tags = "@Test")
public class SavorySpiceShopRunnerTest
{

}
