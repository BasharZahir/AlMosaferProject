package HotelTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingHotelTestCases extends Parameters {
	
	@BeforeTest
	public void mySetup() {
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
WebElement popMsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		
		if(popMsg.isDisplayed()) {
			WebElement SarButton = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			SarButton.click();
		}
		
	}
	
	
	
	
	@Test(priority = 1)
	
	public void SelectCityRandomly() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		WebElement SearchcityInput = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		
		if(driver.getCurrentUrl().contains("en")) {
			SearchcityInput.sendKeys(EnglishCities[RandomEnglishCity]);
			
			WebElement ResultsList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
		ResultsList.findElements(By.tagName("li")).get(1).click();
			
		}else {
			SearchcityInput.sendKeys(ArabicCities[RandomArabicCity]);
			WebElement ResultsList = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
			ResultsList.findElements(By.tagName("li")).get(1).click();
		}
	}

	
	
	
	
	@Test (priority = 2)
	
	public void SelectNumberOfVisitorsRandomly() {
		WebElement SelectVisitorNUmber = driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select selector = new Select(SelectVisitorNUmber);
		
		selector.selectByIndex(visitorNumber);
		
		WebElement SearchHotelButton = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchHotelButton.click();
	}
	
	
}
