package google.pages;

import google.stepdefinitions.ElementPosition;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

@DefaultUrl("page:home.page")
public class GoogleHomePage extends GooglePage {
    private By googleLogo = By.xpath("//img[@alt='Google']");
    public GoogleHomePage() {
        super();

    }

    /**
     * Method will return the input By object selector
     * @return
     */
    public By getGoogleSearchInput() {
        return getByOfAnElement(By.tagName("input"), By.xpath("//img[@alt='Google']"), ElementPosition.below);
    }




}
