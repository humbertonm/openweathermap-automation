package mx.com.openweathermap.automation.navigation;


import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.components.MiniNavBar;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beto on 19/11/15.
 */
public class MiniNavBarNavigationTest extends SeleniumPropertiesSetUpTest{

  private MiniNavBar miniNavBar;


  @Test
  public void verifyNavigationToWeatherInYourCity(){
    final String city = "Mexico";
    final String weatherInYourCityUrl = "http://openweathermap.org/find?q="+city;
    miniNavBar = new MiniNavBar(driver);

    miniNavBar.searchWeatherInYourCity(city);

    Assert.assertEquals(weatherInYourCityUrl, driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToSignIn(){
    final String weatherInYourCityUrl = "http://home.openweathermap.org/users/sign_in";
    miniNavBar = new MiniNavBar(driver);

    miniNavBar.navigateToSignIn();

    Assert.assertEquals(weatherInYourCityUrl, driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToSignUp(){
    final String weatherInYourCityUrl = "http://home.openweathermap.org/users/sign_up";
    miniNavBar = new MiniNavBar(driver);

    miniNavBar.navigateToSignUp();

    Assert.assertEquals(weatherInYourCityUrl, driver.getCurrentUrl());
  }

  @Test
  public void verifyNavigationToEmailUs(){
    final String weatherInYourCityUrl = "https://openweathermap.desk.com/customer/portal/emails/new?t=535697";
    miniNavBar = new MiniNavBar(driver);

    miniNavBar.navigateToEmailUs();

    Assert.assertEquals(weatherInYourCityUrl, driver.getCurrentUrl());
  }

}
