package com.invicta.qa.pages.sbu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteSbuUIPage  {

	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement master;
	
	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div[1]/div/div[1]/div[1]")
	public static WebElement SBU;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[2]/span")
	public static WebElement deleteicon;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']/span[text()='OK']")
	public static WebElement OkButton;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm']")
	public static WebElement CancelButton;
	
	@FindBy(xpath = "//div[@class='ant-popover-message-title']")
	public static WebElement text;
	
	
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	public static WebElement modal;
	@FindBy(xpath = "//span[@aria-label='question-circle']//*[name()='svg']")
	public static WebElement mark;
	
}
