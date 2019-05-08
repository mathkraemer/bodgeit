package com.thebodgeitstore.selenium;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;
import org.junit.BeforeClass;

import static org.junit.Assert.*;  

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * Note that this is an example of how to use ZAP with Selenium tests,
 * not a good example of how to write good Selenium tests!
 */

public class SearchTests extends BodgeitTestBase {

	@Test
	public void testSearch() {
		driver.get(site + "search.jsp?q=doo");
		sleep();
		// TODO check the results!
		//driver.findElement(By.name("q")).sendKeys("doo");
		
	}

}
