package selenium.search.webpages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class searchPage {
    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(searchPage.class.getName());

    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;


    public searchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*public  boolean isTitleOk () {
      //  return driver.getTitle().toString().contentEquals("Google");
    }*/

    public void verifyTitle() {
       // searchPage googleSearch = new searchPage(driver);
        //Assert.assertTrue(googleSearch.isTitleOk());
        String titleGoogle = (driver.getTitle());
        Assert.assertEquals(titleGoogle, "Google");
        log.info("Title Checked.Its Google;");
    }

    public void searchCriteria(String searchArg) {
        searchField.sendKeys(searchArg);
        searchButton.click();
        log.info("Searching for Selenium;");
    }
}


