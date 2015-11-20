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

  private String failDir;

  @Rule
  public TestRule testWatcher = new TestWatcher() {
    @Override
    public void failed(Throwable t, Description test) {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      String screenshotDir = failDir+"/"+test.getClassName()+"/"+test.getMethodName()+"/";
      String screenshotName = screenshotDir + sdf.format(date) + ".png";
      File screenshotDirFile = new File(screenshotDir);
      LOG.debug("creating directory: {}", screenshotDirFile.getAbsolutePath());
      screenshotDirFile.mkdirs();

      File screenshot = new File(screenshotName);

      if (driver instanceof TakesScreenshot) {
        try {
          File tempFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          LOG.debug("tmpFile: {}", tempFile.getAbsolutePath());

          FileUtils.copyFile(tempFile, screenshot);
        } catch (Exception e) {
          LOG.error("ERROR CREATING FILE: {}", screenshot.getAbsolutePath(), e);
        }
      }else{
        LOG.info("Screenshot not supported");
      }

    }
  };


  @Before
  public void setUpDriver(){
    ResourceBundle bundle = ResourceBundle.getBundle("openweathermap");
    String browser = bundle.getString("browser");
    String url = bundle.getString("url");
    this.failDir = bundle.getString("fail.screenshots.dir");

    driver = WebDriverFactoy.createDriver(browser);

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

    driver.get(url);

  }

  @After
  public void closeDriver(){
    for(String winHandle: driver.getWindowHandles()){
      driver.switchTo().window(winHandle).close();
    }
  }



}
