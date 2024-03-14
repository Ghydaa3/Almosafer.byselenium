package myProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

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

	@Test()
	public void currencyTest() {
		String currencyTest = driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		Assert.assertEquals(currencyTest, "SAR", "This is currency test");

	}

	@Test()
	public void contactNumbers() {

		WebElement contactNum = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String ActualNumber = contactNum.getText();
		String ExpectedNumber = "+966554400000";
		Assert.assertEquals(ActualNumber, ExpectedNumber);

	}

	@Test()
	public void qitafLogo() {
		WebElement qitafLogo = driver.findElement(By.tagName("footer"));
		boolean Logo = qitafLogo.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']")).isDisplayed();
		Assert.assertEquals(Logo, true);
	}

	@Test()
	public void HotelsTabNotSelected() {
		WebElement HotelsTabNotSelected = driver
				.findElement(By.xpath("//a[@id='uncontrolled-tab-example-tab-hotels']"));
		String Hotels = HotelsTabNotSelected.getAttribute("aria-selected");
		Assert.assertEquals(Hotels, "false");

	}
	

	@Test(invocationCount = 5)
	public void changeLanguage() {

		String[] changelanguage = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };

		Random rand = new Random();
		int indexlang = rand.nextInt(changelanguage.length);
		driver.get(changelanguage[indexlang]);

		String myWebsiteUrl = driver.getCurrentUrl();

		if (myWebsiteUrl.contains("en")) {
			String checkLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(checkLanguage, "en", "This is language test");

		} else if (myWebsiteUrl.contains("ar")) {
			String checkLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(checkLanguage, "ar", "This is language test");

		}

	}

}
