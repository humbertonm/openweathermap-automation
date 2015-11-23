package mx.com.openweathermap.automation.navigation;

import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.dto.IndexLinkName;
import mx.com.openweathermap.pages.CurrentWeatherPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by beto on 17/11/15.
 */
public class CurrentWeatherPageNavigationTest extends SeleniumPropertiesSetUpTest{

  private static final Logger LOG = LoggerFactory.getLogger(CurrentWeatherPageNavigationTest.class);

  @Test
  public void verifyNavigationFromIndex(){
    CurrentWeatherPage page = new CurrentWeatherPage(driver);
    for(IndexLinkName item: IndexLinkName.values()){
      LOG.debug("Test item: {}",item);
      page.clickOnIndexLinkName(item);
      LOG.debug("Current URL: {}",driver.getCurrentUrl());
      Assert.assertEquals(initURL+"#"+item.getSection(),driver.getCurrentUrl());
    }

  }

  //This Test fails because the section id "one" is not present. Report the bug
  @Test
  public void verifyEachSectionFromIndex(){
    CurrentWeatherPage page = new CurrentWeatherPage(driver);
    for(IndexLinkName item: IndexLinkName.values()){
      boolean result = page.findSection(item);
      LOG.debug("Section id: {}, found: {}", item.getSection(), result);
      Assert.assertTrue(result);
    }

  }


}
