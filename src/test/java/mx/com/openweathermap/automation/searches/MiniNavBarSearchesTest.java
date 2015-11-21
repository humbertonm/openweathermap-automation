package mx.com.openweathermap.automation.searches;

import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.components.MiniNavBar;
import mx.com.openweathermap.dto.WeatherInYourCityResult;
import mx.com.openweathermap.pages.SearchResultsPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by beto on 20/11/15.
 */
public class MiniNavBarSearchesTest extends SeleniumPropertiesSetUpTest{

  private MiniNavBar miniNavBar;

  @Test
  public void verifySearch(){
    final String city = "Mexico city";
    miniNavBar = new MiniNavBar(driver);

    miniNavBar.searchWeatherInYourCity(city);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    List<WeatherInYourCityResult> results = searchResultsPage.getSearchResults();

    Assert.assertFalse(results.isEmpty());
    Assert.assertEquals(1, results.size());
    WeatherInYourCityResult result = results.get(0);


  }
}
