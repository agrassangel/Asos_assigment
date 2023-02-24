package google.pages;

import google.stepdefinitions.ElementPosition;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public abstract class GooglePage extends PageObject {

    public GooglePage() {
        super();
    }
    /**
     * Method will return the input By object selector
     * @return
     */
    public abstract By getGoogleSearchInput();

    /**
     * Method will return the input By object selector according to the
     * position target_element has from reference_element
     * @param target_element
     * @param reference_element
     * @param position
     * @return
     */
    public By getByOfAnElement(By target_element, By reference_element, ElementPosition position) {
        switch (position) {
            case toRightOf:
                return RelativeLocator.with(target_element).toRightOf(reference_element);
            case below:
                return RelativeLocator.with(target_element).below(reference_element);
            default:
                return reference_element;
        }

    }
}
