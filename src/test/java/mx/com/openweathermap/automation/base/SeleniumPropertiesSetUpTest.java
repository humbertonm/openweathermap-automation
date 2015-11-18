package mx.com.openweathermap.automation.base;

import mx.com.automation.facory.WebDriverFactoy;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * Created by beto on 17/11/15.
 */
public class SeleniumPropertiesSetUpTest {

  protected WebDriver driver;


  @Before
  public void setUpDriver(){

    driver = WebDriverFactoy.createDriver("");

  }

  @After
  public void closeDriver(){
    driver.close();
  }

}
