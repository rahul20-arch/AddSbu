package com.invicta.qa.pages.sbu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSbuFunPage {

	@FindBy(xpath = "//*[@id=\\\"usernameOrEmail\\\"]")
	public static WebElement username;
	
	@FindBy(xpath = "//*[@id=\\\"password\\\"]")
	public static WebElement password;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button")
	public static WebElement loginbutton;
	
	@FindBy(xpath = "/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")
	public static WebElement master;

	@FindBy(xpath = "//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[1]/div/div[1]")
	public static WebElement SBU;
	

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement SBUbutton;
	
	//Add SBU Button model window
    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
    public static WebElement addsbumodel;
		
	@FindBy(xpath = "//div[@class='sc-VigVT jzVhIp']/p")
	public static WebElement AddSBUtext;
		
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/label")
	public static WebElement SBUText;
		
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div/label")
	public static WebElement DescriptionText;
		
	@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
	public static WebElement SBUtextbox;
		
		@FindBy(xpath = "//*[@id=\"description\"]")
		public static WebElement Descriptiontextbox;
		@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
		public static WebElement SBUtext;
		
		@FindBy(xpath = "//*[@id=\"description\"]")
		public static WebElement SBUdestext;
		
		@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]")
		public static WebElement SBUsavebutton;
		
		@FindBy(xpath = "//*[@id=\"rcDialogTitle0\"]/div/span")
		public static WebElement SBUclose;
		
		@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]/span")
		public static WebElement SBUsavefont;
		
		@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
		public static WebElement SBUplaceholder;
		
		@FindBy(xpath = "//*[@id=\"description\"]")
		public static WebElement Desplaceholder;
		
		@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
		public static WebElement sbumodal;
		@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	    public static WebElement tableRow;
	}
	

