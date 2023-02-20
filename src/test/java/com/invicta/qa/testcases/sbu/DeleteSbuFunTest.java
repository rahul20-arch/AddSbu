package com.invicta.qa.testcases.sbu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.DeleteSbuFunPage;
import com.invicta.qa.pages.sbu.DeleteSbuUIPage;



public class DeleteSbuFunTest extends DriverIntialization {
	
	DeleteSbuFunPage deletefunpg = new DeleteSbuFunPage();
	@BeforeSuite
	public  void  login() throws InterruptedException,IOException {
		
		PageFactory.initElements(driver, deletefunpg);
		
		driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tokyo@admin");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div")).click();
		
		
		
		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")).click();
		Thread.sleep(4000);
		
		//delete button click
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[2]")).click();
	Thread.sleep(2000);
	
	
	//first row text
	String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")).getText();
	System.out.println(text);
	
//	//delete Ok button
//	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]")).click();
//	
//	//delete cancel button
//	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]")).click();
	
	Thread.sleep(3000);
	boolean AcctualElement = driver.findElement(By.xpath("/html/body/div[2]/div/div")).isDisplayed();;
	// /html/body/div[2]/div/div/div/div[2]/div/div[1]
	// /html/body/div[2]/div/div
	boolean ExpectedElement = true;
	//AssertJUnit.assertEquals(AcctualElement, ExpectedElement);

	boolean elementvisible = true;
	testCase = extent.createTest("ELEMENT-VISIBLE");
	try {
		AssertJUnit.assertEquals(AcctualElement, ExpectedElement);
	} catch (AssertionError e) {
		elementvisible = false;
	}
	if (elementvisible) {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualElement);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
		testCase.log(Status.INFO, "Element Available");
		testCase.log(Status.PASS, "Correct element");
	} else {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualElement);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
		testCase.log(Status.INFO, "Element not available");
		testCase.log(Status.FAIL, "No Element");
	}
	
		
//		String text = DeleteSbuFunPage.Text.getText();
//		System.out.println(text);
//		Thread.sleep(3000);
//		DeleteSbuFunPage.DeleteButton.click();
//		Thread.sleep(3000);
	
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public static void ClickDeleteOnSBU() throws InterruptedException,IOException {
		
		
//		for (int i = 2; i < 20; i++) {
//	        String text = driver.findElement(By.xpath("//tbody/tr[" + i +   "]")).getText();
//		
//	        System.out.println("text " + text);
//	        
//	  
//			if (text.equals("RMC")) {
//	       
//	            driver.findElement(By.xpath("//tbody/tr[" + i + "]//a[@href='#']")).click();    
//	            Thread.sleep(2000);
//	        }
//	}
//	    driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
//	    
		
		
		
		
		
		
		
		
		
		
		
		}
}
