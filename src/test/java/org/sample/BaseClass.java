package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public static Select a;
public static Select e;
public static Select s;
public static Select v;
public static void browser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
public static void launch() {
	driver.get("https://demoqa.com/automation-practice-form");
}
public static void windowMax() {
	driver.manage().window().maximize();
}
public static void fillloginid(WebElement s,String val) {
	s.sendKeys(val); 
}
public static void button(WebElement e) {
	e.click();
}
public static void applyWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public static void selectplace(WebElement s,String t) {
	a=new Select(s);
	a.selectByValue(t);
}
public static void selectHotel(WebElement f,String s) {
	e=new Select(f);
	e.selectByValue(s);
}
public static void selectRoom(WebElement a, String t) {
	s=new Select(a);
	s.selectByValue(t);
	}
public static void roomNo(WebElement d,String e) {
	v=new Select(d);
	v.selectByValue(e);
}
public static void sel(WebElement a, String t) {
	s=new Select(a);
	s.selectByValue(t);
	}
public static void exp(WebElement a, String t) {
	s=new Select(a);
	s.selectByValue(t);
	}
public static void year(WebElement a, String t) {
	s=new Select(a);
	s.selectByValue(t);
	}
public static String getvalue(WebElement d) {
	String a = d.getAttribute("value");
	System.out.println("order no:"+a);
	return a;
}
public static String readExcel(String string, int row, int cell) throws IOException {
	File f = new File("C:\\Users\\user\\eclipse-workspace\\MavenBrowser7\\excel\\reg.xlsx");
	FileInputStream in = new FileInputStream(f);
	Workbook book = new XSSFWorkbook(in);
	Sheet a = book.getSheet(string);
	Row r = a.getRow(row);
	Cell c = r.getCell(cell);
	int type = c.getCellType();
	String data="";
	if (type == 1) {
		data = c.getStringCellValue();
	} else if (DateUtil.isCellDateFormatted(c)) {
		java.util.Date date = c.getDateCellValue();
		SimpleDateFormat form = new SimpleDateFormat("MM-DD-YYYY");
		data = form.format(date);
	} else {
		double d = c.getNumericCellValue();
		long l = (long) d;
		data = String.valueOf(1);

	}
	return data;
}
}
