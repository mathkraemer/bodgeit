package com.thebodgeitstore.selenium;

import org.junit.AfterClass; 
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;

public class BodgeitTest {
    
    static WebDriver driver;
	static String site;
	
	@BeforeClass
	public static void setup(){
        driver = BodgeitSuite.driver;
        site = BodgeitSuite.site;
	}

	void sleep(int ms) {
		try {Thread.sleep(ms);} catch (InterruptedException e) {}
	}

	void sleep(){
		sleep(300);
	}
}