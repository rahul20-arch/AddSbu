package com.invicta.qa.testcases.sbu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.login.Loginpg;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.testcases.login.LoginTest;

public class MethodCalling extends DriverIntialization{
@Test
	public static void FirstTestCase() throws InterruptedException, IOException {
		//For login
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("admin");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tokyo@admin");
//		driver.findElement(
//				By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button"))
//				.click();
//		Thread.sleep(4000);
////		LoginTest.Login();
////		Thread.sleep(2000);
////		AddSbuFunPage.master.click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")).click();
//				
//				
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")).click();
//		
		
		//Login method
		Loginpg.login();
	
//		AddSbuFunPage.SBU.click();
		// 1.Add Sbu button UI
		AddSbuUITest.addsbubutton();
		Thread.sleep(3000);
		// 2.Click the Sbu button fun
		AddSbuUITest.addsbuclick();
		Thread.sleep(3000);
		// 3.Modal UI
		AddSbuUITest.addsbumodal();
		Thread.sleep(3000);
		// 4.text box UI
		AddSbuUITest.sbutextbox();
		Thread.sleep(3000);
		// 5.Description box UI
		AddSbuUITest.descriptiontextbox();
		Thread.sleep(3000);
		// 6.Add data
		AddSbuUITest.sbudata();
		Thread.sleep(3000);
		// 7.Sbu text
		AddSbuUITest.addsbutext();
		Thread.sleep(3000);
		// 8.Description Text
		AddSbuUITest.description();
		Thread.sleep(3000);
		// 9.Save button UI
		AddSbuUITest.SaveButtonUI();
		Thread.sleep(3000);
		// 10.Save Button Fun
		AddSbuUITest.clicksave();
	}

}
