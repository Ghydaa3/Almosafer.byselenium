package myProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseAlmosafer {

	WebDriver driver = new ChromeDriver();
	String URL = "https://global.almosafer.com/en";

	@BeforeTest
	public void preTest() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']")).click();

	}

	@Test()
	public void languageTest() {

		String checkLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(checkLanguage, "en", "This is language test");

	}
	
	@Test
	public void currencyTest() {
		String currencyTest= driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		Assert.assertEquals(currencyTest, "SAR" ,"This is currency test");
		
		
	}

	@AfterTest
	public void postTest() {

	}
}
