package com.thebodgeitstore.selenium;

import org.junit.AfterClass; 
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

public class BodgeitTestBase {
    
    static WebDriver driver;
	static String site;
	
	@BeforeClass
	public static void setup(){
        driver = BodgeitSuite.driver;
		site = BodgeitSuite.site;
	}

	static void sleep(int ms) {
		try {Thread.sleep(ms);} catch (InterruptedException e) {}
	}

	static void sleep(){
		sleep(400);
	}

	void checkMenu(String linkText, String page) {
		driver.get(site + page);
		sleep();
		WebElement link = driver.findElement(By.linkText(linkText));
		link.click();
		sleep();

		assertEquals(site + page, driver.getCurrentUrl());
	}
}