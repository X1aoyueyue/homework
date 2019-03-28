package com.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class testURL {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.firefox.bin","F:\\Firefox\\firefox.exe"); 
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testBaidu() throws Exception {
	    driver.get(baseUrl + "/");
	    //WebElement we = driver.findElement(By.id("id"));
	    //we.click();
	    File xlsFile = new File("C:\\Users\\1A03\\Desktop\\软件测试\\软件测试名单.xlsx");
	    // 获得工作簿
	    Workbook workbook = WorkbookFactory.create(xlsFile);
	    Sheet sheet = workbook.getSheetAt(0);
	    // 遍历工作表
	    for(int row = 2; row < 145;row ++) {
	    	Row r = sheet.getRow(row);
	    	r.getCell(1).setCellType(XSSFCell.CELL_TYPE_STRING);
	    	String id = r.getCell(1).getStringCellValue();
	    	String name = r.getCell(2).getStringCellValue();
	    	String gitURL = r.getCell(3).getStringCellValue();
	    	String password = id.substring(4);
	    	driver.findElement(By.name("id")).click();
		    driver.findElement(By.name("id")).sendKeys(id);
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys(password);
		    driver.findElement(By.id("btn_login")).click();
		    WebElement element1 = driver.findElement(By.id("student-git"));
		    WebElement element2 = driver.findElement(By.id("student-name"));
		    WebElement element3 = driver.findElement(By.id("student-id"));
		    assertEquals(name,element2.getText());
		    assertEquals(gitURL, element1.getText());
		    assertEquals(id, element3.getText());
		    driver.findElement(By.id("btn_logout")).click();
		    driver.findElement(By.id("btn_return")).click();
	    }
//	    driver.findElement(By.id("kw")).click(); 
	}

	@After
	public void tearDown() throws Exception {
//	    driver.quit();
//	    String verificationErrorString = verificationErrors.toString();
//	    if (!"".equals(verificationErrorString)) {
//	      fail(verificationErrorString);
//	    }
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	}

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	}
}
