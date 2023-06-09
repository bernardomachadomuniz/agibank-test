import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogdoagiSearchTest {
    public static void main(String[] args) {
        // Set system property for Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to website
        driver.get("https://blogdoagi.com.br/");

        // Find the search icon and click on it
        WebElement searchIcon = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'search-toggle')]")));
        searchIcon.click();

        // Find the search input field and type "Produto"
        WebElement searchInput = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-input']")));
        searchInput.sendKeys("Produto");

        // Find the search button and click on it
        WebElement searchButton = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='search-button']")));
        searchButton.click();

        // Verify that search results contain the text "Produto"
        WebElement searchResults = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='search-title']")));
        String searchResultsText = searchResults.getText();
        if (searchResultsText.contains("Produto")) {
            System.out.println("Search results contain 'Produto'");
        } else {
            System.out.println("Search results do not contain 'Produto'");
        }

        // Quit driver
        driver.quit();
    }
}
