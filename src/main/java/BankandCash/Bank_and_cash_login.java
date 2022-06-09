package BankandCash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bank_and_cash_login {
	
	static	WebDriver driver;

	@Before
	public  void launchBrowser() throws InterruptedException {
		System.out.println("This is before method");
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver102.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();// delete the cookies
		driver.get("https://techfios.com/billing/?ng=dashboard/"); // using the url for going to the website
		driver.manage().window().maximize(); // maximizing the window
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		driver.findElement(By.name("login")).click(); // identify Signin element and click
		driver.findElement(By.partialLinkText("Bank & Cash")).click(); // for bank and cash button
	}
	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.partialLinkText("New Account")).click(); // for new account
		driver.findElement(By.id("account")).sendKeys("December_checking");
		driver.findElement(By.id("description")).sendKeys("Salary");
		driver.findElement(By.id("balance")).sendKeys("$2100");
		driver.findElement(By.id("account_number")).sendKeys("750750750");

		driver.findElement(By.id("contact_person")).sendKeys("Techfios");
		driver.findElement(By.id("contact_phone")).sendKeys("1234567890");
		driver.findElement(By.id("ib_url")).sendKeys("http://www.techfios.com ");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class ='btn btn-primary']")).click();
		//driver.findElement(By.id("submit")).submit();
	
		Thread.sleep(3000);
	}
	@After
	public void tearDown() {
		driver.close();
}
}
