package mx.com.openweathermap.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by beto on 20/11/15.
 */
public class NavBar {

  private WebDriver driver;

  private final By openWeatherMapLink = By.partialLinkText("OpenWeatherMap");
  private final By homeLink = By.linkText("Home");
  private final By weatherLink = By.linkText("Weather");
  private final By mapsDropdown = By.partialLinkText("Maps");

  private final By weatherMapsLink = By.linkText("Weather maps");
  private final By currentSatelliteMapsLink = By.linkText("Current satellite maps");
  private final By beautifulMapsLink = By.linkText("Beautiful maps");

  private final By apiLink = By.linkText("API");
  private final By priceLink = By.linkText("Price");
  private final By stationsLink = By.linkText("Stations");
  private final By newsLink = By.linkText("News");

  private final By aboutDropdown = By.partialLinkText("About");
  private final By aboutCompanyLink = By.linkText("About company");
  private final By owmPlatformLink = By.linkText("OWM Platform");
  private final By bigDataTechnologyLink = By.linkText("Big Data Technology");
  private final By meteorologicalModelsLink = By.linkText("Meteorological models");
  private final By dataSourcesLink = By.linkText("Data sources");


  public NavBar(WebDriver driver){
    this.driver=driver;
  }

  public void navigateToTitle(){
    driver.findElement(openWeatherMapLink).click();
  }

  public void navigateToHome(){
    driver.findElement(homeLink).click();
  }

  public void navigateToWeather(){
    driver.findElement(weatherLink).click();
  }

  public void navigateToWeatherMaps(){
    driver.findElement(mapsDropdown).click();
    driver.findElement(weatherMapsLink).click();
  }

  public void navigateToCurrentSatelliteMaps(){
    driver.findElement(mapsDropdown).click();
    driver.findElement(currentSatelliteMapsLink).click();
  }

  public void navigateToBeatifulMaps(){
    driver.findElement(mapsDropdown).click();
    String currentWin = driver.getWindowHandle();
    driver.findElement(beautifulMapsLink).click();
    for(String winHandle: driver.getWindowHandles()){
      if(!currentWin.equals(winHandle)){
        driver.switchTo().window(winHandle);
        break;
      }
    }
  }

  public void navigateToApi(){
    driver.findElement(apiLink).click();
  }

  public void navigateToPrice(){
    driver.findElement(priceLink).click();
  }

  public void navigateToStations(){
    driver.findElement(stationsLink).click();
  }

  public void navigateToNews(){
    driver.findElement(newsLink).click();
  }

  public void navigateToAboutCompany(){
    driver.findElement(aboutDropdown).click();
    driver.findElement(aboutCompanyLink).click();
  }

  public void navigateToOwmPlattaform(){
    driver.findElement(aboutDropdown).click();
    driver.findElement(owmPlatformLink).click();
  }

  public void navigateToBigDataTechnology(){
    driver.findElement(aboutDropdown).click();
    driver.findElement(bigDataTechnologyLink).click();
  }

  public void navigateToMeteorologicalModels(){
    driver.findElement(aboutDropdown).click();
    driver.findElement(meteorologicalModelsLink).click();
  }

  public void navigateToDataSources(){
    driver.findElement(aboutDropdown).click();
    driver.findElement(dataSourcesLink).click();
  }



}
