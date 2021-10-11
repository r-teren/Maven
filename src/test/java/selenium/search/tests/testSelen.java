package selenium.search.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import selenium.search.webpages.resultsPage;
import selenium.search.webpages.searchPage;
import java.util.concurrent.TimeUnit;


public class testSelen {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(testSelen.class.getName());


    @Before
    public void setup(){
        //usage of Chrome Driver
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //URL
        String searchURL = "https://google.com";
        driver.get(searchURL);
        log.info("Google search page opened;");


    }

    @Test
    public void TestPages () {

        searchPage googleSearch = new searchPage(driver);
        Assert.assertTrue(googleSearch.isTitleOk());
        log.info("Title Checked.Its Google;");
        googleSearch.searchSelenium();


        resultsPage selCount =new resultsPage(driver);
        selCount.results();

    }

    @After
    public void close() {
        driver.close();
        log.info("Browser closed;");
    }
}