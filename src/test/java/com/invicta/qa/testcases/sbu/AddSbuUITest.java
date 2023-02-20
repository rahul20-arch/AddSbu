package com.invicta.qa.testcases.sbu;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;

public class AddSbuUITest extends DriverIntialization {
	

	// STEP-1 ADD-SBU UI METHOD
	public static void addsbubutton() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.SBUbutton.isEnabled()) {

				// button enabled

				boolean ActualImageDisplay = AddSbuFunPage.SBUbutton.isDisplayed();
				boolean ExpectedImageDisplay = true;
				testCase = extent.createTest("ADD-SBU-BUTTON-ENABLED");
				try {
					Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				// CHEKC THE CLICKABILITY

				boolean clickable = AddSbuFunPage.SBUbutton.isDisplayed();

				String originalURL = driver.getCurrentUrl();
				String originalPageSource = driver.getPageSource();

				AddSbuFunPage.SBUbutton.click();
				System.out.println("Element is clicked");

				String updatedURL = driver.getCurrentUrl();
				String updatedPageSource = driver.getPageSource();

				if (!originalURL.equals(updatedURL) || !originalPageSource.equals(updatedPageSource)) {

					System.out.println("Changes have happened on the page");

					clickable = true;
				}

				else {

					System.out.println("No changes have happened on the page");
				}

				boolean clickable1 = true;

				testCase = extent.createTest("BUTTON-CLICKABLE");
				try {
					AssertJUnit.assertEquals(String.valueOf(clickable), "true");
					// System.out.println(String.valueOf(clickable));

				} catch (AssertionError e) {
					clickable1 = false;
				}
				if (clickable1) {
					testCase.log(Status.INFO, "ActualClick :- " + String.valueOf(clickable));
					testCase.log(Status.INFO, "ExpectedClick :- " + "true");

					testCase.log(Status.PASS, "Clickable");
				} else {
					testCase.log(Status.INFO, "ActualClick  :- " + String.valueOf(clickable));
					testCase.log(Status.INFO, "ExpectedClick :- " + "true");

					testCase.log(Status.FAIL, "Not clickable");
				}

			} else {
				testCase = extent.createTest("ADD-SBU-BUTTON-NOT-ENABLED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("lOGIN-BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		// ****************** Add SBU Button

		// Add SBU Button Text Visible

		try {
			boolean ExpectedTextVisible = true;
			System.out.println("IsVisible");
			boolean ActualTextVisible = AddSbuFunPage.SBUbutton.isDisplayed();
			testCase = extent.createTest("1-ADD-SBU-VISIBLE");
			try {
				Assert.assertEquals(ActualTextVisible, ExpectedTextVisible);
				testCase.log(Status.INFO, "Actual Visible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.PASS, " Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualVisible :- " + ActualTextVisible);
				testCase.log(Status.INFO, "Expected Visible :- " + ExpectedTextVisible);
				testCase.log(Status.FAIL, "Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("1-ADD-SBU-VISIBLE");
			testCase.log(Status.FAIL, "No element");
		}

		// Add SBU Button FONT COLOR

		try {
			String ActualTitleFontColor = AddSbuFunPage.SBUbutton.getCssValue("color");
			System.out.println("Font color of button: " + ActualTitleFontColor);
			String ExpectedTitleFontColor = "rgba(255, 255, 255, 1)";
			testCase = extent.createTest("2.ADD-SBU-FONT-COLOUR");

			try {
				AssertJUnit.assertEquals(ActualTitleFontColor, ExpectedTitleFontColor);
				testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
				testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
				testCase.log(Status.INFO, "Correct font Colour");
				testCase.log(Status.PASS, "Correct font Colour");

			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualColour :- " + ActualTitleFontColor);
				testCase.log(Status.INFO, "ExpectedColour :- " + ExpectedTitleFontColor);
				testCase.log(Status.INFO, "wrong font Colour");
				testCase.log(Status.FAIL, "wrong font Colour");
			}
		} catch (Exception e) {
			testCase = extent.createTest("2.ADD SBU-FONT-COLOUR");
			testCase.log(Status.FAIL, "No element");
		}

		// Add SBU Button FONTSIZE

		try {
			String ActualTitleFontsSize = AddSbuFunPage.SBUbutton.getCssValue("font-size");
			System.out.println("Font Size: " + ActualTitleFontsSize);
			String ExpectedTitleFontsSize = "14px";
			testCase = extent.createTest("3.ADD SBU-FONT- SIZE");
			try {
				AssertJUnit.assertEquals(ActualTitleFontsSize, ExpectedTitleFontsSize);
				testCase.log(Status.INFO, "ActualfontSize :-" + ActualTitleFontsSize);
				testCase.log(Status.INFO, "ExpectedfontSize:-" + ExpectedTitleFontsSize);
				testCase.log(Status.PASS, "Correct font-size");
				testCase.log(Status.PASS, " Font-size Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualfontsSize :- " + ActualTitleFontsSize);
				testCase.log(Status.INFO, "ExpectedfontsSize :- " + ExpectedTitleFontsSize);
				testCase.log(Status.INFO, "Wrong font-size");
				testCase.log(Status.FAIL, "Font-size Wrong");

			}
		} catch (Exception e) {
			testCase = extent.createTest("3.ADD SBU FONT- SIZE");
			testCase.log(Status.FAIL, "No Element");
		}

		// Add SBU Button Font Family

		try {
			String ActualElementfamily = AddSbuFunPage.SBUbutton.getCssValue("font-family");
			System.out.println("FONT-FAMILY: " + ActualElementfamily);
			String ExpectedElementFamily = "Roboto, sans-serif";
			testCase = extent.createTest("4.ADD-SBU-FONT-FAMILY");
			try {
				Assert.assertEquals(ActualElementfamily, ExpectedElementFamily);
				testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
				testCase.log(Status.PASS, "Correct Text");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualText :- " + ActualElementfamily);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedElementFamily);
				testCase.log(Status.FAIL, "wrong Text");
			}
		} catch (Exception e) {
			testCase = extent.createTest("4.FONT-FAMILY");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		// Add SBU Button Spelling

		try {
			String AcctualTitleText = AddSbuFunPage.SBUbutton.getText();
			String ExpectedTitleText = "Add SBU";
			System.out.println(" Text:" + AcctualTitleText);
			testCase = extent.createTest("5.ADD-SBU-SPELLING-TEXT");
			try {

				testCase.log(Status.INFO, "AcctualText :- " + AcctualTitleText);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedTitleText);

				testCase.log(Status.PASS, "Correct element");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "AcctualText :- " + AcctualTitleText);
				testCase.log(Status.INFO, "ExpectedText :- " + ExpectedTitleText);

				testCase.log(Status.FAIL, "Wrong Element");
			}
		} catch (Exception find9) {
			testCase = extent.createTest("5.ADD-SBU-SPELLING-TEXT");
			testCase.log(Status.FAIL, "No Element");
		}

		// Add SBU Button Position

		try {
			Point ActulalLocation = AddSbuFunPage.SBUbutton.getLocation();
			int actual_x = ActulalLocation.getX();
			int actual_y = ActulalLocation.getY();
			System.out.println("X axis: " + actual_x);
			System.out.println("Y axis: " + actual_y);
			Point ExpectedLocation = new Point(588, 93);

			testCase = extent.createTest("6.ADD-SBU-BUTTON-POSITION");
			try {
				AssertJUnit.assertEquals(ActulalLocation, ExpectedLocation);
				testCase.log(Status.INFO, "ActualFontSize :- " + ActulalLocation);
				testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
				testCase.log(Status.PASS, "Correct Location");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualSize :- " + ActulalLocation);
				testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
				testCase.log(Status.FAIL, "Wrong Location");
			}
		} catch (Exception e) {
			testCase = extent.createTest("6.ADD-SBU-POSITION");
			testCase.log(Status.FAIL, "NO ELEMENT");

		}

		// Add SBU Button Padding

		try {
			String Actualpadding = AddSbuFunPage.SBUbutton.getCssValue("padding");
			System.out.println("PADDING: " + Actualpadding);
			String Expectedpadding = "4px 15px";
			testCase = extent.createTest("7.ADD-SBU-TEXT PADDING");
			try {
				Assert.assertEquals(Actualpadding, Expectedpadding);
				testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
				testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
				testCase.log(Status.PASS, "padding is Correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
				testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
				testCase.log(Status.FAIL, "padding is Wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("7.ADD-SBU-PADDING");
			testCase.log(Status.FAIL, "NO ELEMENT");
		}

		// Add SBU Button Shadow

		try {
			String Actualshadow = AddSbuFunPage.SBUbutton.getCssValue("box-shadow");
			System.out.println("Text Shadow :" + Actualshadow);
			String ExpectedShadow = "rgba(0, 0, 0, 0.016) 0px 2px 0px 0px";
			testCase = extent.createTest("8.ADD-SBU-BOX-SHADOW");
			try {
				AssertJUnit.assertEquals(Actualshadow, ExpectedShadow);
				testCase.log(Status.INFO, "ActualShadow :- " + Actualshadow);
				testCase.log(Status.INFO, "ExpectedShadow :- " + ExpectedShadow);
				testCase.log(Status.PASS, "Shadow available");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualShadow :- " + Actualshadow);
				testCase.log(Status.INFO, "ExpectedShadow :- " + ExpectedShadow);
				testCase.log(Status.FAIL, "Shadow not available");
			}
		} catch (Exception find6) {
			testCase = extent.createTest("8.ADD-SBU-BOX-SHADOW");
			testCase.log(Status.FAIL, "No Element");
		}

		// Add SBU Button BACKGROUND COLOR

		try {
			String Actualbackground = AddSbuFunPage.SBUbutton.getCssValue("color");
			System.out.println("BACKGROUND COLOR:" + Actualbackground);
			String Expectedbackground = "rgba(255, 255, 255, 1)";

			testCase = extent.createTest("9.ADD-SBU-BACKGROUND COLOR");
			try {
				AssertJUnit.assertEquals(Actualbackground, Expectedbackground);

				testCase.log(Status.INFO, "Actualbackgroundcolor :- " + Actualbackground);
				testCase.log(Status.INFO, "Expectedbackgroundcolor :- " + Expectedbackground);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualbackgroundcolor :- " + Actualbackground);
				testCase.log(Status.INFO, "Expectedbackgroundcolor:- " + Expectedbackground);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("9.ADD-SBU-BACKGROUND COLOR");
		}

		// Add SBU Button BORDER COLOR

		try {
			String actualbordercolor = AddSbuFunPage.SBUbutton.getCssValue("border-color");
			System.out.println(" border-color:" + actualbordercolor);
			String Expectedbordercolor = "rgb(255, 255, 255)";
			testCase = extent.createTest("10.ADD-SBU-BORDER-COLOR");
			try {
				AssertJUnit.assertEquals(actualbordercolor, Expectedbordercolor);
				testCase.log(Status.INFO, "Actualbordercolor :- " + actualbordercolor);
				testCase.log(Status.INFO, "Expectedbordercolor :- " + Expectedbordercolor);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				// TODO: handle exception
			}
			{
				testCase.log(Status.INFO, "Actualbordercolor :- " + actualbordercolor);
				testCase.log(Status.INFO, "Expectedbordercolor :- " + Expectedbordercolor);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "NO ELEMENT");
			testCase = extent.createTest("10.ADD-SBU-BORDER-COLOR");
		}

		// Add SBU Button CURSER POINT

		try {
			String ActualCursor = AddSbuFunPage.SBUbutton.getCssValue("cursor");
			System.out.println("cursor :" + ActualCursor);
			String Expectedcursor = "pointer";
			testCase = extent.createTest("11.ADD-SBU-CURSOR");
			try {
				AssertJUnit.assertEquals(ActualCursor, Expectedcursor);
				testCase.log(Status.INFO, "ActualCursor :- " + ActualCursor);
				testCase.log(Status.INFO, "ActualCursor:- " + Expectedcursor);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualCursor :- " + ActualCursor);
				testCase.log(Status.INFO, "ActualCursor :- " + Expectedcursor);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("11.ADD-SBU-CURSOR");
		}

		// Add SBU Button OPACITY

		try {
			String Actualopacity = AddSbuFunPage.SBUbutton.getCssValue("opacity");
			System.out.println("OPACITY :" + Actualopacity);

			String Expectedopacity = "1";
			testCase = extent.createTest("12.ADD-SBU-OPACITY");
			try {
				AssertJUnit.assertEquals(Actualopacity, Expectedopacity);
				testCase.log(Status.INFO, "ActualTextTransformation :- " + Actualopacity);
				testCase.log(Status.INFO, "ExpectedTextTransformation :- " + Expectedopacity);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualTextTransformation :- " + Actualopacity);
				testCase.log(Status.INFO, "ExpectedTextTransformation :- " + Expectedopacity);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("12.ADD-SBU-OPACITY");
			testCase.log(Status.FAIL, "No Element");
		}

		// Add SBU Button HEIGHT

		try {
			String ActualHeight = AddSbuFunPage.SBUbutton.getCssValue("height");
			System.out.println("Height :" + ActualHeight);
			String ExpectedHeight = "32px";
			testCase = extent.createTest("13.ADD-SBU-HEIGHT");
			try {
				AssertJUnit.assertEquals(ActualHeight, ExpectedHeight);
				testCase.log(Status.INFO, "ActualLineHeight :- " + ActualHeight);
				testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedHeight);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "ActualLineHeight :- " + ActualHeight);
				testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedHeight);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("13.ADD-SBU-HEIGHT");
			testCase.log(Status.FAIL, "No element");
		}

		// Add SBU Button WIDTH

		try {
			String Actualwidth = AddSbuFunPage.SBUbutton.getCssValue("width");
			System.out.println("width :" + Actualwidth);

			String Expectedwidth = "180px";
			testCase = extent.createTest("14.ADD-SBU-WIDTH");
			try {
				AssertJUnit.assertEquals(Actualwidth, Expectedwidth);
				testCase.log(Status.INFO, "Actualwidth :- " + Actualwidth);
				testCase.log(Status.INFO, "Expectedwidth  :- " + Expectedwidth);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualwidth  :- " + Actualwidth);
				testCase.log(Status.INFO, "Expectedwidth  :- " + Expectedwidth);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase = extent.createTest("14.ADD-SBU-WIDTH");
			testCase.log(Status.FAIL, "No element");
		}

		// Add SBU Button Font-weight

		try {
			String Actualweight = AddSbuFunPage.SBUbutton.getCssValue("font-weight");
			System.out.println("16.Font-weight :" + Actualweight);
			String Expectedweight = "400";
			testCase = extent.createTest("15.ADD-SBU-FONT-WEIGHT");
			try {
				AssertJUnit.assertEquals(Actualweight, Expectedweight);
				testCase.log(Status.INFO, "Actualfontweight :- " + Actualweight);
				testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
				testCase.log(Status.PASS, "correct");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actualfontweight :- " + Actualweight);
				testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedweight);
				testCase.log(Status.FAIL, "wrong");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "No Element");
			testCase = extent.createTest("15.ADD-SBU-FONT-WEIGHT");
		}

		System.out.println();
	}
	
	// METHOD-2 -- ADD-SBU BUTTON CLICK METHOD(FUNCTIONAL)
		public static void addsbuclick() throws InterruptedException {
			// AddSbuFunPage AddFunPg = new AddSbuFunPage();
			 Thread.sleep(3000);
			//AddSbuFunPage.SBUbutton.click();
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

	//**************************************************************
//STEP-3 THIS METHOD IS FOR MODAL(UI)
		public static void addsbumodal() throws InterruptedException  
		{		
			//Model Window visible 
		 			Thread.sleep(2000);
				
					boolean AcctualVisible = AddSbuFunPage.addsbumodel.isDisplayed();
					boolean ExpectedVisible = true;

					testCase = extent.createTest("001-Model-Window-Visible");
					try {
						AssertJUnit.assertEquals(AcctualVisible, ExpectedVisible);
						testCase.log(Status.INFO, "ActualElement :- " + AcctualVisible);
						testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisible);
						testCase.log(Status.INFO, "Element Available");
						testCase.log(Status.PASS, "Correct element");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualElement :- " + AcctualVisible);
						testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedVisible);
						testCase.log(Status.INFO, "Element not available");
						testCase.log(Status.FAIL, "No Element");
					}
					
					Thread.sleep(2000);

		// Model Window position 

					Point ActualLocation = AddSbuFunPage.addsbumodel.getLocation();

					int actual_x = ActualLocation.getX();
					int actual_y = ActualLocation.getY();

					System.out.println("X axis: " + actual_x);
					System.out.println("Y axis: " + actual_y);

					Point ExpectedLocation = new Point(383, 100);

					testCase = extent.createTest("002-MODAL-POSITION");
					try {
						AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);
						testCase.log(Status.INFO, "ActualFontSize :- " + ActualLocation);
						testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedLocation);
						testCase.log(Status.PASS, "Correct Location");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualSize :- " + ActualLocation);
						testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedLocation);
						testCase.log(Status.FAIL, "Wrong Location");
					}
					
					Thread.sleep(2000);

		//Model Window size

					Dimension ActualSize = AddSbuFunPage.addsbumodel.getSize();
					System.out.println("Size : " + ActualSize);
					Dimension ExpectedSize = new Dimension(600, 230);

					testCase = extent.createTest("003-MODAL-SIZE");
					try {
						AssertJUnit.assertEquals(ActualSize, ExpectedSize);
						testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
						testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
						testCase.log(Status.PASS, "Correcrt size");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
						testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
						testCase.log(Status.FAIL, "Wrong Size");
					}
				
					Thread.sleep(2000);

		// Model Window background-color

					String ActualButtonColor = AddSbuFunPage.addsbumodel.getCssValue("background-color");
					System.out.println("rgb :" + ActualButtonColor);
					String ExpectedButtonColor = "rgba(255, 255, 255, 1)";

					testCase = extent.createTest("004-MODAL-BACKGROUND-COLOR");
					try {
						AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);
						testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
						testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
						testCase.log(Status.PASS, "Correct Button Color");

					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualButtonColor :- " + ActualButtonColor);
						testCase.log(Status.INFO, "ExpectedButtonColor :- " + ExpectedButtonColor);
						testCase.log(Status.FAIL, "Wrong Button Color");
					}
					
					Thread.sleep(2000);

		// Model Window border-color
					
					String ActualBorderColor = AddSbuFunPage.addsbumodel.getCssValue("border-color");
					System.out.println("rgb :" + ActualBorderColor);
					String ExpectedBorderColor = "rgba(0, 0, 0, 0.85)";

					testCase = extent.createTest("005-MODAL-BORDER-COLOR");
					try {
						AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);
						testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
						testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
						testCase.log(Status.PASS, "Correct Border Color");

					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualBorderColor :- " + ActualBorderColor);
						testCase.log(Status.INFO, "ExpectedBorderColor :- " + ExpectedBorderColor);
						testCase.log(Status.FAIL, "Wrong Border Color");
					}
					
					Thread.sleep(2000);

		// Model Window overflow

					String ActualOverflow = AddSbuFunPage.addsbumodel.getCssValue("overflow");
					System.out.println("overflow :" + ActualOverflow);
					String ExpectedOverflow = "visible";

					testCase = extent.createTest("006-MODAL-OVERFLOW-TYPE");
					try {
						AssertJUnit.assertEquals(ActualOverflow, ExpectedOverflow);
						testCase.log(Status.INFO, "ActualOverflow :- " + ActualOverflow);
						testCase.log(Status.INFO, "ExpectedOverflow :- " + ExpectedOverflow);
						testCase.log(Status.PASS, "Correct overflow");

					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualOverflow :- " + ActualOverflow);
						testCase.log(Status.INFO, "ExpectedOverflow :- " + ExpectedOverflow);
						testCase.log(Status.FAIL, "Wrong overflow");
					}
				
					Thread.sleep(2000);

		// Model element margin

					String ActualMargin = AddSbuFunPage.addsbumodel.getCssValue("margin");
					System.out.println("margin :" + ActualMargin);
					String ExpectedMargin = "0px";

					testCase = extent.createTest("007-MODAL-MARGIN-TYPE");
					try {
						AssertJUnit.assertEquals(ActualMargin, ExpectedMargin);
						testCase.log(Status.INFO, "ActualMargin :- " + ActualMargin);
						testCase.log(Status.INFO, "ExpectedMargin :- " + ExpectedMargin);
						testCase.log(Status.PASS, "Correct Margin");

					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualMargin :- " + ActualMargin);
						testCase.log(Status.INFO, "ExpectedMargin :- " + ExpectedMargin);
						testCase.log(Status.FAIL, "Wrong Margin");
					}
					
					Thread.sleep(2000);

		// ***** element cursor

					String ActualActions = AddSbuFunPage.addsbumodel.getCssValue("cursor");
					System.out.println("cursor :" + ActualActions);
					String ExpectedActions = "auto";

					testCase = extent.createTest("008-MODAL-CURSOR-TYPE");
					try {
						AssertJUnit.assertEquals(ActualActions, ExpectedActions);
						testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
						testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
						testCase.log(Status.PASS, "correct cursor type");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
						testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
						testCase.log(Status.FAIL, "wrong cursor type");
					}
					
					Thread.sleep(2000);

		// ***** element z-index

					String ActualZindex = AddSbuFunPage.addsbumodel.getCssValue("z-index");
					System.out.println("z-index :" + ActualZindex);
					String ExpectedZindex = "auto";

					testCase = extent.createTest("009-MODAL-Z-INDEX-TYPE");
					try {
						AssertJUnit.assertEquals(ActualZindex, ExpectedZindex);
						testCase.log(Status.INFO, "ActualZindex :- " + ActualZindex);
						testCase.log(Status.INFO, "ExpectedZ-index :- " + ExpectedZindex);
						testCase.log(Status.PASS, "correct z-index  type");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "ActualZindex :- " + ActualZindex);
						testCase.log(Status.INFO, "ExpectedZ-index :- " + ExpectedZindex);
						testCase.log(Status.FAIL, "wrong z-index type");
					}
					
					Thread.sleep(2000);
		}
					
//		//  click on outside of modal
//					
//					Actions action = new Actions(driver);
//			        action.moveByOffset(0, 0).click().build().perform();
//			    	boolean AcctualAfterClick = AddSbuFunPage.addsbumodel.isDisplayed();
//					boolean ExpectedAfterClick = true;
//					
//					testCase = extent.createTest("010-MODAL-INVISIBLE-ONCLICK-OUTSIDE");
//					try {
//						AssertJUnit.assertEquals(AcctualAfterClick, ExpectedAfterClick);
//						testCase.log(Status.INFO, "ActualElement :- " + AcctualAfterClick);
//						testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);
//						testCase.log(Status.FAIL, "Modal visible ");
//					} catch (AssertionError e) {
//						testCase.log(Status.INFO, "ActualElement :- " + AcctualVisible);
//						testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedAfterClick);
//						testCase.log(Status.PASS, "Modal invisible");
//					}
//					
//					Thread.sleep(2000); 
//					
//				}
//******************************************************************************************************************

	// STEP-4 THIS METHOD IS FOR TEXT(INSIDE MODAL)
	
	public static void addsbutext() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.AddSBUtext.isDisplayed()) {

//								Text Displayed

				boolean ActualTextDisplay = AddSbuFunPage.AddSBUtext.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("ADD-SBU-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuFunPage.AddSBUtext.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuFunPage.AddSBUtext.getCssValue("font-size");

				String Expectedtextsize = "16px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuFunPage.AddSBUtext.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuFunPage.AddSBUtext.getText();

				String Expectedtext = "Add SBU";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("ADD-SBU-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuFunPage.AddSBUtext.getCssValue("font-family");

				String Expectedfontfamily = "Roboto, sans-serif";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuFunPage.AddSBUtext.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(397, 106);

				testCase = extent.createTest("ADD-SBU-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuFunPage.AddSBUtext.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("ADD-SBU-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuFunPage.AddSBUtext.getCssValue("margin");

				String Expectedmargin = "0px 0px 16px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("ADD-SBU-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuFunPage.AddSBUtext.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("ADD-SUB-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuFunPage.AddSBUtext.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("ADD-SBU-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

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

				String ActualWordSpacing = AddSbuFunPage.AddSBUtext.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("ADD-SBU-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

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

				String ActualAlignment = AddSbuFunPage.AddSBUtext.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "start";

				boolean alignment = true;
				testCase = extent.createTest("ADD-SBU-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

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

				String ActualTextTransformation = AddSbuFunPage.AddSBUtext.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("ADD-SBU-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuFunPage.AddSBUtext.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22px";

				boolean lineheight = true;
				testCase = extent.createTest("ADD-SBU-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

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

				// Text Decoration

				String ActualTextDecoration = AddSbuFunPage.AddSBUtext.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(255, 255, 255)";

				boolean textdecoration = true;
				testCase = extent.createTest("ADD-SBU-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

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

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuFunPage.AddSBUtext.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("ADD-SBU-TEXT-VERTICAL-ALIGNMENT");
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
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuFunPage.AddSBUtext.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("ADD-SBU-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuFunPage.AddSBUtext.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("ADD-SBU-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

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
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("TEXT NOT DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}
	// STEP-6 -- THIS METHOD IS FOR ADD DATA
		public static void sbudata() throws IOException, InterruptedException {
			AddSbuFunPage AddSbuFunpg = new AddSbuFunPage();
			PageFactory.initElements(driver, AddSbuFunpg);

//			FileInputStream file = new FileInputStream(System.getProperty(
//					"C:\\Users\\hp\\eclipse-workspace\\QDMS-AUTOMATION\\src\\test\\java\\com\\invicta\\qa\\excel\\Data.xlsx"));
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			XSSFSheet sheet = workbook.getSheet("ADDSBU");
//
//			int rowcount = sheet.getLastRowNum();
//			for (int i = 0; i <= rowcount; i++) {
//
//				XSSFRow row = sheet.getRow(i);
//
//				String sbu = (String) row.getCell(0).getStringCellValue();
//				String description = (String) row.getCell(1).getStringCellValue();
//
//				Thread.sleep(2000);
//				AddSbuFunPage.SBUtext.sendKeys(sbu);
//				AddSbuFunPage.SBUdestext.sendKeys(description);
//
//				AddSbuFunPage.SBUsavebutton.click();
AddSbuFunPage.SBUtext.sendKeys("testing");
AddSbuFunPage.SBUdestext.sendKeys("this is description");
			}

//		}

//*********************************************************************************************************

	//STEP-7 THIS METHOD IS FOR ADD-SBU-TEXT
	
	public static void sbutext() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.SBUText.isDisplayed()) {

//								Text Displayed

				boolean ActualTextDisplay = AddSbuFunPage.SBUText.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("SBU-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuFunPage.SBUText.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("SBU-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuFunPage.SBUText.getCssValue("font-size");

				String Expectedtextsize = "14px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("SBU-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuFunPage.SBUText.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("SBU-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuFunPage.SBUText.getText();

				String Expectedtext = "Sub Business Unit:";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("SBU-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuFunPage.SBUText.getCssValue("font-family");

				String Expectedfontfamily = "Roboto";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("SBU-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuFunPage.SBUText.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(417, 167);

				testCase = extent.createTest("SBU-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuFunPage.SBUText.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("SBU-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuFunPage.SBUText.getCssValue("margin");

				String Expectedmargin = "0px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("SBU-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuFunPage.SBUText.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("SBU-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuFunPage.SBUText.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("SBU-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

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

				String ActualWordSpacing = AddSbuFunPage.SBUText.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("SBU-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

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

				String ActualAlignment = AddSbuFunPage.SBUText.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "left";

				boolean alignment = true;
				testCase = extent.createTest("SBU-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

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

				String ActualTextTransformation = AddSbuFunPage.SBUText.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("SBU-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuFunPage.SBUText.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22.001px";

				boolean lineheight = true;
				testCase = extent.createTest("SBU-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

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

				// Text Decoration

				String ActualTextDecoration = AddSbuFunPage.SBUText.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(142, 142, 142)";

				boolean textdecoration = true;
				testCase = extent.createTest("SBU-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

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

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuFunPage.SBUText.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("SBU-TEXT-VERTICAL-ALIGNMENT");
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
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuFunPage.SBUText.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("SBU-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuFunPage.SBUText.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("SUB-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

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
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("SUB-TEXT-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}
//***************************************************************************************
	//STEP-8 THIS METHOD IS FOR DESCRIPTION TEXT 
	
	public static void description() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.DescriptionText.isDisplayed()) {

//								Text Displayed

				boolean ActualTextDisplay = AddSbuFunPage.DescriptionText.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuFunPage.DescriptionText.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuFunPage.DescriptionText.getCssValue("font-size");

				String Expectedtextsize = "14px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuFunPage.DescriptionText.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuFunPage.DescriptionText.getText();

				String Expectedtext = "Description:";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("DESCRIPTION-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuFunPage.DescriptionText.getCssValue("font-family");

				String Expectedfontfamily = "Roboto";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuFunPage.DescriptionText.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(693, 167);

				testCase = extent.createTest("DESCRIPTION-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuFunPage.DescriptionText.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("DESCRIPTION-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuFunPage.DescriptionText.getCssValue("margin");

				String Expectedmargin = "0px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("DESCRIPTION-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuFunPage.DescriptionText.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("DESCRIPTION-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuFunPage.DescriptionText.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

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

				String ActualWordSpacing = AddSbuFunPage.DescriptionText.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

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

				String ActualAlignment = AddSbuFunPage.DescriptionText.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "left";

				boolean alignment = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

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

				String ActualTextTransformation = AddSbuFunPage.DescriptionText.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuFunPage.DescriptionText.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22.001px";

				boolean lineheight = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

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

				// Text Decoration

				String ActualTextDecoration = AddSbuFunPage.DescriptionText.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(142, 142, 142)";

				boolean textdecoration = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

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

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuFunPage.DescriptionText.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-VERTICAL-ALIGNMENT");
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
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuFunPage.DescriptionText.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuFunPage.DescriptionText.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

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
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("TEXT IS NOT DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}

	//STEP-4  THIS METHOD IS FOR TEXTBOX
	
	public static void sbutextbox() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.SBUtextbox.isDisplayed()) {

//							button Displayed

				boolean ActualbiuttonDisplay = AddSbuFunPage.SBUtextbox.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				testCase = extent.createTest("SUB-TEXTBOX-DISPLAYED");
				try {
					Assert.assertEquals(ActualbiuttonDisplay, ExpectedbuttonDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				try {
					if (AddSbuFunPage.SBUtextbox.isEnabled()) {

//									button enabled

						boolean ActualImageDisplay = AddSbuFunPage.SBUtextbox.isEnabled();
						boolean ExpectedImageDisplay = true;
						testCase = extent.createTest("SBU-TEXTBOX-ENABLED");
						try {
							Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.PASS, " Image Displayed is Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.FAIL, " Image Displayed is Wrong");
						}

						// Check Image Position
						Point ExpectedImageLocation = new Point(417, 189);
						Point actualImageLocation = AddSbuFunPage.SBUtextbox.getLocation();
						System.out.println("Position :" + actualImageLocation);
						testCase = extent.createTest("SBU-TEXTBOX-POSITION");
						try {
							Thread.sleep(1000);
							Assert.assertEquals(actualImageLocation, ExpectedImageLocation);
							Thread.sleep(3000);
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Correct Image Position");
							testCase.log(Status.PASS, " Image Position Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Wrong  Image Position");
							testCase.log(Status.FAIL, " Image Position Wrong");
						}

						// CHECK BACKGROUND COLOR

						String Actualbgcolor = AddSbuFunPage.SBUtextbox.getCssValue("background-color");

						String Expectedbgcolour = "rgba(255, 255, 255, 1)";
						System.out.println("text :" + Actualbgcolor);
						testCase = extent.createTest("SBU-TEXTBOX-BACKGROUND-COLOUR");
						try {
							Assert.assertEquals(Actualbgcolor, Expectedbgcolour);
							testCase.log(Status.INFO, "Actual bg colur:- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.PASS, "Correct bg colur");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual bg colur :- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.FAIL, "wrong bg colur");
						}

						// text font color

						String Actualtextcolor = AddSbuFunPage.SBUtextbox.getCssValue("font-color");

						String Expectedtextcolor = "";
						System.out.println("font colour :" + Actualtextcolor);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-COLOUR");
						try {
							Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
							testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.PASS, "Correct font colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.FAIL, "wrong font colour");
						}

						// text font size

						String Actualtextsize = AddSbuFunPage.SBUtextbox.getCssValue("font-size");

						String Expectedtextsize = "14px";
						System.out.println("font size :" + Actualtextsize);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-SIZE");
						try {
							Assert.assertEquals(Actualtextsize, Expectedtextsize);
							testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.PASS, "Correct font size");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.FAIL, "wrong font size");
						}

						// text font style

						String Actualtextstyle = AddSbuFunPage.SBUtextbox.getCssValue("font-style");

						String Expectedtextstyle = "normal";
						System.out.println("font style :" + Actualtextstyle);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-STYLE");
						try {
							Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
							testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.PASS, "Correct font style");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.FAIL, "wrong font style");
						}

						// SIZE
						Dimension ActualSize = AddSbuFunPage.SBUtextbox.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(256, 32);

						boolean size = true;
						testCase = extent.createTest("SBU-TEXTBOX-SIZE");
						try {
							AssertJUnit.assertEquals(ActualSize, ExpectedSize);
						} catch (AssertionError e) {
							size = false;
						}
						if (size) {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "Correct Size");
							testCase.log(Status.PASS, "Correct Size");
						} else {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "wrong Size");
							testCase.log(Status.FAIL, "wrong Size");
						}
						Thread.sleep(2000);

						// BORDER COLOUR

						String Actualbordercolour = AddSbuFunPage.SBUtextbox.getCssValue("border-color");

						String Expectedbordercolour = "rgb(217, 217, 217)";
						System.out.println("font style :" + Actualbordercolour);
						testCase = extent.createTest("SBU-TEXTBOX-BORDER-COLOUR");
						try {
							Assert.assertEquals(Actualbordercolour, Expectedbordercolour);
							testCase.log(Status.INFO, "Actual border colour:- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.PASS, "Correct border colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual border colour :- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.FAIL, "wrong border colour");
						}

					} else {
						testCase = extent.createTest("SBU-TEXTBOX-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("SBU-TEXTBOX Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("SBU-TEXTBOX-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("SBU-TEXTBOX Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
		System.out.println();
	}

	//STEP-7 THIS METHOD IS FOR DESCRIPTION TEXT BOX
	
	public static void descriptiontextbox() throws InterruptedException {
		AddSbuFunPage sbuui = new AddSbuFunPage();
		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuFunPage.Descriptiontextbox.isDisplayed()) {

//							button Displayed

				boolean ActualbiuttonDisplay = AddSbuFunPage.Descriptiontextbox.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				testCase = extent.createTest("DESCRIPTION-TEXTBOX-DISPLAYED");
				try {
					Assert.assertEquals(ActualbiuttonDisplay, ExpectedbuttonDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				try {
					if (AddSbuFunPage.SBUtextbox.isEnabled()) {

//									button enabled

						boolean ActualImageDisplay = AddSbuFunPage.Descriptiontextbox.isEnabled();
						boolean ExpectedImageDisplay = true;
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-ENABLED");
						try {
							Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.PASS, " Image Displayed is Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.FAIL, " Image Displayed is Wrong");
						}

						// Check Image Position
						Point ExpectedImageLocation = new Point(693, 189);
						Point actualImageLocation = AddSbuFunPage.Descriptiontextbox.getLocation();
						System.out.println("Position :" + actualImageLocation);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-POSITION");
						try {
							Thread.sleep(1000);
							Assert.assertEquals(actualImageLocation, ExpectedImageLocation);
							Thread.sleep(3000);
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Correct Image Position");
							testCase.log(Status.PASS, " Image Position Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Wrong  Image Position");
							testCase.log(Status.FAIL, " Image Position Wrong");
						}

						// CHECK BACKGROUND COLOR

						String Actualbgcolor = AddSbuFunPage.Descriptiontextbox.getCssValue("background-color");

						String Expectedbgcolour = "rgba(255, 255, 255, 1)";
						System.out.println("text :" + Actualbgcolor);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-BACKGROUND-COLOUR");
						try {
							Assert.assertEquals(Actualbgcolor, Expectedbgcolour);
							testCase.log(Status.INFO, "Actual bg colur:- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.PASS, "Correct bg colur");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual bg colur :- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.FAIL, "wrong bg colur");
						}

						// text font color

						String Actualtextcolor = AddSbuFunPage.Descriptiontextbox.getCssValue("font-color");

						String Expectedtextcolor = "";
						System.out.println("font colour :" + Actualtextcolor);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-COLOUR");
						try {
							Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
							testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.PASS, "Correct font colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.FAIL, "wrong font colour");
						}

						// text font size

						String Actualtextsize = AddSbuFunPage.Descriptiontextbox.getCssValue("font-size");

						String Expectedtextsize = "14px";
						System.out.println("font size :" + Actualtextsize);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-SIZE");
						try {
							Assert.assertEquals(Actualtextsize, Expectedtextsize);
							testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.PASS, "Correct font size");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.FAIL, "wrong font size");
						}

						// text font style

						String Actualtextstyle = AddSbuFunPage.Descriptiontextbox.getCssValue("font-style");

						String Expectedtextstyle = "normal";
						System.out.println("font style :" + Actualtextstyle);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-STYLE");
						try {
							Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
							testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.PASS, "Correct font style");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.FAIL, "wrong font style");
						}

						// SIZE
						Dimension ActualSize = AddSbuFunPage.Descriptiontextbox.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(256, 32);

						boolean size = true;
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-SIZE");
						try {
							AssertJUnit.assertEquals(ActualSize, ExpectedSize);
						} catch (AssertionError e) {
							size = false;
						}
						if (size) {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "Correct Size");
							testCase.log(Status.PASS, "Correct Size");
						} else {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "wrong Size");
							testCase.log(Status.FAIL, "wrong Size");
						}
						Thread.sleep(2000);

						// BORDER COLOUR

						String Actualbordercolour = AddSbuFunPage.Descriptiontextbox.getCssValue("border-color");

						String Expectedbordercolour = "rgb(217, 217, 217)";
						System.out.println("font style :" + Actualbordercolour);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-BORDER-COLOUR");
						try {
							Assert.assertEquals(Actualbordercolour, Expectedbordercolour);
							testCase.log(Status.INFO, "Actual border colour:- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.PASS, "Correct border colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual border colour :- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.FAIL, "wrong border colour");
						}

					} else {
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("DESCRIPTION-TEXTBOX Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("DESCRIPTION-TEXTBOX-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("DESCRIPTION-TEXTBOX Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
		System.out.println();
	}
//	STEP-9  THIS METHOD IS FOR SAVE BUTTON PROPERTIES
	public static void SaveButtonUI() throws InterruptedException {
		// check if element visible

		boolean ActualElement = AddSbuFunPage.SBUsavebutton.isDisplayed();
		boolean ExpectedElement = true;

		boolean visibility = true;
		testCase = extent.createTest("ELEMENT-VISIBILITY");
		try {
			AssertJUnit.assertEquals(ActualElement, ExpectedElement);

		} catch (AssertionError e) {

			visibility = false;

//		        	  throw(e);

		}
		if (visibility) {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.PASS, "Correct Element");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + ActualElement);
			testCase.log(Status.INFO, "ExpectedElement :- " + ExpectedElement);
			testCase.log(Status.FAIL, "No element");

		}
		Thread.sleep(2000);

		// check position

		Point ActualLocation = AddSbuFunPage.SBUsavebutton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);

		Point ExpectedLocation = new Point(907, 288);

		boolean Position = true;
		testCase = extent.createTest("BUTTON-POSITION");
		try {
			AssertJUnit.assertEquals(ActualLocation, ExpectedLocation);

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
		Thread.sleep(2000);

//				 check font size

		String ActualFontSize = AddSbuFunPage.SBUsavebutton.getCssValue("font-size");
		System.out.println("Font Size: " + ActualFontSize);
		String ExpectedFontSize = "14px";

		boolean Fontsize = true;
		testCase = extent.createTest("FONT-SIZE");
		try {
			AssertJUnit.assertEquals(ActualFontSize, ExpectedFontSize);

		} catch (AssertionError e) {
			Fontsize = false;
		}
		if (Fontsize) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedFontSize);
			testCase.log(Status.PASS, "Correct Font Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualFontSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedFontSize);
			testCase.log(Status.FAIL, "Wrong Font Size");
		}
		Thread.sleep(2000);

//				 check the size 

		Dimension ActualSize = AddSbuFunPage.SBUsavebutton.getSize();
		System.out.println("Size : " + ActualSize);
		Dimension ExpectedSize = new Dimension(60, 32);

		boolean size = true;
		testCase = extent.createTest("BUTTON-SIZE");
		try {
			AssertJUnit.assertEquals(ActualSize, ExpectedSize);

		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.PASS, "Correct Size");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
			testCase.log(Status.FAIL, "Wrong Size");
		}
		Thread.sleep(2000);

//		            check the enable

		boolean ActualElementEnable = AddSbuFunPage.SBUsavebutton.isEnabled();
		boolean ExpectedElementEnable = true;

		boolean enablity = true;
		testCase = extent.createTest("BUTTON-ENABLE");
		try {
			AssertJUnit.assertEquals(ActualElementEnable, ExpectedElementEnable);

		} catch (AssertionError e) {
			enablity = false;
		}
		if (enablity) {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.PASS, "Element enable");
		} else {
			testCase.log(Status.INFO, "ActualElementEnable :- " + ActualElementEnable);
			testCase.log(Status.INFO, "ExpectedElementEnable :- " + ExpectedElementEnable);
			testCase.log(Status.FAIL, "Element is not enable");
		}
		Thread.sleep(2000);

//		            check the button color

		String ActualButtonColor = AddSbuFunPage.SBUsavebutton.getCssValue("background-color");
		System.out.println("rgb :" + ActualButtonColor);

		String ExpectedButtonColor = "rgba(0, 19, 40, 1)";

		boolean buttoncolor = true;
		testCase = extent.createTest("BUTTON-COLOR");
		try {
			AssertJUnit.assertEquals(ActualButtonColor, ExpectedButtonColor);

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
		Thread.sleep(2000);

//		            check the border color

		String ActualBorderColor = AddSbuFunPage.SBUsavebutton.getCssValue("border-colour");
		System.out.println("rgb :" + ActualBorderColor);

		String ExpectedBorderColor = " ";

		boolean bordercolor = true;
		testCase = extent.createTest("BORDER-COLOR");
		try {
			AssertJUnit.assertEquals(ActualBorderColor, ExpectedBorderColor);

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
		Thread.sleep(2000);

//		            check the font type 

		String ActualFontType = AddSbuFunPage.SBUsavebutton.getCssValue("font-type");
		System.out.println("Font type: " + ActualFontType);

		String ExpectedFontType = "";
		
		//input[@id='sub_business_unit']

		boolean fonttype = true;
		testCase = extent.createTest("FONT-TYPE");
		try {
			AssertJUnit.assertEquals(ActualFontType, ExpectedFontType);

		} catch (AssertionError e) {
			fonttype = false;
		}
		if (fonttype) {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.PASS, "Correct Font Type");
		} else {
			testCase.log(Status.INFO, "ActualFontType :- " + ActualFontType);
			testCase.log(Status.INFO, "ExpectedFontType :- " + ExpectedFontType);
			testCase.log(Status.FAIL, "Wrong Font Type");
		}
		Thread.sleep(2000);

//		                    check font color

		String ActualFontColor = AddSbuFunPage.SBUsavebutton.getCssValue("color");

		System.out.println("Font colour: " + ActualFontColor);

		String ExpectedFontColor = "rgba(255, 255, 255, 1)";
		testCase = extent.createTest("LOGIN-BUTTON-FONT-COLOUR");
		try {
			AssertJUnit.assertEquals(ActualFontColor, ExpectedFontColor);
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.PASS, "Correct font Colour");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "ActualFontColor :- " + ActualFontColor);
			testCase.log(Status.INFO, "ExpectedFontColor :- " + ExpectedFontColor);

			testCase.log(Status.FAIL, "wrong font Colour");
		}
		Thread.sleep(2000);

//				cursor

		String ActualActions = AddSbuFunPage.SBUsavebutton.getCssValue("cursor");
		System.out.println("cursor :" + ActualActions);
		String ExpectedActions = "pointer";

		boolean cursor = true;
		testCase = extent.createTest("007-LOGIN-BUTTON-CURSOR");
		try {
			AssertJUnit.assertEquals(ActualActions, ExpectedActions);

		} catch (AssertionError e) {
			cursor = false;
		}
		if (cursor) {
			testCase.log(Status.INFO, "ActualFontSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedFontSize :- " + ExpectedActions);
			testCase.log(Status.PASS, "drop down auto");
		} else {
			testCase.log(Status.INFO, "ActualSize :- " + ActualActions);
			testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedActions);
			testCase.log(Status.FAIL, "drop dow not auto");
		}
		Thread.sleep(2000);

//				text spelling

		String text = AddSbuFunPage.SBUsavebutton.getText();

		String text1 = "Save";
		boolean txt1 = true;
		testCase = extent.createTest("SAVE BUTTON SPELLING");

		try {
			AssertJUnit.assertEquals(text, text1);
		} catch (AssertionError e) {
			txt1 = false;
		}
		if (txt1) {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "correct text");
			testCase.log(Status.PASS, "Correct ");
		} else {
			testCase.log(Status.INFO, "ActualElement :- " + text);
			testCase.log(Status.INFO, "ExpectedElement :- " + text1);
			testCase.log(Status.INFO, "wrong text");
			testCase.log(Status.FAIL, "wrong");
		}

		Thread.sleep(2000);

//				padding

		String Actualvalue = AddSbuFunPage.SBUsavebutton.getCssValue("padding");
		System.out.println("paddingvalue :" + Actualvalue);
		String Expectedvalue = "4px 15px";

		boolean padding = true;
		testCase = extent.createTest("007-LOGIN-BUTTON-PADDING");
		try {
			AssertJUnit.assertEquals(Actualvalue, Expectedvalue);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedvalue :- " + Expectedvalue);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(2000);

//		  		border radius

		String Actualradius = AddSbuFunPage.SBUsavebutton.getCssValue("border-radius");
		System.out.println("radius value :" + Actualradius);
		String Expectedradius = "2px";

		boolean radius = true;
		testCase = extent.createTest("007-LOGIN-BUTTON-RADIUS");
		try {
			AssertJUnit.assertEquals(Actualradius, Expectedradius);

		} catch (AssertionError e) {
			padding = false;
		}
		if (padding) {
			testCase.log(Status.INFO, "Actualradius :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualradius :- " + ActualActions);
			testCase.log(Status.INFO, "Expectedradius :- " + Expectedradius);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(2000);

//				opacity

		String Actualopacity = AddSbuFunPage.SBUsavebutton.getCssValue("opacity");
		System.out.println("opacity  :" + Actualopacity);
		String Expectedopacity = "1";

		boolean opacity = true;
		testCase = extent.createTest("007-LOGIN-BUTTON-OPACITY");
		try {
			AssertJUnit.assertEquals(Actualopacity, Expectedopacity);

		} catch (AssertionError e) {
			opacity = false;
		}
		if (opacity) {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.PASS, "Correct value");
		} else {
			testCase.log(Status.INFO, "Actualopacity :- " + Actualopacity);
			testCase.log(Status.INFO, "Expectedopacity :- " + Expectedopacity);
			testCase.log(Status.FAIL, "Wrong Value");
		}
		Thread.sleep(2000);

//				font weight

		String Actualfontweight = AddSbuFunPage.SBUsavebutton.getCssValue("font-weight");
		System.out.println("fontweight  :" + Actualfontweight);
		String Expectedfontweight = "400";

		boolean fontweight = true;
		testCase = extent.createTest("007-LOGIN-BUTTON-FONT-WEIGHT");
		try {
			AssertJUnit.assertEquals(Actualfontweight, Expectedfontweight);

		} catch (AssertionError e) {
			fontweight = false;
		}
		if (fontweight) {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.PASS, "Correct font weight");
		} else {
			testCase.log(Status.INFO, "Actualfontweight :- " + Actualfontweight);
			testCase.log(Status.INFO, "Expectedfontweight :- " + Expectedfontweight);
			testCase.log(Status.FAIL, "Wrong font weight");
		}
		Thread.sleep(2000);
	}
	
	// STEP-10 --THIS METHOD IS FOR SAVE BUTTON FUNCTION

	public static void clicksave() throws InterruptedException {
		AddSbuFunPage AddSbuFunpg = new AddSbuFunPage();
		PageFactory.initElements(driver, AddSbuFunpg);

		Thread.sleep(2000);
		AddSbuFunPage.SBUsavebutton.click();
	}

	//STEP-11 -- CHECK THE LAST ADD SBU VALUE
	public static  void checkLastAddvalue() throws InterruptedException, IOException {
        AddSbuFunPage addfunctionpg = new AddSbuFunPage();
		PageFactory.initElements(driver, addfunctionpg);
        
        Thread.sleep(2000);
        //WebElement tableRow = driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]"));
        String actualdata = AddSbuFunPage.tableRow.getText();
        System.out.println("First row of table : " + actualdata);
        
        String expecteddata ="Testing";
        boolean firstdata = true;
        testCase = extent.createTest("041-LAST-ADDED-DATA");
        try {
            AssertJUnit.assertEquals(actualdata, expecteddata);
        } catch (AssertionError e) {
            firstdata = false;
        }
        if (firstdata) {
            testCase.log(Status.INFO, "Actual Data :- " + actualdata);
            testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//            testCase.log(Status.INFO, "").assignCategory("High Severity");
//            testCase.log(Status.INFO, "").assignCategory("High Priority");
            testCase.log(Status.PASS, "Correct last added data");
        } else {
            testCase.log(Status.INFO, "Actual Data :- " + actualdata);
            testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//            testCase.log(Status.INFO, "").assignCategory("High Severity");
//            testCase.log(Status.INFO, "").assignCategory("High Priority");
            testCase.log(Status.FAIL, "Wrong last added data");
        }
    }

}
