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

  @Test
  public void verifySearchWithSimpleResult(){
    final String city = "Mexico city";
    MiniNavBar miniNavBar = new MiniNavBar(driver);

    miniNavBar.searchWeatherInYourCity(city);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    List<WeatherInYourCityResult> results = searchResultsPage.getSearchResults();

    Assert.assertFalse(results.isEmpty());
    Assert.assertEquals(1, results.size());

    compareWeatherResults(results.get(0),generateTestDataFromMexicoCity());

  }

  private void compareWeatherResults(WeatherInYourCityResult result, WeatherInYourCityResult expected) {
    Assert.assertEquals(expected.getCityName(), result.getCityName());
    Assert.assertEquals(expected.getFlagImageSource(),result.getFlagImageSource());
    Assert.assertEquals(expected.getGeoCoords(),result.getGeoCoords());
  }

  @Test
  public void verifySearchWithMultipleResults(){
    final String city = "Mexico";
    MiniNavBar miniNavBar = new MiniNavBar(driver);

    miniNavBar.searchWeatherInYourCity(city);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    List<WeatherInYourCityResult> results = searchResultsPage.getSearchResults();

    Assert.assertFalse(results.isEmpty());
    Assert.assertEquals(2, results.size());
    compareWeatherResults(results.get(0),generateTestDataFromMexicoCity());
    compareWeatherResults(results.get(1),generateTestDataFromMexicoPH());

  }


  private WeatherInYourCityResult generateTestDataFromMexicoCity(){
    WeatherInYourCityResult result = new WeatherInYourCityResult();
    result.setCityName("Mexico City, MX");
    result.setFlagImageSource("http://openweathermap.org/images/flags/mx.png");
    result.setGeoCoords("[ -99.127663, 19.428471 ]");
    return result;
  }

  private WeatherInYourCityResult generateTestDataFromMexicoPH(){
    WeatherInYourCityResult result = new WeatherInYourCityResult();
    result.setCityName("Mexico, PH");
    result.setFlagImageSource("http://openweathermap.org/images/flags/ph.png");
    result.setGeoCoords("[ 120.719803, 15.0646 ]");
    return result;
  }


}
