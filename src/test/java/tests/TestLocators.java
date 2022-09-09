package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLocators {
	// CAMPOS
	WebDriver driver;

	String TIPO_DRIVER = "webdriver.chrome.driver";
	String PATH_DRIVER = "./src/test/resources/WebDriver/chromedriver.exe";
	String URL = "http://automationpractice.com/";

	@Before
	public void setUp() {

		System.setProperty(TIPO_DRIVER, PATH_DRIVER);

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();

	}

	@Test
	public void testLocators() throws InterruptedException {
		// By ID
		WebElement elemento = driver.findElement(By.id("search_query_top"));
		elemento.sendKeys("POR ID");
		Thread.sleep(3000);
		// by NAME
		elemento.clear();
		elemento = driver.findElement(By.name("search_query"));
		elemento.sendKeys("POR NAME");
		Thread.sleep(3000);
		// by ClassName
		elemento.clear();
		elemento = driver.findElement(By.className("login"));
		elemento.click();
		Thread.sleep(3000);
		//By TAGnAME
		
		elemento = driver.findElement(By.tagName("body"));
		elemento.click();
	
		// By linkText
		
		elemento = driver.findElement(By.linkText("Contact us"));
		elemento.click();
	
		// By partlinkText
		
		elemento = driver.findElement(By.partialLinkText("Contact"));
		elemento.click();
		
		// By cssSelector
		
		elemento = driver.findElement(By.cssSelector(".search_query.form-control.ac_input"));
		elemento.sendKeys("POR CSSSELECTOR");
		Thread.sleep(3000);
		// bY XPATH
		elemento.clear();
		elemento = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		elemento.sendKeys("POR XPATCH");
		Thread.sleep(3000);
	}

	@After
	public void testDown() {

		driver.quit();
	}
}
