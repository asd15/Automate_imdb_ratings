package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        driver.get("https://www.imdb.com/chart/top");
        // Wait until list is loaded Using Locator "Class" Name ipc-metadata-list ipc-metadata-list--dividers-between sc-3f13560f-0 sTTRj compact-list-view ipc-metadata-list--base
        Thread.sleep(3000);
        // Locate and click sort select Using Locator "ID" sort-by-selector
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        // Wait until option is visible Using Locator "Tag Name" option
        Thread.sleep(1000);
        // Select Option IMDb rating Using Locator "XPath" option
        Select selectDropDownRating = new Select(dropDown);
        selectDropDownRating.selectByVisibleText("IMDb rating");
        Thread.sleep(2000);
        // Get text from the element Using Locator "XPath" //ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3
        WebElement highestRatedMovie = driver.findElement(By.xpath("//ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3"));
        System.out.println("Highest Rated Movie: "+highestRatedMovie.getText());
        // Get count of elements Using Locator "XPath" //ul[contains(@class, 'ipc-metadata-list')]//li
        List<WebElement> movieList = driver.findElements(By.xpath("//ul[contains(@class, 'ipc-metadata-list')]//li"));
        System.out.println("Count of highest rated movies: "+movieList.size());
        // Locate and click sort select Using Locator "ID" sort-by-selector
        // Wait until option is visible Using Locator "Tag Name" option
        // Select Option release date Using Locator "XPath" //option[@value='RELEASE_DATE']
        selectDropDownRating.selectByVisibleText("Release date");
        Thread.sleep(2000);
        // Click Swap sort order button Using Locator "ID" swap-sort-order-button
        driver.findElementById("swap-sort-order-button").click();
        Thread.sleep(2000);
        // Get text from the element Using Locator "XPath" //ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3
        WebElement oldestMovie = driver.findElement(By.xpath("//ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3"));
        System.out.println("Oldest Movie: "+oldestMovie.getText());
        // Click Swap sort order button Using Locator "ID" swap-sort-order-button
        driver.findElementById("swap-sort-order-button").click();
        Thread.sleep(2000);
        // Get text from the element Using Locator "XPath" //ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3
        WebElement latestMovie = driver.findElement(By.xpath("//ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3"));
        System.out.println("Latest Movie: "+latestMovie.getText());
        // Select Option IMDb rating Using Locator "XPath" //option[@value='USER_RATING_COUNT']
        selectDropDownRating.selectByVisibleText("Number of ratings");
        // Get text from the element Using Locator "XPath" //ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3
        WebElement mostUserRatingMovie = driver.findElement(By.xpath("//ul[contains(@class, 'ipc-metadata-list')]//li[1]//h3"));
        System.out.println("Movie with most user ratings: "+mostUserRatingMovie.getText());
    }


}
