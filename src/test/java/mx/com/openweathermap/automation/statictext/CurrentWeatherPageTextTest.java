package mx.com.openweathermap.automation.statictext;

import mx.com.openweathermap.automation.base.SeleniumPropertiesSetUpTest;
import mx.com.openweathermap.dto.IndexItem;
import mx.com.openweathermap.pages.CurrentWeatherPage;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by betob_000 on 21/11/2015.
 */
public class CurrentWeatherPageTextTest extends SeleniumPropertiesSetUpTest{

  private static final Logger LOG = LoggerFactory.getLogger(CurrentWeatherPageTextTest.class);
  private final ResourceBundle bundle = ResourceBundle.getBundle("currentWeatherMapPage");

  @Test
  public void verifySuperiorDescriptionText(){
    final String expected = bundle.getString("superior.description");
    CurrentWeatherPage page = new CurrentWeatherPage(driver);

    Assert.assertEquals(expected,page.getSuperiorDescription());
  }

  @Test
  public void verifyIndexText(){
    CurrentWeatherPage page = new CurrentWeatherPage(driver);
    List<IndexItem> indexContents = page.getIndexContent();

    Assert.assertEquals(5, indexContents.size());


    for(int i=0;i<indexContents.size();i++){
      IndexItem item = indexContents.get(i);
      String key="index.titles."+i;
      String title = bundle.getString(key);
      LOG.debug("key: {}, value: {}", key, title);
      Assert.assertEquals(title, item.getTitle());
      List<IndexItem> childs = item.getChilds();
      if(childs != null){
        for(int j=0;j<childs.size();j++){
          IndexItem subitem = childs.get(j);
          String subkey="index.titles."+i+"."+j;
          String subtitle = bundle.getString(subkey);
          LOG.debug("key: {}, value: {}", subkey, subtitle);
          Assert.assertEquals(subtitle, subitem.getTitle());
        }

      }
    }
  }

}
