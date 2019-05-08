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

public class BasketTests extends BodgeitTestBase {

	void tstAddProductsToBasket(String typeid, String article) {
		driver.get(site + "product.jsp?typeid=" + typeid);
		sleep();
		driver.findElement(By.linkText(article)).click();
		sleep();
		driver.findElement(By.id("submit")).click();
		sleep();
	}
	
	@Test
	public void tstBasketAdd1() {
		tstAddProductsToBasket("1", "Basic Widget");
	}

	@Test
	public void tstBasketAdd2() {
		tstAddProductsToBasket("2", "Thingie 2");
	}

	@Test
	public void tstBasketAdd3() {
		tstAddProductsToBasket("3", "TGJ CCC");
	}
}
