package google.pages;

import google.stepdefinitions.ElementPosition;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

public class GoogleResultPage extends GooglePage {
    private String stactsId = "result-stats";

    public GoogleResultPage() {
        super();
    }

    /**
     * Method will return the input By object selector
     *
     * @return By
     */
    @Override
    public By getGoogleSearchInput() {
        return getByOfAnElement(By.tagName("input"), By.xpath("//img[@alt='Google']"), ElementPosition.toRightOf);

    }

    /**
     * Method will extract the Totals of results from the description
     * @return
     */
    public Double getResultStatsTotal() {
        String text = $(By.id(stactsId)).getText();
        String total_results = text.split(" ")[1].replaceAll(",", "");
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        Assert.assertTrue("TThe value for the total result is not numeric:".concat(total_results), pattern.matcher(total_results).matches());

        return Double.parseDouble(total_results);
    }
}
