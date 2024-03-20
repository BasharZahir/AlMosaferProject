package HomePage;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCases extends Parameters {
	
	@BeforeTest
	
	public void mySetuo() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement popMsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		
		if(popMsg.isDisplayed()) {
			WebElement SarButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			SarButton.click();
		}
		
		
	}
	
	
	
	@Test(enabled = false)
	
	public void CheckTheDefaultLanguage() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		
		myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		
		
	}
	
	
	
	@Test (enabled = false)
	public void CheckTheDefaultCurrency() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		
		myAssert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	
	
	@Test (enabled = false)
	public void CheckTheContactNumber() {
		String ActualNumber = driver.findElement(By.tagName("strong")).getText();
		
		myAssert.assertEquals(ActualNumber, ExpectedNumber);
	}
	
	
	
	
	@Test(enabled = false)
	
	public void CheckQitafLogo() {
		WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));
		boolean ActualResult = QitafLogo.isDisplayed();
		myAssert.assertEquals(ActualResult, true);
	}
	
	
	
	
	@Test(enabled = false)
	
	public void CheckHotelTab() {
		WebElement HotelTab  = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualResult = HotelTab.getAttribute("aria-selected");
		myAssert.assertEquals(ActualResult, "false");
		
	}
	
	
	
	
	@Test(enabled = false)
	
	public void CheckDepartureDate() {
		
		LocalDate today = LocalDate.now();
		
		int tomorrow = today.plusDays(1).getDayOfMonth();
		int theDayAfterTomorrow = today.plusDays(2).getDayOfMonth();
		
		
		String ActualDeparture = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText();
		int ActualDepartureDate = Integer.parseInt(ActualDeparture);
		
		String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText();
		int ActualReturnDate = Integer.parseInt(ActualReturn);
		
		
		myAssert.assertEquals(ActualDepartureDate, tomorrow );
		myAssert.assertEquals(ActualReturnDate, theDayAfterTomorrow );

		
		
	}
	
	
	
	
	
	@Test 
	
	public void ChangeLanguageRandomly() throws InterruptedException {
		
		driver.get(websites[randomWebsite]);

		if(driver.getCurrentUrl().contains("en")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		}else {
String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		}
		
		
	}
	
	
	
}







