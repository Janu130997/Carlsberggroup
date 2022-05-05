package org.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefine extends BaseClass {
	CarlsPojo p;
	JavascriptExecutor js;
	@Given("user has to be pass the url in chrome browser")
	public void user_has_to_be_pass_the_url_in_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.carlsberggroup.com/?cbgAge=1985121#investor-relations");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement a = driver.findElement(By.xpath(("(//button[@type='button'])[2]")));
		js.executeScript("arguments[0].click()",a);
		
	}

	@Given("user has to be move to Investor Relations")
	public void user_has_to_be_move_to_Investor_Relations() {
		WebElement invest = driver.findElement(By.xpath("(//a[text()='Investor Relations'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(invest).perform();	
	}

	@When("user has to be move shares and click the share price button")
	public void user_has_to_be_move_shares_and_click_the_share_price_button() {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Share Price'])[2]")));
		WebElement latestshares = driver.findElement(By.xpath("(//a[text()='Share Price'])[2]"));
	    latestshares.click();
	}

	@When("user has to click the performance button")
	public void user_has_to_click_the_performance_button() {
		driver.switchTo().frame("euroland_frame_id");
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Volume']")));
		WebElement cop = driver.findElement(By.xpath("//span[text()='Volume']"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",cop);
	}

	@Then("user can shown on performance details")
	public void user_can_shown_on_performance_details() {
		WebElement cop1 = driver.findElement(By.xpath("//a[text()='Performance']"));
	    js.executeScript("arguments[0].click()",cop1);
	}
}
