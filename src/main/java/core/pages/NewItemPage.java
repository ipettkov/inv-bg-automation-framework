package core.pages;

import core.pages.base.BaseUIPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class NewItemPage extends BaseUIPage {
    private final static By NAME_OF_ITEM_FILED = By.cssSelector("input[name='name']");
    private final static By ITEM_PRICE_FIELD = By.cssSelector("input[name='price']");
    private final static By SUBMIT_BUTTON = By.cssSelector("input[type='submit'][name='do_submit']");
    private final static String SUCCESSFUL_CREATION_MESSAGE = "Артикулът е добавен успешно.";
    private final static String SUCCESSFUL_UPDATE_MESSAGE = "Информацията е редактирана успешно.";



    public NewItemPage(WebDriver driver) {
        super(driver);
    }


    public void createItem(String itemName, double itemPrice) {
        typeText(NAME_OF_ITEM_FILED, itemName);
        typeNumbers(ITEM_PRICE_FIELD, itemPrice);
        click(SUBMIT_BUTTON);
    }

    public void updateItem(String itemName, double itemPrice) {
        typeText(NAME_OF_ITEM_FILED, itemName);
        typeNumbers(ITEM_PRICE_FIELD, itemPrice);
        click(SUBMIT_BUTTON);
    }

    public void verifySuccessfulCreation() {
        assertEquals(getText(BaseUIPage.SUCCESS_MESSAGE_LOCATOR), SUCCESSFUL_CREATION_MESSAGE);
    }

    public void verifySuccessfulUpdate() {
        assertEquals(getText(BaseUIPage.SUCCESS_MESSAGE_LOCATOR), SUCCESSFUL_UPDATE_MESSAGE);
    }
}
