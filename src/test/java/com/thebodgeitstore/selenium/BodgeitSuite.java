package com.thebodgeitstore.selenium;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.AfterClass; 
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({MenuTests.class, SearchTests.class, RegisterLoginTests.class, BasketTests.class})
public class BodgeitSuite {

    public static WebDriver driver;
	public static String site = "http://localhost:8888/bodgeit/";

	@BeforeClass public static void BrowserOpen(){ 
        //System.setProperty("webdriver.firefox.driver",  "p:\\path\\to\\runtime\\geckodriver.exe");
        System.out.println(new Timestamp(new Date().getTime()) + " Loading Driver...");
        driver= new FirefoxDriver();
        System.out.println(new Timestamp(new Date().getTime()) + " Instantiated...");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(new Timestamp(new Date().getTime()) + " Timeouts set...");
        driver.get(site);
        System.out.println(new Timestamp(new Date().getTime()) + " Webapp loaded...");
        try {Thread.sleep(12000);} catch (InterruptedException e) {}
    }

	@AfterClass public static void BrowserClose(){
        System.out.println(new Timestamp(new Date().getTime()) + " Closing down drviver ..."); 
        driver.quit();
        System.out.println(new Timestamp(new Date().getTime()) + " Released driver ...");
	}
}