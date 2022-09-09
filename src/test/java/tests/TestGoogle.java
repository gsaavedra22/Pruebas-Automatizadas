package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
	// variables

	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/WebDriver/chromedriver.exe";
	private String URL = "https://www.google.com";

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("INICIO DE TEST");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(URL);
	}

	@Test
	public void testSearch() {
		String textEnviado = "TEST01";

		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys(textEnviado);
		txtSearch.submit();
		//ESPERE A QUE GOOGLE RESPONDA
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// vALIDAR SI EL TITULO CONTIENE EL TEXTO
		String titulo = driver.getTitle();
		Assert.assertTrue("VALIDA EL TITULO", titulo.contains(textEnviado));

	}

	@After
	public void tearDown() {

		driver.quit();

	}

	@AfterClass
	public static void tearDownAfterClass() {

		System.out.println("Finaliza test");

	}
}
