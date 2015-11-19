package mx.com.openweathermap.automation.base;

import mx.com.automation.facory.WebDriverFactoy;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by beto on 17/11/15.
 */
public class SeleniumPropertiesSetUpTest {

  private static final Logger LOG = LoggerFactory.getLogger(SeleniumPropertiesSetUpTest.class);

  protected WebDriver driver;
  protected Date date = new Date();

  @Rule
  public TestRule testWatcher = new TestWatcher() {
    @Override
    public void failed(Throwable t, Description test) {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      String screenshotName = test.getClassName()+"/"+test.getMethodName()+"/"+sdf.format(date) + ".png";
      File snapshot = new File(screenshotName);
      snapshot.mkdirs();
      if (driver instanceof TakesScreenshot) {
        File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
          FileUtils.copyFile(tempFile, snapshot);
        } catch (IOException e) {
          LOG.error("ERROR CREATING FILE: {}", snapshot.getAbsolutePath(), e);
        }
      }
    }
  };


  @Before
  public void setUpDriver(){
    ResourceBundle bundle = ResourceBundle.getBundle("openweathermap");
    String browser = bundle.getString("browser");
    String url = bundle.getString("url");

    driver = WebDriverFactoy.createDriver(browser);

    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

    driver.get(url);

  }

  @After
  public void closeDriver(){
    driver.close();
  }



}
