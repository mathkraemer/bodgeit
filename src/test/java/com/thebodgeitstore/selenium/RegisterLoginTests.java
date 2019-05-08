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

public class RegisterLoginTests extends BodgeitTestBase {

	private void registerUser(String user, String password) {
		driver.get(site + "register.jsp");
		
		WebElement link = driver.findElement(By.name("username"));
		link.sendKeys(user);

		link = driver.findElement(By.name("password1"));
		link.sendKeys(password);
		
		link = driver.findElement(By.name("password2"));
		link.sendKeys(password);
		
		link = driver.findElement(By.id("submit"));
		link.click();
		sleep();
		
	}

	private void loginUser(String user, String password) {
		driver.get(site + "login.jsp");
		
		WebElement link = driver.findElement(By.name("username"));
		link.sendKeys(user);

		link = driver.findElement(By.name("password"));
		link.sendKeys(password);
		
		link = driver.findElement(By.id("submit"));
		link.click();
		sleep();
	}
	
	@Test
	public void tstRegisterUser() {
		// Create random username so we can rerun test
		String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
		System.out.println("Registering user: " + randomUser);
		this.registerUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have successfully registered with The BodgeIt Store.") > 0);
	}
	
	@Test
	public void tstRegisterAndLoginUser() {
		// Create random username so we can rerun test
		String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
		registerUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have successfully registered with The BodgeIt Store.") > 0);
		
		//checkMenu("Login", "logout.jsp"); // logout and check for Login link on page.
		driver.get(site + "logout.jsp");
		sleep();
		WebElement link = driver.findElement(By.linkText("Login"));
		link.click();
		sleep();
		
		loginUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have logged in successfully:") > 0);
	}

}
