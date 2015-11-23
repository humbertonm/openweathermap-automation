package mx.com.openweathermap.pages;

import mx.com.openweathermap.components.MiniNavBar;
import mx.com.openweathermap.dto.IndexItem;
import mx.com.openweathermap.dto.IndexLinkName;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beto on 17/11/15.
 */
public class CurrentWeatherPage {

  private static final Logger LOG = LoggerFactory.getLogger(CurrentWeatherPage.class);

  private MiniNavBar miniNavBar;
  private WebDriver driver;

  private final By superiorDesc = By.className("lead");
  private final By indexContainer = By.xpath("/html/body/div[4]/div[2]/div/div/div/div[2]");
  private final By list = By.xpath("./ul");
  private final By listItem = By.xpath("./li");
  private final By linkItem = By.xpath("./a");

  public CurrentWeatherPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getSuperiorDescription(){
    return driver.findElement(superiorDesc).getText();
  }

  public List<IndexItem> getIndexContent(){
    WebElement indexContainerElement = driver.findElement(indexContainer);
    return fill(indexContainerElement, 1, 2);
  }

  private List<IndexItem> fill(WebElement indexContainerElement, int actualDeep, int maxDeep){
    if(actualDeep > maxDeep){
      return null;
    }
    actualDeep++;
    WebElement listElement = null;
    try{
      listElement = indexContainerElement.findElement(list);
    }catch (Exception e){
      LOG.error("Component {} not found!!!", list,e);
      return null;
    }
    List<IndexItem> items = new ArrayList<>();

    List<WebElement> titles = listElement.findElements(listItem);
    for(WebElement title : titles){
      IndexItem titleItem = new IndexItem();
      WebElement linkElement = title.findElement(linkItem);
      titleItem.setLinkReference(linkElement.getAttribute("href"));
      titleItem.setTitle(linkElement.getText());
      titleItem.setChilds(fill(title, actualDeep, maxDeep));
      LOG.debug("Element read: {}", titleItem);
      items.add(titleItem);
    }
    return items;
  }

  public void clickOnIndexLinkName(IndexLinkName indexLinkName){
    WebElement indexContainerElement = driver.findElement(indexContainer);
    WebElement link = indexContainerElement.findElement(By.linkText(indexLinkName.getIndexLinkName()));
    WebElement superiorDescElement = driver.findElement(superiorDesc);
    //Move to container for link visible. In other case, try to click the link but click another menu.
    new Actions(driver).moveToElement(superiorDescElement).perform();
    LOG.debug("Link: {}, Displayed: {}",indexLinkName.getIndexLinkName(), link.isDisplayed());
    link.click();
  }

  public boolean findSection(IndexLinkName indexLinkName){
    try {
      driver.findElement(By.id(indexLinkName.getSection()));
      return true;
    }catch (NoSuchElementException | TimeoutException e){
      return false;
    }


  }

}
