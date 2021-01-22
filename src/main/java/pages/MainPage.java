package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickQuery() {
        driver.findElement(By.name("btnK")).click();
    }

    public void typeQuery(String query) {
        driver.findElement(By.name("q")).sendKeys(query);
    }
}
