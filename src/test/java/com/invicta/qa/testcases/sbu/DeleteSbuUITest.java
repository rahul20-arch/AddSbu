package com.invicta.qa.testcases.sbu;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.DeleteSbuUIPage;







public class DeleteSbuUITest extends DriverIntialization {

	
	DeleteSbuUIPage deletesbu = new DeleteSbuUIPage();

	@Test(priority = 0)
	public void deletesbu() throws InterruptedException {
		PageFactory.initElements(driver, deletesbu);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tokyo@admin");
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button"))
				.click();
		Thread.sleep(4000);
//		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div")).click();
//		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")).click();
		Thread.sleep(4000);
		DeleteSbuUIPage.master.click();
		Thread.sleep(3000);
		DeleteSbuUIPage.SBU.click();
		Thread.sleep(3000);
//		DeleteSbuUIPage.deleteicon.click();
//		Thread.sleep(3000);
		// for delete icon
//**************************** 1.visible**********************************
		try {
		boolean AcctualElement = DeleteSbuUIPage.deleteicon.isDisplayed();
		boolean ExpectedElement = true;

		boolean elementvisible = true;
		testCase = extent.createTest("1.ELEMENT-VISIBLE");
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
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

//******************************* 2.Enabled******************************
		try {
		boolean Acctualenabled = DeleteSbuUIPage.deleteicon.isEnabled();
		boolean Expectedenabled = true;

		boolean enabled = true;
		testCase = extent.createTest("2.ELEMENT-ENABLED");
		try {
			AssertJUnit.assertEquals(Acctualenabled, Expectedenabled);
		} catch (AssertionError e) {
			enabled = false;
		}
		if (enabled) {
			testCase.log(Status.INFO, "ActualElement :- " + Acctualenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + Expectedenabled);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + Acctualenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + Expectedenabled);
			testCase.log(Status.INFO, "Element not enabled");
			testCase.log(Status.FAIL, "wrong");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

		
//*****************************************************************************************************************


		// click the delete icon
		DeleteSbuUIPage.deleteicon.click();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void deleteOKsbu() throws InterruptedException, IOException {
		// ************************1.ok Button visible************************

		boolean ExpectedOKVisible=true;
		
		boolean ActualOKVisible=DeleteSbuUIPage.OkButton.isDisplayed();
		testCase = extent.createTest("3-OK-BUTTON-VISIBLE");
		try {
			Assert.assertEquals(ActualOKVisible, ExpectedOKVisible);
			testCase.log(Status.INFO, "Actual OK Button Visible :- " + ActualOKVisible);
			testCase.log(Status.INFO, "Expected OK Visible :- " + ExpectedOKVisible);
			testCase.log(Status.PASS, "OK Visible is Correct");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual OK Button Visible :- " + ActualOKVisible);
			testCase.log(Status.INFO, "Expected OK Visible :- " + ExpectedOKVisible);
			testCase.log(Status.FAIL, "OK Visible is Wrong");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}

//***************************2.Enabled*************************************		
if(ActualOKVisible) {
		boolean Acctualokenabled = DeleteSbuUIPage.OkButton.isEnabled();
		boolean Expectedokenabled = true;

		boolean okenabled = true;
		testCase = extent.createTest("4.ELEMENT-OK-ENABLED");
		try {
			AssertJUnit.assertEquals(Acctualokenabled, Expectedokenabled);
		} catch (AssertionError e) {
			okenabled = false;
		}
		if (okenabled) {
			testCase.log(Status.INFO, "ActualElement :- " + Acctualokenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + Expectedokenabled);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + Acctualokenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + Expectedokenabled);
			testCase.log(Status.INFO, "Element not enabled");
			testCase.log(Status.FAIL, "wrong");
		}
		Thread.sleep(2000);

//*****************************3.Check OK position**********************
		Point actual = DeleteSbuUIPage.OkButton.getLocation();

		int x = actual.getX();
		int y = actual.getY();
		
		System.out.println("x-axis = " + x);
		System.out.println("y-axis = " + y);
		
	
		Point expectedresult = new Point(770, 128);
		testCase = extent.createTest("5.OK-POSTION");
		boolean position = true;
		
		try {
			AssertJUnit.assertEquals(actual, expectedresult);
		} catch (AssertionError e) {
			position = false;
		}
			if (position) {
				testCase.log(Status.INFO, "ActualElement :- " + actual);
				testCase.log(Status.INFO, "ExpectedElement :- " + expectedresult);
				testCase.log(Status.INFO, "correct postion");
				testCase.log(Status.PASS, "Correct ");
			} else {
				testCase.log(Status.INFO, "ActualElement :- " + actual);
				testCase.log(Status.INFO, "ExpectedElement :- " + expectedresult);
				testCase.log(Status.INFO, "wrong postion");
				testCase.log(Status.FAIL, "wrong");
			}
			Thread.sleep(2000);

//****************************4. Check the OK size******************************

		Dimension ActualOKSize = DeleteSbuUIPage.OkButton.getSize();
		System.out.println("Size :" + ActualOKSize);
		Dimension ExpectedOKSize = new Dimension(18, 22);

		boolean OKsize = true;
		testCase = extent.createTest("6.BUTTON-OK-SIZE");
		try {
			AssertJUnit.assertEquals(ActualOKSize, ExpectedOKSize);
		} catch (AssertionError e) {
			OKsize = false;
		}
		if (OKsize) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualOKSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedOKSize);
			testCase.log(Status.INFO, "Correct Size");
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualOKSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedOKSize);
			testCase.log(Status.INFO, "wrong Size");
			testCase.log(Status.FAIL, "wrong Size");
		}
		Thread.sleep(2000);
//******************************* 5.Check test button color*************************

		String ActualOKColour = DeleteSbuUIPage.OkButton.getCssValue("background-color");
		System.out.println("rgb :" + ActualOKColour);

		// String hexcolour = Color.fromString(ActualColour).asHex();
		String ExpectedOKColour = "rgba(0, 0, 0, 0)";

		boolean OKcolour = true;

		testCase = extent.createTest("7.BACK-GROUND OK COLOR");
		try {
			AssertJUnit.assertEquals(ActualOKColour, ExpectedOKColour);
		} catch (AssertionError e) {
			OKcolour = false;
		}
		if (OKcolour) {
			testCase.log(Status.INFO, "ActualColour :- " + ActualOKColour);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedOKColour);
			testCase.log(Status.INFO, "Correct Colour");
			testCase.log(Status.PASS, "Correct Colour");
		} else {
			testCase.log(Status.INFO, "ActualColour :- " + ActualOKColour);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedOKColour);
			testCase.log(Status.INFO, "wrong Colour");
			testCase.log(Status.FAIL, "wrong Colour");
		}
		Thread.sleep(2000);

// ***********************************6. check font color*****************************

		String ActualOKfontColor = DeleteSbuUIPage.OkButton.getCssValue("color");
		System.out.println("Color of button: " + ActualOKfontColor);
		String ExpectedOKfontColor = "rgba(255, 255, 255, 1)";
		
		boolean OKfontColour = true;

		testCase = extent.createTest("8.OK-BUTTON-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualOKfontColor, ExpectedOKfontColor);
		} catch (AssertionError e) {
			OKfontColour = false;
		}
		if (OKfontColour) {
			testCase.log(Status.INFO, "ActualColour :- " + ActualOKfontColor);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedOKfontColor);
			testCase.log(Status.INFO, "Correct  Colour");
			testCase.log(Status.PASS, "Correct  Colour");
		} else {
			testCase.log(Status.INFO, "ActualColour :- " + ActualOKfontColor);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedOKfontColor);
			testCase.log(Status.INFO, "wrong Colour");
			testCase.log(Status.FAIL, "wrong Colour");
		}
		Thread.sleep(2000);
//****************************** 7. check cursor************************************

		String ActualOKcursor = DeleteSbuUIPage.OkButton.getCssValue("cursor");
		System.out.println("Cursor: " + ActualOKcursor);
		String ExpectedOKcursor = "pointer";

		boolean OKcursor = true;

		testCase = extent.createTest("9.OK-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualOKcursor, ExpectedOKcursor);
		} catch (AssertionError e) {
			OKcursor = false;
		}
		if (OKcursor) {
			testCase.log(Status.INFO, "ActualCursor :- " + ActualOKcursor);
			testCase.log(Status.INFO, "ExpectedCursor :- " + ExpectedOKcursor);
			testCase.log(Status.INFO, "Correct Cursor");
			testCase.log(Status.PASS, "Correct Cursor");
		} else {
			testCase.log(Status.INFO, "ActualCursor :- " + ActualOKcursor);
			testCase.log(Status.INFO, "ExpectedCursor :- " + ExpectedOKcursor);
			testCase.log(Status.INFO, "wrong Cursor");
			testCase.log(Status.FAIL, "wrong Cursor");
		}
		Thread.sleep(2000);
//*************************** 8.text-align************************************
		String ActualOKtextalign = DeleteSbuUIPage.OkButton.getCssValue("text-align");
		System.out.println("text align: " + ActualOKtextalign);
		String ExpectedOKtextalign = "center";

		boolean OKtextalign = true;

		testCase = extent.createTest("10.OK-text-align");
		try {
			AssertJUnit.assertEquals(ActualOKtextalign, ExpectedOKtextalign);
		} catch (AssertionError e) {
			OKtextalign = false;
		}
		if (OKtextalign) {
			testCase.log(Status.INFO, "Actualtextalign :- " + ActualOKtextalign);
			testCase.log(Status.INFO, "Expectedtextalign :- " + ExpectedOKtextalign);
			testCase.log(Status.INFO, "Correct textalign");
			testCase.log(Status.PASS, "Correct textalign");
		} else {
			testCase.log(Status.INFO, "Actualtextalign :- " + ActualOKtextalign);
			testCase.log(Status.INFO, "Expectedtextalign :- " + ExpectedOKtextalign);
			testCase.log(Status.INFO, "wrong textalign");
			testCase.log(Status.FAIL, "wrong textalign");
		}
		Thread.sleep(2000);
		//9. vertical-align
		String ActualOKverticalalign = DeleteSbuUIPage.OkButton.getCssValue("vertical-align");
		System.out.println("vertical align: " + ActualOKverticalalign);
		String ExpectedOKverticalalign = "baseline";

		boolean OKverticalalign = true;

		testCase = extent.createTest("11.OK-VERTICAL-ALIGN");
		try {
			AssertJUnit.assertEquals(ActualOKverticalalign, ExpectedOKverticalalign);
		} catch (AssertionError e) {
			OKverticalalign = false;
		}
		if (OKverticalalign) {
			testCase.log(Status.INFO, "Actualverticalalign :- " + ActualOKverticalalign);
			testCase.log(Status.INFO, "Expectedverticalalign :- " + ExpectedOKverticalalign);
			testCase.log(Status.INFO, "Correct verticalalign");
			testCase.log(Status.PASS, "Correct textalign");
		} else {
			testCase.log(Status.INFO, "Actualverticalalign :- " + ActualOKverticalalign);
			testCase.log(Status.INFO, "Expectedverticalalign :- " + ExpectedOKverticalalign);
			testCase.log(Status.INFO, "wrong verticalalign");
			testCase.log(Status.FAIL, "wrong verticalalign");
		}
		Thread.sleep(2000);

//******************************* 10.border color*************************************
		String ActualOKbordercolor = DeleteSbuUIPage.OkButton.getCssValue("border-color");
		System.out.println("border color " + ActualOKbordercolor);
		String ExpectedOKbordercolor = "rgb(24, 144, 255)";

		boolean OKbordercolor = true;

		testCase = extent.createTest("12.OK-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualOKbordercolor, ExpectedOKbordercolor);
		} catch (AssertionError e) {
			OKbordercolor = false;
		}
		if (OKbordercolor) {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualOKbordercolor);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedOKbordercolor);
			testCase.log(Status.INFO, "Correct bordercolor");
			testCase.log(Status.PASS, "Correct bordercolor");
		} else {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualOKbordercolor);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedOKbordercolor);
			testCase.log(Status.INFO, "wrong bordercolor");
			testCase.log(Status.FAIL, "wrong bordercolor");
		}
		Thread.sleep(2000);
//*********************************** 10.box shadow*************************************
		String ActualOKboxshadow = DeleteSbuUIPage.OkButton.getCssValue("box-shadow");
		System.out.println("box-shadow " + ActualOKboxshadow);
		String ExpectedOKboxshadow = "rgba(0, 0, 0, 0.043) 0px 2px 0px 0px";

		boolean OKboxshadow = true;

		testCase = extent.createTest("13.OK-BOX-SHADOW");
		try {
			AssertJUnit.assertEquals(ActualOKboxshadow, ExpectedOKboxshadow);
		} catch (AssertionError e) {
			OKboxshadow = false;
		}
		if (OKboxshadow) {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualOKboxshadow);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedOKboxshadow);
			testCase.log(Status.INFO, "Correct bordercolor");
			testCase.log(Status.PASS, "Correct bordercolor");
		} else {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualOKboxshadow);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedOKboxshadow);
			testCase.log(Status.INFO, "wrong bordercolor");
			testCase.log(Status.FAIL, "wrong bordercolor");
		}
		Thread.sleep(2000);

//****************************** 11.font family****************************************
		String actualElementfamily = DeleteSbuUIPage.OkButton.getCssValue("font-style");
		System.out.println("FONT-style: " + actualElementfamily);
		String expectedElementFamily = "normal";
		testCase = extent.createTest("14.FONT-FAMILY");
		try {
			Assert.assertEquals(actualElementfamily, expectedElementFamily);
			testCase.log(Status.INFO, "ActualFontFamily :- " + actualElementfamily);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementFamily);
			testCase.log(Status.INFO, "Correct FontFamily");
			testCase.log(Status.PASS, "Correct FontFamily");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontFamily:- " + actualElementfamily);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementFamily);
			testCase.log(Status.INFO, "wrong FontFamily");
			testCase.log(Status.FAIL, "wrong FontFamily");
		}
		Thread.sleep(2000);

//************************************** 12.font size**************************************
		String actualElementfontsize = DeleteSbuUIPage.OkButton.getCssValue("font-size");
		System.out.println("FONT-style: " + actualElementfontsize);
		String expectedElementfontsize = "14px";
		testCase = extent.createTest("15.FONT-SIZE");
		try {
			Assert.assertEquals(actualElementfontsize, expectedElementfontsize);
			testCase.log(Status.INFO, "ActualFontFamily :- " + actualElementfontsize);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementfontsize);
			testCase.log(Status.INFO, "Correct FontFamily");
			testCase.log(Status.PASS, "Correct FontFamily");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontFamily:- " + actualElementfontsize);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementfontsize);
			testCase.log(Status.INFO, "wrong FontFamily");
			testCase.log(Status.FAIL, "wrong FontFamily");
		}
		Thread.sleep(2000);

//********************************* 13.OK spelling*******************************************
		String actualElementText = DeleteSbuUIPage.OkButton.getText();
		System.out.println("TEXT: " + actualElementText);
		String expectedElementText = "OK";
		testCase = extent.createTest("16.SPELLING");
		try {
			Assert.assertEquals(actualElementText, expectedElementText);
			testCase.log(Status.INFO, "ActualFontFamily :- " + actualElementText);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementText);
			testCase.log(Status.INFO, "Correct FontFamily");
			testCase.log(Status.PASS, "Correct FontFamily");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontFamily:- " + actualElementText);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedElementText);
			testCase.log(Status.INFO, "wrong FontFamily");
			testCase.log(Status.FAIL, "wrong FontFamily");
		}

		Thread.sleep(2000);

//********************************** 14.OK padding**********************************
		String actualElementpadding = DeleteSbuUIPage.OkButton.getCssValue("padding");
		System.out.println("padding: " + actualElementpadding);
		String expectedElementpadding = "0px 7px";
		testCase = extent.createTest("17.PADDING");
		try {
			Assert.assertEquals(actualElementpadding, expectedElementpadding);
			testCase.log(Status.INFO, "Actualpadding :- " + actualElementpadding);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedElementpadding);
			testCase.log(Status.INFO, "Correct padding");
			testCase.log(Status.PASS, "Correct padding");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actualpadding:- " + actualElementpadding);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedElementpadding);
			testCase.log(Status.INFO, "wrong padding");
			testCase.log(Status.FAIL, "wrong padding");
		}
		Thread.sleep(2000);
//*************************************15.OK border-radius***************************************
		String actualElementBorderRadius = DeleteSbuUIPage.OkButton.getCssValue("border-radius");
		System.out.println("border radius: " + actualElementpadding);
		String expectedElementBorderRadius = "2px";
		testCase = extent.createTest("18.Border-Radius");
		try {
			Assert.assertEquals(actualElementBorderRadius, expectedElementBorderRadius);
			testCase.log(Status.INFO, "Actualpadding :- " + actualElementBorderRadius);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedElementBorderRadius);
			testCase.log(Status.INFO, "Correct padding");
			testCase.log(Status.PASS, "Correct padding");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actualpadding:- " + actualElementBorderRadius);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedElementBorderRadius);
			testCase.log(Status.INFO, "wrong padding");
			testCase.log(Status.FAIL, "wrong padding");
		}
		Thread.sleep(2000);
//********************************* 16. OK opacity**********************************

		String actualElementopacity = DeleteSbuUIPage.OkButton.getCssValue("opacity");
		String expectedElementopacity = "1";
		System.out.println("DELETE BUTTON-OPACITY: " + actualElementopacity);
		testCase = extent.createTest("19.DELETE BUTTON-OPACITY");
		try {
			Assert.assertEquals(actualElementopacity, expectedElementopacity);
			testCase.log(Status.INFO, "ActualOpacity :- " + actualElementopacity);
			testCase.log(Status.INFO, "ExpectedOpacity :- " + expectedElementopacity);
			testCase.log(Status.INFO, "Correct Opacity");
			testCase.log(Status.PASS, "Correct Opacity");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualOpacity :- " + actualElementopacity);
			testCase.log(Status.INFO, "ExpectedOpacity :- " + expectedElementopacity);
			testCase.log(Status.INFO, "wrong Opacity");
			testCase.log(Status.FAIL, "wrong Opacity");
		}
		Thread.sleep(2000);

//*********************** 17.OK font weight********************************

		String actualElementweight = DeleteSbuUIPage.OkButton.getCssValue("font-weight");
		String expectedElementweight = "400";
		System.out.println("DELETE BUTTON-WEIGHT: " + actualElementweight);
		testCase = extent.createTest("20.DELETE BUTTON-WEIGHT");
		try {
			Assert.assertEquals(actualElementweight, expectedElementweight);
			testCase.log(Status.INFO, "ActualWEIGHT :- " + actualElementweight);
			testCase.log(Status.INFO, "ExpectedWEIGHT :- " + expectedElementweight);
			testCase.log(Status.INFO, "Correct WEIGHT");
			testCase.log(Status.PASS, "Correct WEIGHT");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualWEIGHT :- " + actualElementweight);
			testCase.log(Status.INFO, "ExpectedWEIGHT :- " + expectedElementweight);
			testCase.log(Status.INFO, "wrong WEIGHT");
			testCase.log(Status.FAIL, "wrong WEIGHT");
		}
		Thread.sleep(2000);
//************************** 18.OK font style********************************
		String ActualFontType = DeleteSbuUIPage.OkButton.getCssValue("font-style");
		System.out.println("font-style " + ActualFontType);
		String ExpectedFontType = "normal";

		boolean font = true;

		testCase = extent.createTest("21.FONT-STYLE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);
		} catch (AssertionError e) {
			font = false;
		}
		if (font) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.INFO, "Correct FontType ");
			testCase.log(Status.PASS, "Correct FontType ");
		} else {
			testCase.log(Status.INFO, "ActualFontType  :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType  :- " + ExpectedFontType);
			testCase.log(Status.INFO, "wrong FontType ");
			testCase.log(Status.FAIL, "wrong FontType ");
		}
		Thread.sleep(2000);

	}
	}
	
	@Test(priority = 2)
	public void deleteCancelsbu() throws InterruptedException, IOException {
		// ************************1.Cancel Button visible************************
		
boolean ExpectedCancelVisible=true;
		
		boolean ActualCancelVisible=DeleteSbuUIPage.CancelButton.isDisplayed();
		testCase = extent.createTest("22-CANCEL-BUTTON-VISIBLE");
		try {
			Assert.assertEquals(ExpectedCancelVisible, ActualCancelVisible);
			testCase.log(Status.INFO, "Actual Cancel Button Visible :- " + ExpectedCancelVisible);
			testCase.log(Status.INFO, "Expected Cancel Visible :- " + ActualCancelVisible);
			testCase.log(Status.PASS, "Cancel Visible is Correct");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Cancel Button Visible :- " + ExpectedCancelVisible);
			testCase.log(Status.INFO, "Expected Cancel Visible :- " + ActualCancelVisible);
			testCase.log(Status.FAIL, "Cancel Visible is Wrong");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);

//***************************2.Enabled*************************************		
		if(ActualCancelVisible) {
        try {
		boolean AcctualCancelenabled = DeleteSbuUIPage.CancelButton.isEnabled();
		boolean ExpectedCancelenabled = true;

		boolean Cancelenabled = true;
		testCase = extent.createTest("23.ELEMENT-CANCEL-ENABLED");
		try {
			AssertJUnit.assertEquals(AcctualCancelenabled, ExpectedCancelenabled);
		} catch (AssertionError e) {
			Cancelenabled = false;
		}
		if (Cancelenabled) {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualCancelenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedCancelenabled);
			testCase.log(Status.INFO, "Element Available");
			testCase.log(Status.PASS, "Correct element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + AcctualCancelenabled);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedCancelenabled);
			testCase.log(Status.INFO, "Element not enabled");
			testCase.log(Status.FAIL, "wrong");
		}
        }catch (Exception e) {
        	testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

//*****************************3.Check position**********************
		try {
		Point actual = DeleteSbuUIPage.CancelButton.getLocation();

		int x = actual.getX();
		int y = actual.getY();
		
		System.out.println("x-axis = " + x);
		System.out.println("y-axis = " + y);
		
	
		Point expectedresult = new Point(695, 127);
		testCase = extent.createTest("24.CANCEL POSTION");
		boolean position = true;
		
		try {
			AssertJUnit.assertEquals(actual, expectedresult);
		} catch (AssertionError e) {
			position = false;
		}
			if (position) {
				testCase.log(Status.INFO, "ActualElement :- " + actual);
				testCase.log(Status.INFO, "ExpectedElement :- " + expectedresult);
				testCase.log(Status.INFO, "correct postion");
				testCase.log(Status.PASS, "Correct ");
			} else {
				testCase.log(Status.INFO, "ActualElement :- " + actual);
				testCase.log(Status.INFO, "ExpectedElement :- " + expectedresult);
				testCase.log(Status.INFO, "wrong postion");
				testCase.log(Status.FAIL, "wrong");
			}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
			Thread.sleep(2000);
		
		

//****************************4. Check the size******************************
	    try {
		Dimension ActualCancelSize = DeleteSbuUIPage.CancelButton.getSize();
		System.out.println("Size :" + ActualCancelSize);
		Dimension ExpectedCancelSize = new Dimension(59, 24);

		boolean Cancelsize = true;
		testCase = extent.createTest("25.BUTTON-CANCEL-SIZE");
		try {
			AssertJUnit.assertEquals(ActualCancelSize, ExpectedCancelSize);
		} catch (AssertionError e) {
			Cancelsize = false;
		}
		if (Cancelsize) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualCancelSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedCancelSize);
			testCase.log(Status.INFO, "Correct Size");
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualCancelSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedCancelSize);
			testCase.log(Status.INFO, "wrong Size");
			testCase.log(Status.FAIL, "wrong Size");
		}
	    }catch (Exception e) {
	    	testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);
//******************************* 5.Check test button color*************************
		try {
		String ActualCancelColour = DeleteSbuUIPage.CancelButton.getCssValue("background-color");
		System.out.println("Cancel rgb :" + ActualCancelColour);

		// String hexcolour = Color.fromString(ActualColour).asHex();
		String ExpectedCancelColour = "rgba(255, 255, 255, 1)";

		boolean Cancelcolour = true;

		testCase = extent.createTest("26.BACK-GROUND CANCEL COLOR");
		try {
			AssertJUnit.assertEquals(ActualCancelColour, ExpectedCancelColour);
		} catch (AssertionError e) {
			Cancelcolour = false;
		}
		if (Cancelcolour) {
			testCase.log(Status.INFO, "ActualColour :- " + ActualCancelColour);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedCancelColour);
			testCase.log(Status.INFO, "Correct Colour");
			testCase.log(Status.PASS, "Correct Colour");
		} else {
			testCase.log(Status.INFO, "ActualColour :- " + ActualCancelColour);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedCancelColour);
			testCase.log(Status.INFO, "wrong Colour");
			testCase.log(Status.FAIL, "wrong Colour");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

// ***********************************6. check font color*****************************
		try {
		String ActualCancelfontColor = DeleteSbuUIPage.CancelButton.getCssValue("color");
		System.out.println("Color of Cancel button: " + ActualCancelfontColor);
		String ExpectedCancelfontColor = "rgba(0, 0, 0, 0.85)";

		boolean CancelfontColour = true;

		testCase = extent.createTest("27.CANCEL-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualCancelfontColor, ExpectedCancelfontColor);
		} catch (AssertionError e) {
			CancelfontColour = false;
		}
		if (CancelfontColour) {
			testCase.log(Status.INFO, "ActualColour :- " + ActualCancelfontColor);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedCancelfontColor);
			testCase.log(Status.INFO, "Correct  Colour");
			testCase.log(Status.PASS, "Correct  Colour");
		} else {
			testCase.log(Status.INFO, "ActualColour :- " + ActualCancelfontColor);
			testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedCancelfontColor);
			testCase.log(Status.INFO, "wrong Colour");
			testCase.log(Status.FAIL, "wrong Colour");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);
//****************************** 7. check cursor************************************
        try {
		String ActualCancelcursor = DeleteSbuUIPage.CancelButton.getCssValue("cursor");
		System.out.println("Cursor: " + ActualCancelcursor);
		String ExpectedCancelcursor = "pointer";

		boolean Canelcursor = true;

		testCase = extent.createTest("28.OK-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualCancelcursor, ExpectedCancelcursor);
		} catch (AssertionError e) {
			Canelcursor = false;
		}
		if (Canelcursor) {
			testCase.log(Status.INFO, "ActualCursor :- " + ActualCancelcursor);
			testCase.log(Status.INFO, "ExpectedCursor :- " + ExpectedCancelcursor);
			testCase.log(Status.INFO, "Correct Cursor");
			testCase.log(Status.PASS, "Correct Cursor");
		} else {
			testCase.log(Status.INFO, "ActualCursor :- " + ActualCancelcursor);
			testCase.log(Status.INFO, "ExpectedCursor :- " + ExpectedCancelcursor);
			testCase.log(Status.INFO, "wrong Cursor");
			testCase.log(Status.FAIL, "wrong Cursor");
		}
        }catch (Exception e) {
        	testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);
//*************************** 8.text-align************************************
		try {
		String ActualCanceltextalign = DeleteSbuUIPage.CancelButton.getCssValue("text-align");
		System.out.println("text align: " + ActualCanceltextalign);
		String ExpectedCanceltextalign = "center";

		boolean Canceltextalign = true;

		testCase = extent.createTest("29.OK-text-align");
		try {
			AssertJUnit.assertEquals(ActualCanceltextalign, ExpectedCanceltextalign);
		} catch (AssertionError e) {
			Canceltextalign = false;
		}
		if (Canceltextalign) {
			testCase.log(Status.INFO, "Actualtextalign :- " + ActualCanceltextalign);
			testCase.log(Status.INFO, "Expectedtextalign :- " + ExpectedCanceltextalign);
			testCase.log(Status.INFO, "Correct textalign");
			testCase.log(Status.PASS, "Correct textalign");
		} else {
			testCase.log(Status.INFO, "Actualtextalign :- " + ActualCanceltextalign);
			testCase.log(Status.INFO, "Expectedtextalign :- " + ExpectedCanceltextalign);
			testCase.log(Status.INFO, "wrong textalign");
			testCase.log(Status.FAIL, "wrong textalign");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);
		// vertical-align
		try {
		String ActualCancelverticalalign = DeleteSbuUIPage.CancelButton.getCssValue("vertical-align");
		System.out.println("vertical align: " + ActualCancelverticalalign);
		String ExpectedCancelverticalalign = "baseline";

		boolean Cancelverticalalign = true;

		testCase = extent.createTest("30.CANCEL-VERTICAL-ALIGN");
		try {
			AssertJUnit.assertEquals(ActualCancelverticalalign, ExpectedCancelverticalalign);
		} catch (AssertionError e) {
			Cancelverticalalign = false;
		}
		if (Cancelverticalalign) {
			testCase.log(Status.INFO, "Actualverticalalign :- " + ActualCancelverticalalign);
			testCase.log(Status.INFO, "Expectedverticalalign :- " + ExpectedCancelverticalalign);
			testCase.log(Status.INFO, "Correct verticalalign");
			testCase.log(Status.PASS, "Correct textalign");
		} else {
			testCase.log(Status.INFO, "Actualverticalalign :- " + ActualCancelverticalalign);
			testCase.log(Status.INFO, "Expectedverticalalign :- " + ExpectedCancelverticalalign);
			testCase.log(Status.INFO, "wrong verticalalign");
			testCase.log(Status.FAIL, "wrong verticalalign");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

//******************************* 9.border color*************************************
		try {
		String ActualCancelbordercolor = DeleteSbuUIPage.CancelButton.getCssValue("border-color");
		System.out.println("border color " + ActualCancelbordercolor);
		String ExpectedCancelbordercolor = "rgb(217, 217, 217)";

		boolean Cancelbordercolor = true;

		testCase = extent.createTest("31.CANCEL-BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualCancelbordercolor, ExpectedCancelbordercolor);
		} catch (AssertionError e) {
			Cancelbordercolor = false;
		}
		if (Cancelbordercolor) {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualCancelbordercolor);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedCancelbordercolor);
			testCase.log(Status.INFO, "Correct bordercolor");
			testCase.log(Status.PASS, "Correct bordercolor");
		} else {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualCancelbordercolor);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedCancelbordercolor);
			testCase.log(Status.INFO, "wrong bordercolor");
			testCase.log(Status.FAIL, "wrong bordercolor");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);
//*********************************** 10.box shadow*************************************
		try {
		String ActualCancelboxshadow = DeleteSbuUIPage.CancelButton.getCssValue("box-shadow");
		System.out.println("box-shadow " + ActualCancelboxshadow);
		String ExpectedCancelboxshadow = "rgba(0, 0, 0, 0.016) 0px 2px 0px 0px";

		boolean Cancelboxshadow = true;

		testCase = extent.createTest("32.CANCEL-BOX-SHADOW");
		try {
			AssertJUnit.assertEquals(ActualCancelboxshadow, ExpectedCancelboxshadow);
		} catch (AssertionError e) {
			Cancelboxshadow = false;
		}
		if (Cancelboxshadow) {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualCancelboxshadow);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedCancelboxshadow);
			testCase.log(Status.INFO, "Correct bordercolor");
			testCase.log(Status.PASS, "Correct bordercolor");
		} else {
			testCase.log(Status.INFO, "Actualbordercolor :- " + ActualCancelboxshadow);
			testCase.log(Status.INFO, "Expectedbordercolor :- " + ExpectedCancelboxshadow);
			testCase.log(Status.INFO, "wrong bordercolor");
			testCase.log(Status.FAIL, "wrong bordercolor");
		}
		}catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
		}
		Thread.sleep(2000);

//****************************** 11.font STYLE****************************************
		String actualCancelElementstyle = DeleteSbuUIPage.CancelButton.getCssValue("font-style");
		System.out.println("FONT-style: " + actualCancelElementstyle);
		String expectedCancelElementFamily = "normal";
		testCase = extent.createTest("33.CANCEL-FONT-STYLE");
		try {
			Assert.assertEquals(actualCancelElementstyle, expectedCancelElementFamily);
			testCase.log(Status.INFO, "ActualFontstyle :- " + actualCancelElementstyle);
			testCase.log(Status.INFO, "ExpectedFontstyle :- " + expectedCancelElementFamily);
			testCase.log(Status.INFO, "Correct Fontstyle");
			testCase.log(Status.PASS, "Correct Fontstyle");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontstyle:- " + actualCancelElementstyle);
			testCase.log(Status.INFO, "ExpectedFontstyle :- " + expectedCancelElementFamily);
			testCase.log(Status.INFO, "wrong Fontstyle");
			testCase.log(Status.FAIL, "wrong Fontstyle");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);

//************************************** 12.font size**************************************
		String actualCancelElementfontsize = DeleteSbuUIPage.CancelButton.getCssValue("font-size");
		System.out.println("FONT-style: " + actualCancelElementfontsize);
		String expectedCancelElementfontsize = "14px";
		testCase = extent.createTest("34.FONT-SIZE");
		try {
			Assert.assertEquals(actualCancelElementfontsize, expectedCancelElementfontsize);
			testCase.log(Status.INFO, "ActualFontFamily :- " + actualCancelElementfontsize);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedCancelElementfontsize);
			testCase.log(Status.INFO, "Correct FontFamily");
			testCase.log(Status.PASS, "Correct FontFamily");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontFamily:- " + actualCancelElementfontsize);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedCancelElementfontsize);
			testCase.log(Status.INFO, "wrong FontFamily");
			testCase.log(Status.FAIL, "wrong FontFamily");
		} catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);

//********************************* 13.spelling*******************************************
		String actualCaneclElementText = DeleteSbuUIPage.CancelButton.getText();
		System.out.println("TEXT: " + actualCaneclElementText);
		String expectedCancelElementText = "Cancel";
		testCase = extent.createTest("35.SPELLING");
		try {
			Assert.assertEquals(actualCaneclElementText, expectedCancelElementText);
			testCase.log(Status.INFO, "ActualFontFamily :- " + actualCaneclElementText);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedCancelElementText);
			testCase.log(Status.INFO, "Correct FontFamily");
			testCase.log(Status.PASS, "Correct FontFamily");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontFamily:- " + actualCaneclElementText);
			testCase.log(Status.INFO, "ExpectedFontFamily :- " + expectedCancelElementText);
			testCase.log(Status.INFO, "wrong FontFamily");
			testCase.log(Status.FAIL, "wrong FontFamily");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}

		Thread.sleep(2000);

//********************************** 14.padding**********************************
		String actualCancelElementpadding = DeleteSbuUIPage.CancelButton.getCssValue("padding");
		System.out.println("padding: " + actualCancelElementpadding);
		String expectedCancelElementpadding = "0px 7px";
		testCase = extent.createTest("36.PADDING");
		try {
			Assert.assertEquals(actualCancelElementpadding, expectedCancelElementpadding);
			testCase.log(Status.INFO, "Actualpadding :- " + actualCancelElementpadding);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedCancelElementpadding);
			testCase.log(Status.INFO, "Correct padding");
			testCase.log(Status.PASS, "Correct padding");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actualpadding:- " + actualCancelElementpadding);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedCancelElementpadding);
			testCase.log(Status.INFO, "wrong padding");
			testCase.log(Status.FAIL, "wrong padding");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);
//*************************************15. border-radius***************************************
		String actualCancelElementBorderRadius = DeleteSbuUIPage.CancelButton.getCssValue("border-radius");
		System.out.println("padding: " + actualCancelElementBorderRadius);
		String expectedCacnelElementBorderRadius = "2px";
		testCase = extent.createTest("37.Cancel-Border-Radius");
		try {
			Assert.assertEquals(actualCancelElementBorderRadius, expectedCacnelElementBorderRadius);
			testCase.log(Status.INFO, "Actualpadding :- " + actualCancelElementBorderRadius);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedCacnelElementBorderRadius);
			testCase.log(Status.INFO, "Correct padding");
			testCase.log(Status.PASS, "Correct padding");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actualpadding:- " + actualCancelElementBorderRadius);
			testCase.log(Status.INFO, "Expectedpadding :- " + expectedCacnelElementBorderRadius);
			testCase.log(Status.INFO, "wrong padding");
			testCase.log(Status.FAIL, "wrong padding");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);
//********************************* 16.Cancel opacity**********************************

		String actualElementopacity = DeleteSbuUIPage.CancelButton.getCssValue("opacity");
		String expectedElementopacity = "1";
		System.out.println("CANCEL-BUTTON-OPACITY: " + actualElementopacity);
		testCase = extent.createTest("38.CANCEL-BUTTON-OPACITY");
		try {
			Assert.assertEquals(actualElementopacity, expectedElementopacity);
			testCase.log(Status.INFO, "ActualOpacity :- " + actualElementopacity);
			testCase.log(Status.INFO, "ExpectedOpacity :- " + expectedElementopacity);
			testCase.log(Status.INFO, "Correct Opacity");
			testCase.log(Status.PASS, "Correct Opacity");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualOpacity :- " + actualElementopacity);
			testCase.log(Status.INFO, "ExpectedOpacity :- " + expectedElementopacity);
			testCase.log(Status.INFO, "wrong Opacity");
			testCase.log(Status.FAIL, "wrong Opacity");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);

//*********************** 17.font weight********************************

		String actualElementweight = DeleteSbuUIPage.CancelButton.getCssValue("font-weight");
		String expectedElementweight = "400";
		System.out.println("CANCEL-BUTTON-WEIGHT: " + actualElementweight);
		testCase = extent.createTest("39.CANCEL-BUTTON-WEIGHT");
		try {
			Assert.assertEquals(actualElementweight, expectedElementweight);
			testCase.log(Status.INFO, "ActualWEIGHT :- " + actualElementweight);
			testCase.log(Status.INFO, "ExpectedWEIGHT :- " + expectedElementweight);
			testCase.log(Status.INFO, "Correct WEIGHT");
			testCase.log(Status.PASS, "Correct WEIGHT");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualWEIGHT :- " + actualElementweight);
			testCase.log(Status.INFO, "ExpectedWEIGHT :- " + expectedElementweight);
			testCase.log(Status.INFO, "wrong WEIGHT");
			testCase.log(Status.FAIL, "wrong WEIGHT");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
		Thread.sleep(2000);
//************************** 18.CANCEL-font type********************************
		try {
		String ActualFontType = DeleteSbuUIPage.CancelButton.getCssValue("font-STYLE");
		System.out.println("CANCEL-font-type " + ActualFontType);
		String ExpectedFontType = "normal";

		boolean font = true;

		testCase = extent.createTest("40.CANCEL-FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);
		} catch (AssertionError e) {
			font = false;
		}
		if (font) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.INFO, "Correct FontType ");
			testCase.log(Status.PASS, "Correct FontType ");
		} else {
			testCase.log(Status.INFO, "ActualFontType  :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType  :- " + ExpectedFontType);
			testCase.log(Status.INFO, "wrong FontType ");
			testCase.log(Status.FAIL, "wrong FontType ");
		}
		}catch(Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT ");
		}
		Thread.sleep(2000);
		}

	}
	//************************for text*********************
	@Test(priority = 3)
	public void deletetextsbu() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
//		TextPage.master1.click();
		
	//Text Visible
		boolean ExpectedTextVisible=true;
		
		boolean ActualTextVisible=DeleteSbuUIPage.text.isDisplayed();
		testCase = extent.createTest("41-TEXT-Visible");
		try {
			Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
			testCase.log(Status.INFO, "Actual TEXT Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected TEXT Visible :- " + ExpectedTextVisible);
			testCase.log(Status.PASS, "TEXT Visible is Correct");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual TEXT Visible :- " + ActualTextVisible);
			testCase.log(Status.INFO, "Expected TEXT Visible :- " + ExpectedTextVisible);
			testCase.log(Status.FAIL, "TEXT Visible is Wrong");
		}catch (NoSuchElementException e) {
			testCase.log(Status.FAIL, "No element");
		}
//FONT COLOR
        if(ExpectedTextVisible) {
        String ActualTitleFontColor = DeleteSbuUIPage.text.getCssValue("color");
        System.out.println("Font color of button: " + ActualTitleFontColor);
        String ExpectedTitleFontColor ="rgba(0, 0, 0, 0.85)";

        boolean fontColour = true;

        testCase = extent.createTest("42.TEXT-FONT-COLOUR");
        try {
            Assert.assertEquals(ActualTitleFontColor, ExpectedTitleFontColor);

        } catch (AssertionError e) {
            // TODO: handle exception

            fontColour = false;
        }
        if (fontColour) {
            testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
            testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
            testCase.log(Status.INFO, "Correct font Colour");
            testCase.log(Status.PASS, "Correct font Colour");

        } else {
            testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
            testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
            testCase.log(Status.INFO, "wrong font Colour");
            testCase.log(Status.FAIL, "wrong font Colour");
        }
//FONTSIZE
        String ActualTitleFontsSize = DeleteSbuUIPage.text.getCssValue("font-size");
        System.out.println("Font Size: " + ActualTitleFontsSize);
        String ExpectedTitleFontsSize = "14px";

        boolean fontsize = true;
        testCase = extent.createTest("43.TITLE-FONT- SIZE");

        try {
            Assert.assertEquals(ActualTitleFontsSize, ExpectedTitleFontsSize);
        } catch (AssertionError e) {
            // TODO: handle exception
            fontsize = false;

        }
        if (fontsize) {
            testCase.log(Status.INFO, "ActualfontSize :-" + ActualTitleFontsSize);
            testCase.log(Status.INFO, "ExpectedfontSize:-" + ExpectedTitleFontsSize);
            testCase.log(Status.PASS, "Correct font-size");
            testCase.log(Status.PASS, " Font-size Correct");
        } else {
            testCase.log(Status.INFO, "ActualfontsSize :- " + ActualTitleFontsSize);
            testCase.log(Status.INFO, "ExpectedfontsSize :- " + ExpectedTitleFontsSize);
            testCase.log(Status.INFO, "Wrong font-size");
            testCase.log(Status.FAIL, "Font-size Wrong");

        }
//Font Family (Specifies the font family for text //family-name, generic-family, inherit)
	
        String ActualElementfamily = DeleteSbuUIPage.text.getCssValue("FONT-FAMILY");
        System.out.println("FONT-FAMILY: "+ActualElementfamily);
        String ExpectedElementFamily = "Roboto, sans-serif";
        testCase = extent.createTest("44.FONT-FAMILY");
        try {
            Assert.assertEquals(ActualElementfamily, ExpectedElementFamily);
            testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
            testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
            testCase.log(Status.INFO, "Correct Text");
            testCase.log(Status.PASS, "Correct Text");
        } catch (AssertionError e) {
            testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
            testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
            testCase.log(Status.INFO, "wrong Text");
            testCase.log(Status.FAIL, "wrong Text");
        }
        Thread.sleep(2000);
 //Enable
        boolean ExpectedTextEnable=true;
		boolean ActualTextEnable=DeleteSbuUIPage.text.isEnabled();
		System.out.println("TEXT EABLE: "+ActualTextEnable);
		testCase = extent.createTest("45.TEXT ENABLE");
		try {
			Assert.assertEquals(ActualTextEnable, ExpectedTextEnable);
			testCase.log(Status.INFO, "Actual External Radio Button Enable :- " + ActualTextEnable);
			testCase.log(Status.INFO, "Expected External Radio Button Enable :- " + ExpectedTextEnable);
			testCase.log(Status.PASS, "External Radio Button Enable is Correct");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual External Radio Button Enable :- " + ActualTextEnable);
			testCase.log(Status.INFO, "Expected External Radio Button Enable :- " + ExpectedTextEnable);
			testCase.log(Status.FAIL, "External Radio Button Enable is Wrong");
	}
//Spelling		
		try {
            String AcctualTitleText = DeleteSbuUIPage.text.getText();
            String ExpectedTitleText = "Are you sure you want to Delete this?";
            System.out.println(" Text:" + AcctualTitleText);
            boolean Titletext = true;
            testCase = extent.createTest("46.TITLE-SPELLING-TEXT");
            try {
                Assert.assertEquals(AcctualTitleText, ExpectedTitleText);
            } catch (AssertionError e) {
                Titletext = false;
            }
            if (Titletext) {
                testCase.log(Status.INFO, "AcctualTitleText :- " + AcctualTitleText);
                testCase.log(Status.INFO, "ExpectedTitleText :- " + ExpectedTitleText);
                testCase.log(Status.INFO, "Element Available");
                testCase.log(Status.PASS, "Correct element");
            } else {
                testCase.log(Status.INFO, "AcctualTitleText :- " + AcctualTitleText);
                testCase.log(Status.INFO, "ExpectedTitleText :- " + ExpectedTitleText);
                testCase.log(Status.INFO, "Element not available");
                testCase.log(Status.FAIL, "No Element");
            }
        } catch (Exception e) {
            testCase = extent.createTest("46.TITLE-SPELLING-TEXT");
            testCase.log(Status.FAIL, "No Element");
        }
		
//Position
		Point ActulaTitleLocation = DeleteSbuUIPage.text.getLocation();        
        int actual_x = ActulaTitleLocation.getX();
        int actual_y = ActulaTitleLocation.getY();
        System.out.println("X axis: " + actual_x);
        System.out.println("Y axis: " + actual_y);
        
        Point ExpectedTitleLocation = new Point(546, 93);
        boolean Position = true; 
        testCase = extent.createTest("47.TITLE-POSITION");
        try {
            Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);

        } catch (AssertionError e) {
            Position = false; 
        }
        if (Position) {
            testCase.log(Status.INFO, "ActualFontSize :- " + ActulaTitleLocation);
            testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedTitleLocation);
            testCase.log(Status.PASS, "Correct Location");
        } else {
            testCase.log(Status.INFO, "ActualSize :- " + ActulaTitleLocation);
            testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedTitleLocation);
            testCase.log(Status.FAIL, "Wrong Location");
        }
//Padding   
        
        String ActualTitlepadding = DeleteSbuUIPage.text.getCssValue("padding");
        System.out.println("PADING: "+ActualTitlepadding);
        String ExpectedTitlepadding = "0px 0px 0px 22px";
        testCase = extent.createTest("48.TEXT PADDING");
        try {
            Assert.assertEquals(ActualTitlepadding, ExpectedTitlepadding);
            testCase.log(Status.INFO, "Actual padding :- " + ActualTitlepadding);
            testCase.log(Status.INFO, "Expected padding :- " + ExpectedTitlepadding);
            testCase.log(Status.PASS, "padding is Correct");
        } catch (AssertionError e) {
            testCase.log(Status.INFO, "Actual padding :- " + ActualTitlepadding);
            testCase.log(Status.INFO, "Expected padding :- " + ExpectedTitlepadding);
            testCase.log(Status.FAIL, "padding is Wrong");
        }
        
//Shadow
        String ActualTitleShadow = DeleteSbuUIPage.text.getCssValue("box-shadow");
        System.out.println("Text Shadow :" + ActualTitleShadow);

        String ExpectedTitleShadow = "none";

        boolean boxshadow = true;
        testCase = extent.createTest("49.TEXT-SHADOW");
        try {
            Assert.assertEquals(ActualTitleShadow, ExpectedTitleShadow);

        } catch (AssertionError e) {
            boxshadow = false;
        }
        if (boxshadow) {
            testCase.log(Status.INFO, "ActualTitleShadow :- " + ActualTitleShadow);
            testCase.log(Status.INFO, "ExpectedTitleShadow :- " + ExpectedTitleShadow);
            testCase.log(Status.PASS, "Shadow text available");
        } else {
            testCase.log(Status.INFO, "ActualBorderColor :- " + ActualTitleShadow);
            testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedTitleShadow);
            testCase.log(Status.FAIL, "Shadow text not available");
        }
        
//Margin
        String ActualTitleMargin = DeleteSbuUIPage.text.getCssValue("margin");
        System.out.println("Text Margin :" + ActualTitleMargin);

      String ExpectedTitleMargin = "0px";

    boolean textmargin = true;
    testCase = extent.createTest("50.TEXT-MARGIN");
    try {
    Assert.assertEquals(ActualTitleMargin, ExpectedTitleMargin);
    }
    catch (AssertionError e) { 
        // TODO: handle exception
        textmargin =false;
        
    }if (textmargin) {
        testCase.log(Status.INFO, "ActualTitleMargin :- " + ActualTitleMargin);
        testCase.log(Status.INFO, "ExpectedTitleMargin :- " + ExpectedTitleMargin);
        testCase.log(Status.PASS, "Text margin available");
    } else {
        testCase.log(Status.INFO, "ActualTitleMargin :- " + ActualTitleMargin);
        testCase.log(Status.INFO, "ExpectedTitleMargin :- " + ExpectedTitleMargin);
        testCase.log(Status.FAIL, "Text margin text not available");
    } 
//LETTER SPACING
    String ActualLetterSpacing = DeleteSbuUIPage.text.getCssValue("letter-spacing");
    System.out.println("Letter Spacing :" + ActualLetterSpacing);

    String ExpectedLetterSpacing = "normal";

    boolean letterspacing = true;
    testCase = extent.createTest("51.LETTER-SPACING");
    try {
        Assert.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

    } catch (AssertionError e) {
        letterspacing = false; 
    }
    if (letterspacing) {
        testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
        testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
        testCase.log(Status.PASS, "Letter spacing is as expected");
    } else {
        testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
        testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
        testCase.log(Status.FAIL, "Letter spacing is not as expected");
    }
    
// WORD SPACING
    String ActualWordSpacing = DeleteSbuUIPage.text.getCssValue("word-spacing");
    System.out.println("Word Spacing :" + ActualWordSpacing);

    String ExpectedWordSpacing = "0px";

    boolean wordspacing = true;
    testCase = extent.createTest("52.WORD-SPACING");
    try {
    Assert.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

    } catch (AssertionError e) {
    wordspacing = false;
    }
    if (wordspacing) {
    testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
    testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
    testCase.log(Status.PASS, "Word spacing is as expected");
    } else {
    testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
    testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
    testCase.log(Status.FAIL, "Word spacing is not as expected");
    }
// ALIGNMENT (CENTER/LEFT/RIGHT)
    String ActualAlignment = DeleteSbuUIPage.text.getCssValue("text-align");
    System.out.println("Text Alignment :" + ActualAlignment);

    String ExpectedAlignment = "left";

    boolean alignment = true;
    testCase = extent.createTest("53.TEXT-ALIGNMENT");
    try {
    Assert.assertEquals(ActualAlignment, ExpectedAlignment);

    } catch (AssertionError e) {
    alignment = false;
    }
    if (alignment) {
    testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
    testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
    testCase.log(Status.PASS, "Alignment is as expected");
    } else {
    testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
    testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
    testCase.log(Status.FAIL, "Alignment is not as expected");
    }
// TEXT TRANSFORMATION (UPERCASE/ LOWECASE)
    
    String ActualTextTransformation = DeleteSbuUIPage.text.getCssValue("text-transform");
    System.out.println("Text Transformation :" + ActualTextTransformation);

    String ExpectedTextTransformation = "none";

    boolean texttransformation = true;
    testCase = extent.createTest("54.TEXT-TRANSFORMATION");
    try {
        Assert.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

    } catch (AssertionError e) {
        texttransformation = false;
    }
    if (texttransformation) {
        testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
        testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
        testCase.log(Status.PASS,  "Transformation expected");
    }
    else {
         testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
         testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
          testCase.log(Status.FAIL,  "Transformation unexpected");
    }
// LINE HEIGHT
    String ActualLineHeight =DeleteSbuUIPage.text.getCssValue("line-height");
    System.out.println("Line Height :" + ActualLineHeight);

    String ExpectedLineHeight = "22.001px";

    boolean lineheight = true;
    testCase = extent.createTest("55.LINE-HEIGHT");
    try {
        Assert.assertEquals(ActualLineHeight, ExpectedLineHeight);

    } catch (AssertionError e) {
        lineheight = false;
    }
    if (lineheight) {
        testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
        testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
        testCase.log(Status.PASS, "Line height is as expected");
    } else {
        testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
        testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
        testCase.log(Status.FAIL, "Line height is not as expected");
    }
    
//Text Decoration
    String ActualTextDecoration = DeleteSbuUIPage.text.getCssValue("text-decoration");
    System.out.println("Text Decoration :" + ActualTextDecoration);

    String ExpectedTextDecoration = "none solid rgba(0, 0, 0, 0.85)";

    boolean textdecoration = true;
    testCase = extent.createTest("56.TEXT-DECORATION");
    try {
        Assert.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

    } catch (AssertionError e) {
        textdecoration = false;
    }
    if (textdecoration) {
        testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
        testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
        testCase.log(Status.PASS, "Text decoration is as expected");
    } else {
        testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
        testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
        testCase.log(Status.FAIL, "Text decoration is not as expected");
    }
    
//VERTICAL ALIGN
    
    
    String actualVerticalAlignment = DeleteSbuUIPage.text.getCssValue("vertical-align");
    System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

    String expectedVerticalAlignment = "baseline";

    boolean verticalAlignment = true;
    testCase = extent.createTest("57.TEXT-VERTICAL-ALIGNMENT");
    try {
        Assert.assertEquals(actualVerticalAlignment, expectedVerticalAlignment);
    } catch (AssertionError e) {
        verticalAlignment = false;
    }

    if (verticalAlignment) {
        testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
        testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
        testCase.log(Status.PASS, "Text vertical Align is as expected");
       
    } else {
        testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
        testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
        testCase.log(Status.PASS, "Text vertical Align is as expected");
        
    }
    
  //TEXT INDENT  (To indent is to begin text with a blank space between it and the margin)
    
    	String ActualTextIndent = DeleteSbuUIPage.text.getCssValue("text-indent");
    	System.out.println("Text Indent :" + ActualTextIndent);

    	String ExpectedTextIndent = "0px";

    	boolean textindent = true;
    	testCase = extent.createTest("58.TEXT-INDENT");
    	try {
        Assert.assertEquals(ActualTextIndent, ExpectedTextIndent);

    	} catch (AssertionError e) {
        textindent = false;}
        if (textindent) {
            testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
            testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
            testCase.log(Status.PASS, "Text Indent is as expected");
           
        } else {
            testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
            testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
            testCase.log(Status.PASS, "Text Indent is as expected");
            
        }
//TEXT - ORIENTATION(text characters in a line. It only affects text in vertical mode)
        
        String ActualTextOrientation = DeleteSbuUIPage.text.getCssValue("text-orientation");
        System.out.println("Text Orientation :" + ActualTextOrientation);

        String ExpectedTextOrientation = "mixed";

        boolean textorientation = true;
        testCase = extent.createTest("59.TEXT-ORIENTATION");
        try {
            Assert.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

        } catch (AssertionError e) {
            textorientation = false;
        }
        if (textorientation) {
            testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
            testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
            testCase.log(Status.PASS, "Text orientation is as expected");
        } else {
            testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
            testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
            testCase.log(Status.PASS, "Text orientation is as unxpected");
        }
//FONT STYLE
        String ActualFontStyle = DeleteSbuUIPage.text.getCssValue("font-style");
        System.out.println("Font Style :" + ActualFontStyle);

        String ExpectedFontStyle = "normal";

        boolean fontstyle = true;
        testCase = extent.createTest("60.FONT-STYLE");
        try {
        Assert.assertEquals(ActualFontStyle, ExpectedFontStyle);

        } catch (AssertionError e) {
        fontstyle = false;
        }
        if (fontstyle) {
        testCase.log(Status.INFO, "ActualFontStyle :- " + ActualFontStyle);
        testCase.log(Status.INFO, "ExpectedFontStyle :- " + ExpectedFontStyle);
        testCase.log(Status.PASS, "Font style is as expected");
        } else {
        testCase.log(Status.INFO, "ActualFontStyle :- " + ActualFontStyle);
        testCase.log(Status.INFO, "ExpectedFontStyle :- " + ExpectedFontStyle);
        testCase.log(Status.FAIL, "Font style is not as expected");
        }
		
        }		
		
}
	@Test(priority = 4)
	public void deletemarksbu() throws InterruptedException, IOException {
	try {	
	boolean AcctualElementDisplayed = DeleteSbuUIPage.mark.isDisplayed();
	
	boolean ExpectedElementDisplayed = true;

	boolean elementDisplayed = true;
	testCase = extent.createTest("ICON-DISPLAYED");
	try {
		AssertJUnit.assertEquals(AcctualElementDisplayed, ExpectedElementDisplayed);
	} catch (AssertionError find) {
		elementDisplayed = false;
	}
	if (elementDisplayed) {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualElementDisplayed);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElementDisplayed);
		testCase.log(Status.INFO, "Element Available");
		testCase.log(Status.PASS, "Correct Element");
	} else {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualElementDisplayed);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElementDisplayed);
		testCase.log(Status.INFO, "Element not available");
		testCase.log(Status.FAIL, "No Element");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	
//Delete Button Location
	Thread.sleep(2000); 
	try {
	Point actualLocation = 	DeleteSbuUIPage.mark.getLocation();

	int  x = actualLocation.getX();
	int y = actualLocation.getY();
	
	System.out.println("x-axis = " + x);
	System.out.println("y-axis = " + y);
	
	
	Point expectedLocation = new Point(546, 97);
	testCase = extent.createTest("ICON-POSITION");
	boolean position = true;
	
	try {
		AssertJUnit.assertEquals(actualLocation, expectedLocation);
	} catch (AssertionError find) {
		position = false;
	}
		if (position) {
			testCase.log(Status.INFO, "ActualElement :- " + actualLocation);
			testCase.log(Status.INFO, "ExpectedElement :- " + expectedLocation);
		
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + actualLocation);
			testCase.log(Status.INFO, "ExpectedElement :- " + expectedLocation);
			
			testCase.log(Status.FAIL, "wrong");
		}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	
	//********************************icon size**********************************	
	  try {
			Dimension ActualCancelSize = DeleteSbuUIPage.mark.getSize();
			System.out.println("Size :" + ActualCancelSize);
			Dimension ExpectedCancelSize = new Dimension(14, 14);

			boolean Cancelsize = true;
			testCase = extent.createTest("ICON-SIZE");
			try {
				AssertJUnit.assertEquals(ActualCancelSize, ExpectedCancelSize);
			} catch (AssertionError e) {
				Cancelsize = false;
			}
			if (Cancelsize) {
				testCase.log(Status.INFO, "ActualSize :- " + ActualCancelSize);
				testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedCancelSize);
				testCase.log(Status.INFO, "Correct Size");
				testCase.log(Status.PASS, "Correct Size");
			} else {
				testCase.log(Status.INFO, "ActualSize :- " + ActualCancelSize);
				testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedCancelSize);
				testCase.log(Status.INFO, "wrong Size");
				testCase.log(Status.FAIL, "wrong Size");
			}
		    }catch (Exception e) {
		    	testCase.log(Status.FAIL, "NO ELEMENT");
			}
			Thread.sleep(2000);
		
//Delete Button Background Color
			try {
		String ActualbackgroundColor = DeleteSbuUIPage.mark.getCssValue("background-color");
  		
  		System.out.println("backgroundcolor = " + ActualbackgroundColor);
  		String expectedBackGroundColor = "rgba(0, 0, 0, 0)";
  		
  		boolean backgroundclr1 = true;
  		testCase = extent.createTest("ICON-background-color");
  		try {
  			AssertJUnit.assertEquals(ActualbackgroundColor, expectedBackGroundColor);
  		} catch (AssertionError find) {
  			backgroundclr1 = false;

  		}
  			if (backgroundclr1) {
  				testCase.log(Status.INFO, "ActualElement :- " + ActualbackgroundColor);
  				testCase.log(Status.INFO, "ExpectedElement :- " + expectedBackGroundColor);

  				testCase.log(Status.PASS, "Correct ");
  			} else {
  				testCase.log(Status.INFO, "ActualElement :- " + ActualbackgroundColor);
  				testCase.log(Status.INFO, "ExpectedElement :- " + expectedBackGroundColor);
  				testCase.log(Status.FAIL, "wrong");
  			}
			}catch (Exception e) {
				testCase.log(Status.FAIL, "No element");
			}
  			
//Delete Button Icon
			try {
  		    String ActualImageUrl = DeleteSbuUIPage.mark.getAttribute("xlink:href");
            String ExpectedImageUrl=null;
            testCase = extent.createTest("Icon");
            try {
                Assert.assertEquals(ActualImageUrl, ExpectedImageUrl);
                testCase.log(Status.INFO, "Actual Icon Image :- " + ActualImageUrl);
                testCase.log(Status.INFO, "Expected Icon Image :- " + ExpectedImageUrl);
                testCase.log(Status.PASS, " Icon Image Correct ");
            } catch (AssertionError e) {
                testCase.log(Status.INFO, "Actual Icon Image :- " + ActualImageUrl);
                testCase.log(Status.INFO, "Expected Icon Image :- " + ExpectedImageUrl);    
                testCase.log(Status.FAIL, " Icon Image wrong");
            }
			}catch (Exception e) {
				testCase.log(Status.FAIL, "No element");
			}
     
//Delete Button Fill Color
			try {
            String fillColor = DeleteSbuUIPage.mark.getCssValue("fill");
            String ActualFillColor = Color.fromString(fillColor).asHex();
            String ExpectedFillColor="#ff0000";
            testCase = extent.createTest("Icon Fill-Color");
            try {
                Assert.assertEquals(ActualFillColor, ExpectedFillColor);
                testCase.log(Status.INFO, "Actual Fill color :- " + ActualFillColor);
                testCase.log(Status.INFO, "Expected Fill color :- " + ExpectedFillColor);
                testCase.log(Status.PASS, " Fill color Correct ");
            } catch (AssertionError e) {
                testCase.log(Status.INFO, "Actual Fill color :- " + ActualFillColor);
                testCase.log(Status.INFO, "Expected Fill color :- " + ExpectedFillColor);    
                testCase.log(Status.FAIL, " Fill color wrong");
            }
			}catch (Exception e) {
				testCase.log(Status.FAIL, "No element");
			}
	
	
	
	}
	@Test(priority = 5)
	public void deletemodalbu() throws InterruptedException, IOException {
	
	try {	
	boolean AcctualVisible = DeleteSbuUIPage.modal.isDisplayed();
	boolean ExpectedVisible = true;

	boolean elementvisible = true;
	testCase = extent.createTest("001-MODAL-VISIBLE");
	try {
		Assert.assertEquals(AcctualVisible, ExpectedVisible);
	} catch (AssertionError e) {
		elementvisible = false;
	}
	if (elementvisible) {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualVisible);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisible);
		testCase.log(Status.INFO, "Element Available");
		testCase.log(Status.PASS, "Correct element");
	} else {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualVisible);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisible);
		testCase.log(Status.INFO, "Element not available");
		testCase.log(Status.FAIL, "No Element");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element position test 
	try {
	Point ActualLocation = DeleteSbuUIPage.modal.getLocation();

	int actual_x = ActualLocation.getX();
	int actual_y = ActualLocation.getY();

	System.out.println("X axis: " + actual_x);
	System.out.println("Y axis: " + actual_y);

	Point ExpectedLocation = new Point(378, 100);

	boolean Position = true;
	testCase = extent.createTest("002-MODAL-POSITION");
	try {
		Assert.assertEquals(ActualLocation, ExpectedLocation);

	} catch (AssertionError e) {
		Position = false;
	}
	if (Position) {
		testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
		testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
		testCase.log(Status.PASS, "Correct Location");
	} else {
		testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
		testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
		testCase.log(Status.FAIL, "Wrong Location");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element size
	try {
	Dimension ActualSize = DeleteSbuUIPage.modal.getSize();
	System.out.println("Size : " + ActualSize);
	Dimension ExpectedSize = new Dimension(600, 550);

	boolean size = true;
	testCase = extent.createTest("003-MODAL-SIZE");
	try {
		Assert.assertEquals(ActualSize, ExpectedSize);

	} catch (AssertionError e) {
		size = false;
	}
	if (size) {
		testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
		testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
		testCase.log(Status.PASS, "Correcrt size");
	} else {
		testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
		testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
		testCase.log(Status.FAIL, "Wrong Size");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element background-color
	try {
	String ActualButtonColor = DeleteSbuUIPage.modal.getCssValue("background-color");
	System.out.println("rgb :" + ActualButtonColor);
	String ExpectedButtonColor = "rgba(0, 0, 0, 0)";

	boolean buttoncolor = true;
	testCase = extent.createTest("004-MODAL-BACKGROUND-COLOR");
	try {
		Assert.assertEquals(ActualButtonColor, ExpectedButtonColor);

	} catch (AssertionError e) {
		buttoncolor = false;
	}
	if (buttoncolor) {
		testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
		testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
		testCase.log(Status.PASS, "Correct Button Color");
	} else {
		testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
		testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
		testCase.log(Status.FAIL, "Wrong Button Color");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element border-color
	try {
	String ActualBorderColor = DeleteSbuUIPage.modal.getCssValue("border-colour");
	System.out.println("rgb :" + ActualBorderColor);

	String ExpectedBorderColor = "";

	boolean bordercolor = true;
	testCase = extent.createTest("005-MODAL-BORDER-COLOR");
	try {
		Assert.assertEquals(ActualBorderColor, ExpectedBorderColor);

	} catch (AssertionError e) {
		bordercolor = false;
	}
	if (bordercolor) {
		testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
		testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
		testCase.log(Status.PASS, "Correct Border Color");
	} else {
		testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
		testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
		testCase.log(Status.FAIL, "Wrong Border Color");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element overflow
	try {
	String ActualOverflow = DeleteSbuUIPage.modal.getCssValue("overflow");
	System.out.println("overflow :" + ActualOverflow);

	String ExpectedOverflow = "visible";

	boolean overflow = true;
	testCase = extent.createTest("006-MODAL-OVERFLOW-TYPE");
	try {
		Assert.assertEquals(ActualOverflow, ExpectedOverflow);

	} catch (AssertionError e) {
		overflow = false;
	}
	if (overflow) {
		testCase.log(Status.INFO, "ActualOverflow :- " + ActualOverflow);
		testCase.log(Status.INFO, "ExpectedOverflow :- " + ExpectedOverflow);
		testCase.log(Status.PASS, "Correct overflow");
	} else {
		testCase.log(Status.INFO, "ActualOverflow :- " + ActualOverflow);
		testCase.log(Status.INFO, "ExpectedOverflow :- " + ExpectedOverflow);
		testCase.log(Status.FAIL, "Wrong overflow");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	// ***** element margin
try {
	String ActualMargin = DeleteSbuUIPage.modal.getCssValue("margin");
	System.out.println("margin :" + ActualMargin);

	String ExpectedMargin = "0px 378px";

	boolean margin = true;
	testCase = extent.createTest("007-MODAL-MARGIN-TYPE");
	try {
		Assert.assertEquals(ActualMargin, ExpectedMargin);

	} catch (AssertionError e) {
		margin = false;
	}
	if (margin) {
		testCase.log(Status.INFO, "ActualMargin :- " + ActualMargin);
		testCase.log(Status.INFO, "ExpectedMargin :- " + ExpectedMargin);
		testCase.log(Status.PASS, "Correct Margin");
	} else {
		testCase.log(Status.INFO, "ActualMargin :- " + ActualMargin);
		testCase.log(Status.INFO, "ExpectedMargin :- " + ExpectedMargin);
		testCase.log(Status.FAIL, "Wrong Margin");
	}
}catch (Exception e) {
	testCase.log(Status.FAIL, "No Element");
}
	Thread.sleep(2000);

	// ***** element cursor
try {
	String ActualActions = DeleteSbuUIPage.modal.getCssValue("cursor");
	System.out.println("cursor :" + ActualActions);
	String ExpectedActions = "auto";

	boolean cursor = true;
	testCase = extent.createTest("008-MODAL-CURSOR-TYPE");
	try {
		Assert.assertEquals(ActualActions, ExpectedActions);

	} catch (AssertionError e) {
		cursor = false;
	}
	if (cursor) {
		testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
		testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
		testCase.log(Status.PASS, "correct cursor type");
	} else {
		testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
		testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
		testCase.log(Status.FAIL, "wrong cursor type");
	}
}catch (Exception e) {
	testCase.log(Status.FAIL, "No Element");
}
	Thread.sleep(2000);

	// ***** element z- index
try {
	String ActualZindex = DeleteSbuUIPage.modal.getCssValue("z-index");
	System.out.println("z-index :" + ActualZindex);
	String ExpectedZindex = "auto";

	boolean z_index = true;
	testCase = extent.createTest("009-MODAL-Z-INDEX-TYPE");
	try {
		Assert.assertEquals(ActualZindex, ExpectedZindex);

	} catch (AssertionError e) {
		z_index = false;
	}
	if (z_index) {
		testCase.log(Status.INFO, "ActualZindex :- " + ActualZindex);
		testCase.log(Status.INFO, "ExpectedZ-index :- " + ExpectedZindex);
		testCase.log(Status.PASS, "correct z-index  type");
	} else {
		testCase.log(Status.INFO, "ActualZindex :- " + ActualZindex);
		testCase.log(Status.INFO, "ExpectedZ-index :- " + ExpectedZindex);
		testCase.log(Status.FAIL, "wrong z-index type");
	}
}catch (Exception e) {
	testCase.log(Status.FAIL, "No Element");
}
	Thread.sleep(2000);

	// ***** click-on element

	// identify modal header

//	String modalActual = DeleteSbuUIPage.modal.getText();
//	System.out.println("Modal Dialog header: " + modalActual);
//
//	String modalExpected = "Add Plant";
//
//	boolean modalHeader = true;
//	testCase = extent.createTest("010-MODAL-HEADER");
//	try {
//		Assert.assertEquals(modalActual, modalExpected);
//
//	} catch (AssertionError e) {
//		modalHeader = false;
//	}
//	if (modalHeader) {
//		testCase.log(Status.INFO, "modalActual :- " + modalActual);
//		testCase.log(Status.INFO, "modalExpected :- " + ExpectedZindex);
//		testCase.log(Status.PASS, "correct modal header");
//	} else {
//		testCase.log(Status.INFO, "modalActual :- " + modalActual);
//		testCase.log(Status.INFO, "modalExpected :- " + ExpectedZindex);
//		testCase.log(Status.FAIL, "wrong modal header");
//	}
//	Thread.sleep(2000);
	

	// identify modal content
	try {
	String ActualmodalContent= DeleteSbuUIPage.modal.getText();
	System.out.println("content"  +  ActualmodalContent);
	String ExpectedModalContent = "* Code:"+"\n"+"* Plant:"+"\n"+"Address:"+"\n"+"Contact No:"+"\n"+"Fax:"+"\n"+"* Sub Business Unit:"+"\n"+"Description:";

	boolean modalContent = true;
	testCase = extent.createTest("011-MODAL-CONTENT");
	try {
		Assert.assertEquals(ActualmodalContent, ExpectedModalContent);

	} catch (AssertionError e) {
		modalContent = false;
	}
	if (modalContent) {
		testCase.log(Status.INFO, "modalActualContent :- " + ActualmodalContent);
		testCase.log(Status.INFO, "modalExpectedcontent :- " + ExpectedModalContent);
		testCase.log(Status.PASS, "correct modal content");
	} else {
		testCase.log(Status.INFO, "modalActualContent :- " + ActualmodalContent);
		testCase.log(Status.INFO, "modalExpectedcontent :- " + ExpectedModalContent);
		testCase.log(Status.FAIL, "wrong modal content");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);

	//  click on inside of modal
	try {
	DeleteSbuUIPage.modal.click();
	Thread.sleep(2000);
	
	boolean AcctualAfterClickinside = DeleteSbuUIPage.modal.isDisplayed();
	boolean ExpectedAfterClickinside= true;
	
	boolean elementvisibleafterclickinside = true;
	testCase = extent.createTest("012-MODAL-INVISIBLE-ONCLICK-INSIDE");
	try {
		Assert.assertEquals(AcctualAfterClickinside, ExpectedAfterClickinside);
	} catch (AssertionError e) {
		elementvisibleafterclickinside = false;
	}
	if (elementvisibleafterclickinside) {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClickinside);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClickinside);
		
		testCase.log(Status.PASS, "Modal visible ");
	} else {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClickinside);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClickinside);
		
		testCase.log(Status.FAIL, "Modal invisible");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);
//	//TextBox Length
//	DeleteSbuUIPage.modal.sendKeys("123456789");
//	String text = DeleteSbuUIPage.modal.getAttribute("value");
//	int ActualtextLength = text.length();
//	int ExpectedtextLength = 9;
//	testCase = extent.createTest("TEXT-BOX-LENGTH");
//	try {
//		Assert.assertEquals(ActualtextLength, ExpectedtextLength);
//		testCase.log(Status.INFO, "Actual Length :- " + ActualtextLength);
//		testCase.log(Status.INFO, "Expected Length :- " + ExpectedtextLength);
//		testCase.log(Status.PASS, "Correct Length  ");
//	} catch (AssertionError e) {
//		testCase.log(Status.INFO, "Actual Length :- " + ActualtextLength);
//		testCase.log(Status.INFO, "Expected Length :- " + ExpectedtextLength);
//		testCase.log(Status.FAIL, "Wrong Length  ");
//	}
	
	//  click on outside of modal
	try {
	Actions action = new Actions(driver);
    action.moveByOffset(0, 0).click().build().perform();
    
	boolean AcctualAfterClick = DeleteSbuUIPage.modal.isDisplayed();
	boolean ExpectedAfterClick= true;
	
	boolean elementvisibleafterclick = false;
	testCase = extent.createTest("013-MODAL-INVISIBLE-ONCLICK-OUTSIDE");
	try {
		Assert.assertEquals(AcctualAfterClick, ExpectedAfterClick);
	} catch (AssertionError e) {
		elementvisibleafterclick = true;
	}
	if (elementvisibleafterclick) {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);
		
		testCase.log(Status.FAIL, "Modal visible ");
	} else {
		testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
		testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);
		
		testCase.log(Status.PASS, "Modal invisible");
	}
	}catch (Exception e) {
		testCase.log(Status.FAIL, "No Element");
	}
	Thread.sleep(2000);
	}
	
}