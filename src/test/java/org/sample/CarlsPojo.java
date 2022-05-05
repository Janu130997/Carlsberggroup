package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarlsPojo extends BaseClass {
 public CarlsPojo() {
	PageFactory.initElements(driver, this);
	
}
 @FindBy(xpath="//span[text()='Menu']")
 private WebElement menu;
 
 @FindBy(xpath="(//a[text()='Investor Relations'])[2]")
 private WebElement investor;
 
 @FindBy(xpath="(//a[text()='Share Price'])[2]")
 private WebElement shares;
 
 @FindBy(xpath="//a[text()='Performance']")
 private WebElement arrow;
 
 @FindBy(xpath="(//a[text()='Share Price'])[1]")
 private WebElement price;

public WebElement getMenu() {
	return menu;
}

public void setMenu(WebElement menu) {
	this.menu = menu;
}

public WebElement getInvestor() {
	return investor;
}

public void setInvestor(WebElement investor) {
	this.investor = investor;
}

public WebElement getShares() {
	return shares;
}

public void setShares(WebElement shares) {
	this.shares = shares;
}

public WebElement getArrow() {
	return arrow;
}

public void setArrow(WebElement arrow) {
	this.arrow = arrow;
}

public WebElement getPrice() {
	return price;
}

public void setPrice(WebElement price) {
	this.price = price;
}


 


 
 
}
