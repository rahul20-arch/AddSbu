package com.invicta.qa.pages.sbu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteSbuFunPage  {
	
	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[2]")
	public static WebElement DeleteButton;
	
	@FindBy(xpath =  "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	public static WebElement Text;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]")
	public static WebElement DeleteOkButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]")
	public static WebElement DeleteCancelButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div")
    public static WebElement Confirm;
}
