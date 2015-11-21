package mx.com.openweathermap.dto;

import org.openqa.selenium.WebDriver;

/**
 * Created by beto on 20/11/15.
 */
public class WeatherInYourCityResult {

  private String weatherImageSource;
  private String cityName;
  private String cityLink;
  private String flagImageSource;
  private String weatherShortDescription;
  private String temperature;
  private String weatherDescription;
  private String geoCoords;

  public WeatherInYourCityResult() {
  }

  public WeatherInYourCityResult(String weatherImageSource, String cityName, String cityLink, String flagImageSource, String weatherShortDescription, String temperature, String weatherDescription, String geoCoords) {
    this.weatherImageSource = weatherImageSource;
    this.cityName = cityName;
    this.cityLink = cityLink;
    this.flagImageSource = flagImageSource;
    this.weatherShortDescription = weatherShortDescription;
    this.temperature = temperature;
    this.weatherDescription = weatherDescription;
    this.geoCoords = geoCoords;
  }

  public String getWeatherImageSource() {
    return weatherImageSource;
  }

  public void setWeatherImageSource(String weatherImageSource) {
    this.weatherImageSource = weatherImageSource;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCityLink() {
    return cityLink;
  }

  public void setCityLink(String cityLink) {
    this.cityLink = cityLink;
  }

  public String getFlagImageSource() {
    return flagImageSource;
  }

  public void setFlagImageSource(String flagImageSource) {
    this.flagImageSource = flagImageSource;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public String getWeatherDescription() {
    return weatherDescription;
  }

  public void setWeatherDescription(String weatherDescription) {
    this.weatherDescription = weatherDescription;
  }

  public String getGeoCoords() {
    return geoCoords;
  }

  public void setGeoCoords(String geoCoords) {
    this.geoCoords = geoCoords;
  }
}
