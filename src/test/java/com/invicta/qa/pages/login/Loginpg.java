package com.invicta.qa.pages.login;

import org.openqa.selenium.By;

import com.invicta.qa.base.DriverIntialization;

public class Loginpg extends DriverIntialization {

	public static void login() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tokyo@admin");
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button"))
				.click();
		Thread.sleep(4000);
//		LoginTest.Login();
//		Thread.sleep(2000);
//		AddSbuFunPage.master.click();
		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")).click();
				
				
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")).click();
		
	}
}
