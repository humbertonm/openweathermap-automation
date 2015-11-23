package mx.com.automation.facory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by beto on 17/11/15.
 */
public class WebDriverFactoy {

  private static final Logger LOG = LoggerFactory.getLogger(WebDriverFactoy.class);

  public static WebDriver createDriver(String browser){
    WebDriver driver = null;
    try{
      switch (browser.toLowerCase()){
        case "firefox":
          driver = createFirefoxDriver();
          break;
        case "chrome":
          driver = createChromeDriver();
          break;
        default:
          LOG.info("Wrong option {}. Creating Firefox driver", browser);
          driver = createFirefoxDriver();
          break;
      }
    }catch (Exception e){
      LOG.error("Error creating driver {}", browser, e);
      return new FirefoxDriver();
    }
    return driver;
  }

  private static WebDriver createFirefoxDriver(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    return driver;
  }

  private static WebDriver createChromeDriver(){
    String os = System.getProperty("os.name").toLowerCase();
    String arch = System.getProperty("os.arch").toLowerCase();
    StringBuilder sb = new StringBuilder();
    sb.append("drivers/");
    if(os.contains("win")){
      sb.append("win/");
    }else {
      sb.append(os);
      if (arch.contains("64")) {
        sb.append("64/");
      } else {
        sb.append("32/");
      }
    }
    sb.append("chromedriver");
    if(os.contains("win")){
      sb.append(".exe");
    }
    String chromePath = sb.toString();
    System.setProperty("webdriver.chrome.driver", chromePath);

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-maximized");
    WebDriver driver = new ChromeDriver(chromeOptions);
    return driver;
  }

}
