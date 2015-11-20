package mx.com.openweathermap.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by beto on 17/11/15.
 */
public class MiniNavBar {

  private WebDriver driver;
  private By emailLink = By.linkText("Email Us");
  private By weatherInYourCityLink = By.linkText("Weather in your city");
  private By singInLink = By.linkText("Sing In");
  private By singUpLink = By.linkText("Sing Up");
  private By unitsInput = By.id("units_check");
  private By searchInput = By.id("q");
  private By findButton = By.xpath("//form[@id='nav-search-form']//button[@type='submit']");

  public MiniNavBar(WebDriver driver){
    this.driver = driver;
  }

  public void searchWeatherInYourCity(String city){
    driver.findElement(weatherInYourCityLink).click();
    WebElement search = driver.findElement(searchInput);
    search.clear();
    search.sendKeys(city);
    driver.findElement(findButton).click();

  }

}
