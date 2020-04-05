package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsPage extends BaseUIPage {
    private static final By ALL_ITEMS_LOC = By.cssSelector("a.faktura_id.selenium-invoice-item-name");
    private static final By DELETE_FOUND_ITEM_BUTT = By.id("delete-item-button");
    private static final By CREATE_NEW_ITEM = By.cssSelector("a.newbtn.selenium-add-item");
    private static final By EDIT_ITEM = By.cssSelector("form#delete-item-form + a");
    private static final String SUCCESSFUL_DELETE_TEXT = "Артикулът беше изтрит успешно.";



    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewItem() {
        click(CREATE_NEW_ITEM);
    }

    public void deleteItemByName(String itemName) {
        getItemByName(itemName).click();
        deleteItem();
    }

    public void editItemByName(String itemName) {
        getItemByName(itemName).click();
        driver.findElement(EDIT_ITEM).click();
    }

    public void verifyItemSuccessfulDeletion() {
        try {
            assertEquals(SUCCESSFUL_DELETE_TEXT, getText(BaseUIPage.SUCCESS_MESSAGE_LOCATOR));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public String getIdByItemName(String itemName) {
        String itemLink = getItemByName(itemName).getAttribute("href");
        return itemLink.substring(itemLink.lastIndexOf(":") + 1);
    }

    private WebElement getItemByName(String itemName) {
        List<WebElement> allItems = driver.findElements(ALL_ITEMS_LOC);
        return allItems.stream().filter(currItem -> currItem.getText().trim().equalsIgnoreCase(itemName)).findAny().orElse(null);
    }

    private void deleteItem() {
        driver.findElement(DELETE_FOUND_ITEM_BUTT).click();
        driver.switchTo().alert().accept();
    }
}




