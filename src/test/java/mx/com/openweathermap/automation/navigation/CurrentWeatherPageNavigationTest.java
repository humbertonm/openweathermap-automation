package mx.com.openweathermap.automation.navigation;

import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.dto.IndexLinkName;
import mx.com.openweathermap.pages.CurrentWeatherPage;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by beto on 17/11/15.
 */
public class CurrentWeatherPageNavigationTest extends SeleniumPropertiesSetUpTest{


  @Test
  public void verifyNavigationFromIndex(){
    CurrentWeatherPage page = new CurrentWeatherPage(driver);
    for(IndexLinkName item: IndexLinkName.values()){
      page.clickOnIndexLinkName(item);
    }

  }


}
