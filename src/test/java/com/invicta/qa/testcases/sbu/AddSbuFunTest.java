package com.invicta.qa.testcases.sbu;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuFunPage;

public class AddSbuFunTest extends DriverIntialization {
  
	// METHOD-2 -- ADD-SBU BUTTON CLICK METHOD(FUNCTIONAL)
	public static void addsbuclick() throws InterruptedException {
		 AddSbuFunPage AddFunPg = new AddSbuFunPage();
		 Thread.sleep(3000);
		AddSbuFunPage.SBUbutton.click();
		boolean ActualTextDisplay = AddSbuFunPage.addsbumodel.isDisplayed();
		boolean ExpectedTestDisplay = true;
		testCase = extent.createTest("ADD-SBU CLICK");
		try {
			Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
			testCase.log(Status.INFO, "ACTUAL ADD SBU IS CLICKED :- " + ActualTextDisplay);
			testCase.log(Status.INFO, "EXPECTED ADD SBU IS CLICKED :- " + ExpectedTestDisplay);
			testCase.log(Status.PASS, " ADD-SBU IS CLICKED");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ACTUAL ADD SBU IS CLICKED:- " + ActualTextDisplay);
			testCase.log(Status.INFO, "EXPECTED ADD SBU IS CLICKED :- " + ExpectedTestDisplay);
			testCase.log(Status.FAIL, " ADD-SBU IS NOT CLICKED ");
		}
	}

	// STEP-6 -- THIS METHOD IS FOR ADD DATA
	public static void sbudata() throws IOException, InterruptedException {
		AddSbuFunPage AddSbuFunpg = new AddSbuFunPage();
		PageFactory.initElements(driver, AddSbuFunpg);

		FileInputStream file = new FileInputStream(System.getProperty(
				"C:\\Users\\hp\\eclipse-workspace\\QDMS-AUTOMATION\\src\\test\\java\\com\\invicta\\qa\\excel\\Data.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("ADDSBU");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {

			XSSFRow row = sheet.getRow(i);

			String sbu = (String) row.getCell(0).getStringCellValue();
			String description = (String) row.getCell(1).getStringCellValue();

			Thread.sleep(2000);
			AddSbuFunPage.SBUtext.sendKeys(sbu);
			AddSbuFunPage.SBUdestext.sendKeys(description);

			AddSbuFunPage.SBUsavebutton.click();

		}

	}

	// STEP-10 --THIS METHOD IS FOR SAVE BUTTON FUNCTION

	public static void clicksave() throws InterruptedException {
		AddSbuFunPage AddSbuFunpg = new AddSbuFunPage();
		PageFactory.initElements(driver, AddSbuFunpg);

		Thread.sleep(2000);
		AddSbuFunPage.SBUsavebutton.click();
	}


}
