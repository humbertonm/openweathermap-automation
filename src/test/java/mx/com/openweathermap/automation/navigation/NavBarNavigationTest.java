package mx.com.openweathermap.automation.navigation;

import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.components.NavBar;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beto on 24/11/15.
 */
public class NavBarNavigationTest extends SeleniumPropertiesSetUpTest {

  @Test
  public void verifyNavigationToPrincipal(){
    final String expectedPage = "http://openweathermap.org/";
    NavBar component = new NavBar(driver);
    component.navigateToTitle();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToHome(){
    final String expectedPage = "http://openweathermap.org/";
    NavBar component = new NavBar(driver);
    component.navigateToHome();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToWeather(){
    final String expectedPage = "http://openweathermap.org/city";
    NavBar component = new NavBar(driver);
    component.navigateToWeather();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToWeatherMaps(){
    final String expectedPage = "http://openweathermap.org/maps";
    NavBar component = new NavBar(driver);
    component.navigateToWeatherMaps();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToCurrentSatelliteMaps(){
    final String expectedPage = "http://owm.io/modis";
    NavBar component = new NavBar(driver);
    component.navigateToCurrentSatelliteMaps();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToBeatifulMaps(){
    final String expectedPage = "http://owm.io/beautiful_maps";
    NavBar component = new NavBar(driver);
    component.navigateToBeatifulMaps();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToApi(){
    final String expectedPage = "http://openweathermap.org/api";
    NavBar component = new NavBar(driver);
    component.navigateToApi();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToPrice(){
    final String expectedPage = "http://openweathermap.org/price";
    NavBar component = new NavBar(driver);
    component.navigateToPrice();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToStations(){
    final String expectedPage = "http://openweathermap.org/stations";
    NavBar component = new NavBar(driver);
    component.navigateToStations();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToNews(){
    final String expectedPage = "http://openweathermap.org/news";
    NavBar component = new NavBar(driver);
    component.navigateToNews();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToAboutCompany(){
    final String expectedPage = "http://openweathermap.org/about";
    NavBar component = new NavBar(driver);
    component.navigateToAboutCompany();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToOwmPlatform(){
    final String expectedPage = "http://openweathermap.org/owm-platform";
    NavBar component = new NavBar(driver);
    component.navigateToOwmPlattaform();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToBigDataTechnology(){
    final String expectedPage = "http://openweathermap.org/technology";
    NavBar component = new NavBar(driver);
    component.navigateToBigDataTechnology();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToMeteorologicalModels(){
    final String expectedPage = "http://openweathermap.org/models";
    NavBar component = new NavBar(driver);
    component.navigateToMeteorologicalModels();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToDataSources(){
    final String expectedPage = "http://openweathermap.org/datasource";
    NavBar component = new NavBar(driver);
    component.navigateToDataSources();
    Assert.assertEquals(expectedPage,driver.getCurrentUrl());
  }

}
