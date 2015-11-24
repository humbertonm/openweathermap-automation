package mx.com.openweathermap.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by beto on 17/11/15.
 */
public class MiniNavBar {

  private static Logger LOG = LoggerFactory.getLogger(MiniNavBar.class);

  private WebDriver driver;
  private final By miniNavBarContainer = By.xpath("//div[@class='mini-navbar mini-navbar-dark hidden-xs']");
  private final By emailLink = By.linkText("Email Us");
  private final By weatherInYourCityLink = By.id("nav-search");
  private final By singInLink = By.partialLinkText("Sign In");
  private final By singUpLink = By.partialLinkText("Sign Up");
  private final By unitsInput = By.id("units_check");
  private final By searchInput = By.id("q");
  private final By findButton = By.xpath("//form[@id='nav-search-form']//button[@type='submit']");

  public MiniNavBar(WebDriver driver){
    this.driver = driver;
  }

  public void searchWeatherInYourCity(String city){
    WebElement container = driver.findElement(miniNavBarContainer);
    WebElement weatherLinkElement = container.findElement(weatherInYourCityLink);
    weatherLinkElement.click();
    WebElement search = container.findElement(searchInput);
    search.clear();
    search.sendKeys(city);
    container.findElement(findButton).click();

  }

  public void navigateToSignIn(){
    driver.findElement(singInLink).click();
  }

  public void navigateToSignUp(){
    driver.findElement(singUpLink).click();
  }

  public void navigateToEmailUs(){
    String currentWin = driver.getWindowHandle();
    driver.findElement(emailLink).click();
    LOG.debug("Handlers: {}", driver.getWindowHandles());
    for(String winHandle: driver.getWindowHandles()){
      if(!currentWin.equals(winHandle)){
        driver.switchTo().window(winHandle);
        break;
      }
    }

  }

}
