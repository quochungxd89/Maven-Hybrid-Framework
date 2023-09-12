package com.nopcommerce.common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Annotation {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Run before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Run after Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Run before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Run after Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Run before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Run after Suite");
	}

}
