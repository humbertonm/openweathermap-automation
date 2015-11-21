package mx.com.openweathermap.pages;

import mx.com.openweathermap.dto.WeatherInYourCityResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beto on 20/11/15.
 */
public class SearchResultsPage {

  private static final Logger LOG = LoggerFactory.getLogger(SearchResultsPage.class);

  private WebDriver driver;

  private final By searchResultTable = By.xpath("//div[@id='forecast_list_ul']/table");
  private final By weatherShortDesc = By.xpath("./td[2]/b/i");
  private final By weatherImg = By.xpath("./td[1]/img");
  private final By city = By.xpath("./td[2]/b/a");
  private final By cityFlag = By.xpath("./td[2]/img");
  private final By temperature = By.xpath("./td[2]/p/span");
  private final By temperatureDesc = By.xpath("./td[2]/p[1]");
  private final By geoCoords = By.xpath("./td[2]/p[2]/a");

  public SearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public List<WeatherInYourCityResult> getSearchResults(){
    List<WeatherInYourCityResult> results = new ArrayList<>();
    WebElement tableElement = driver.findElement(searchResultTable);
    List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
    for(WebElement row:rows){
      WebElement weatherImgElement = row.findElement(weatherImg);
      WebElement cityElement = row.findElement(city);
      WebElement weatherShortDescElement = row.findElement(weatherShortDesc);
      WebElement cityFlagElement = row.findElement(cityFlag);
      WebElement temperatureElement = row.findElement(temperature);
      WebElement temperatureDescElement = row.findElement(temperatureDesc);
      WebElement geoCoordsElements = row.findElement(geoCoords);

      WeatherInYourCityResult result = new WeatherInYourCityResult(weatherImgElement.getAttribute("src"),
          cityElement.getText(),
          cityElement.getAttribute("href"),
          cityFlagElement.getAttribute("src"),
          weatherShortDescElement.getText(),
          temperatureElement.getText(),
          temperatureDescElement.getText(),
          geoCoordsElements.getText());

      LOG.debug("Weather Result: {}", result);

      results.add(result);

    }

    return results;
  }

}
