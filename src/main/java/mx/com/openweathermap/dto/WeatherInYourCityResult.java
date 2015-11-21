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

  @Override
  public String toString() {
    return "WeatherInYourCityResult{" +
        "weatherImageSource='" + weatherImageSource + '\'' +
        ", cityName='" + cityName + '\'' +
        ", cityLink='" + cityLink + '\'' +
        ", flagImageSource='" + flagImageSource + '\'' +
        ", weatherShortDescription='" + weatherShortDescription + '\'' +
        ", temperature='" + temperature + '\'' +
        ", weatherDescription='" + weatherDescription + '\'' +
        ", geoCoords='" + geoCoords + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    WeatherInYourCityResult that = (WeatherInYourCityResult) o;

    if (!weatherImageSource.equals(that.weatherImageSource)) return false;
    if (!cityName.equals(that.cityName)) return false;
    if (!cityLink.equals(that.cityLink)) return false;
    if (!flagImageSource.equals(that.flagImageSource)) return false;
    if (!weatherShortDescription.equals(that.weatherShortDescription)) return false;
    if (!temperature.equals(that.temperature)) return false;
    if (!weatherDescription.equals(that.weatherDescription)) return false;
    return geoCoords.equals(that.geoCoords);

  }

  @Override
  public int hashCode() {
    int result = weatherImageSource.hashCode();
    result = 31 * result + cityName.hashCode();
    result = 31 * result + cityLink.hashCode();
    result = 31 * result + flagImageSource.hashCode();
    result = 31 * result + weatherShortDescription.hashCode();
    result = 31 * result + temperature.hashCode();
    result = 31 * result + weatherDescription.hashCode();
    result = 31 * result + geoCoords.hashCode();
    return result;
  }
}
