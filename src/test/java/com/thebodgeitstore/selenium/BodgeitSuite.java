package com.thebodgeitstore.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.AfterClass; 
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({MenuTests.class})
public class BodgeitSuite {

    public static WebDriver driver;
	public static String site = "http://localhost:8888/bodgeit/";

	@BeforeClass public static void BrowserOpen(){ 
        //System.setProperty("webdriver.firefox.driver",  "p:\\path\\to\\runtime\\geckodriver.exe");
        System.out.println("Loading Driver...");
		driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Done...");
    }

	@AfterClass public static void BrowserClose(){ 
		driver.quit(); 
	}
}