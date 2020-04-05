package core.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUIPage {
    protected WebDriver driver;
    private final static By NEW_FEATURE_OK_BUTT = By.cssSelector(".newFeatureOKbutton");
    protected static final By SUCCESS_MESSAGE_LOCATOR = By.id("okmsg");

    public BaseUIPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeText(By field, String text) {
        WebElement element = driver.findElement(field);
        element.clear();
        element.sendKeys(text);
    }

    protected void typeNumbers(By field, double price) {
        WebElement element = driver.findElement(field);
        element.clear();
        element.sendKeys(""+ price);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected String getText(By element) {
        return driver.findElement(element).getText().trim();
    }

    protected void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(driver -> driver.findElement(element).isDisplayed());
    }

    protected void dissmissNewFeatureOKButt() {
        try {
            WebElement okButtNewFeature = driver.findElement(NEW_FEATURE_OK_BUTT);

            if (okButtNewFeature.isDisplayed()) {
                okButtNewFeature.click();
            }
        } catch (NoSuchElementException e) {
        }
    }
}
