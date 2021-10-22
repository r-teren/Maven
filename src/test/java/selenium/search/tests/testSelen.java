package selenium.search.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.search.webpages.resultsPage;
import selenium.search.webpages.searchPage;

import java.util.concurrent.TimeUnit;


public class testSelen {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(testSelen.class.getName());


    @Before
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void TestPages() throws Exception {

        searchPage findSel = new searchPage(driver);
        findSel.getURL();
        findSel.verifyTitle();
        findSel.searchCriteria("Selenium");
        resultsPage countSel = new resultsPage(driver);
        countSel.results();
        countSel.screenSh();

    }

    @After
    public void close() {

        driver.close();
        log.info("Browser closed;");
    }

}


