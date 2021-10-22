package selenium.search.webpages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.util.List;


public class resultsPage {
    private static final Logger log = LogManager.getLogger(searchPage.class.getName());
    private final WebDriver driver;


    @FindBy(xpath = "//*[contains (text(),'Selenium') or contains (text(), 'selenium')]")
    private List<WebElement> containSelenium;


    public resultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void results() {
        String pageTitle = driver.getTitle();
        System.out.println("\n" + containSelenium.size() + " Web elements contain text 'Selenium' for page " + "'"
                + pageTitle + "'\n");

        log.info("Results printed;");

    }

    public void screenSh() throws Exception {
        String filename = getRandomString(5) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        log.info("Screenshot taken;");

    }

    public static String getRandomString(int length) {
        StringBuilder stBuilder = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            stBuilder.append(characters.charAt(index));
        }
        return stBuilder.toString();

    }
}













