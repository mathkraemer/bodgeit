/*
 * The BodgeIt Store and its related class files.
 *
 * The BodgeIt Store is a vulnerable web application suitable for pen testing
 *
 * Copyright 2011 psiinon@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thebodgeitstore.selenium.tests;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass; 
import org.junit.BeforeClass; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;

import static org.junit.Assert.*;  

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Note that this is an example of how to use ZAP with Selenium tests,
 * not a good example of how to write good Selenium tests!
 */
//@RunWith(Suite.class)
//@SuiteClasses({FunctionalTest.class})
public class FunctionalTest {

	private static WebDriver driver;
	private String site = "http://localhost:8888/bodgeit/";

	@BeforeClass public static void BrowserOpen(){ 
		//System.setProperty("webdriver.firefox.driver",  "p:\\Bodgeit\\bodgeit-devsecops\\libruntime\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass public static void BrowserClose(){ 
		driver.quit(); 
	}
	
	@Test
	public void testSimple() {

	}

	@Test
	public void instanceOfTest(){
		assertThat(new ArrayList(), instanceOf(List.class));
	}

	private void sleep() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// Ignore
		}
		
	}

	public void checkMenu(String linkText, String page) {
		sleep();
		WebElement link = driver.findElement(By.linkText(linkText));
		link.click();
		sleep();

		assertEquals(site + page, driver.getCurrentUrl());
	}

	@Test public void checkMenuHome(){
		driver.get(site + "home.jsp");
		checkMenu("Home", "home.jsp");
	}

}

/*
	public void setUp() throws Exception {
		String target = System.getProperty("zap.targetApp");
		if (target != null && target.length() > 0) {
			// Theres an override
			site = target;
		}
		
		this.setDriver(new FirefoxDriver());
	}
	
	private void sleep() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// Ignore
		}
		
	}
	
	public void checkMenu(String linkText, String page) {
		sleep();
		WebElement link = driver.findElement(By.linkText(linkText));
		link.click();
		sleep();

		assertEquals(site + page, driver.getCurrentUrl());
	}
	
	public void checkMenuLinks(String page) {

		driver.get(site + page);
		checkMenu("Home", "home.jsp");

		driver.get(site + page);
		checkMenu("About Us", "about.jsp");
		
		driver.get(site + page);
		checkMenu("Contact Us", "contact.jsp");
		
		driver.get(site + page);
		checkMenu("Login", "login.jsp");
		
		driver.get(site + page);
		checkMenu("Your Basket", "basket.jsp");
		
		driver.get(site + page);
		checkMenu("Search", "search.jsp");
		
	}
	
	public void tstMenuLinks() {
		checkMenuLinks("home.jsp");
		checkMenuLinks("about.jsp");
		checkMenuLinks("contact.jsp");
		checkMenuLinks("login.jsp");
		checkMenuLinks("basket.jsp");
		checkMenuLinks("search.jsp");
	}

	public void registerUser(String user, String password) {
		driver.get(site + "login.jsp");
		checkMenu("Register", "register.jsp");
		
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

	public void loginUser(String user, String password) {
		driver.get(site + "login.jsp");
		
		WebElement link = driver.findElement(By.name("username"));
		link.sendKeys(user);

		link = driver.findElement(By.name("password"));
		link.sendKeys(password);
		
		link = driver.findElement(By.id("submit"));
		link.click();
		sleep();
	}

	public void tstRegisterUser() {
		// Create random username so we can rerun test
		String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
		this.registerUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have successfully registered with The BodgeIt Store.") > 0);
	}
	
	public void tstRegisterAndLoginUser() {
		// Create random username so we can rerun test
		String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
		this.registerUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have successfully registered with The BodgeIt Store.") > 0);
		checkMenu("Logout", "logout.jsp");
		
		this.loginUser(randomUser, "password");
		assertTrue(driver.getPageSource().indexOf("You have logged in successfully:") > 0);
	}
	
	public void tstAddProductsToBasket() {
		driver.get(site + "product.jsp?typeid=1");
		sleep();
		driver.findElement(By.linkText("Basic Widget")).click();
		sleep();
		driver.findElement(By.id("submit")).click();
		sleep();
		
		driver.get(site + "product.jsp?typeid=2");
		sleep();
		driver.findElement(By.linkText("Thingie 2")).click();
		sleep();
		driver.findElement(By.id("submit")).click();
		sleep();
		
		driver.get(site + "product.jsp?typeid=3");
		sleep();
		driver.findElement(By.linkText("TGJ CCC")).click();
		sleep();
		driver.findElement(By.id("submit")).click();
		sleep();
	}

	public void tstSearch() {
		driver.get(site + "search.jsp?q=doo");
		sleep();
		
		// TODO check the results!
		//driver.findElement(By.name("q")).sendKeys("doo");
		
	}

	public void testAll() {
		tstMenuLinks();
		tstRegisterUser();
		tstRegisterAndLoginUser();
		tstAddProductsToBasket();
		tstSearch();
		
	}

	public void tearDown() throws Exception {
		driver.close();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	protected String getSite() {
		return site;
	}

	protected void setSite(String site) {
		this.site = site;
	}
	
	public static void main(String[] args) throws Exception {
		FunctionalTest test = new FunctionalTest();
		test.setUp();
		test.testAll();
		test.tearDown();
		
	}

}
*/