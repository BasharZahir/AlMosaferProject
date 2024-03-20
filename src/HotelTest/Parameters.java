package HotelTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	
	String URL = "https://www.almosafer.com/en";
	
	String [] ArabicCities = {"دبي", "جدة"};
	
	String [] EnglishCities = {"dubai", "jeddah", "riyadh"};
	
	Random rand = new Random();

	
	int RandomArabicCity = rand.nextInt(ArabicCities.length);
	int RandomEnglishCity = rand.nextInt(EnglishCities.length);


	int visitorNumber = rand.nextInt(2);


}
