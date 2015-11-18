package mx.com.automation.facory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by beto on 17/11/15.
 */
public class WebDriverFactoy {

  public static WebDriver createDriver(String driverName ){
    return new FirefoxDriver();
  }

}
