package google.stepdefinitions;

import google.pages.GoogleHomePage;
import google.pages.GoogleResultPage;
import google.pages.PageNavigationTo;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleDefinitons {
    private GoogleHomePage googleHomePage;
    private GoogleResultPage googleResultPage;

    public GoogleDefinitons() {
        googleHomePage = new GoogleHomePage();
        googleResultPage = new GoogleResultPage();
    }

    /**
     * method to open the browser
     *
     * @param actor
     */
    public void user_is_on_google_home_page(Actor actor) {
        actor.wasAbleTo(PageNavigationTo.openBrowser(googleHomePage, "navigating"));


    }

    /**
     * This Method will insert the search criteria into the input field
     *
     * @param actor
     * @param criteria
     */
    public void introduceSearchCriteria(Actor actor, String criteria) {
        By element_by = googleHomePage.getGoogleSearchInput();
        actor.attemptsTo(Enter.theValue(criteria).into(element_by));
        Serenity.setSessionVariable("googleinput").to(element_by);
        Serenity.setSessionVariable("searchCriteria").to(criteria);
    }

    /**
     * This method will execute the search by hitting "Key ENTER" in the input field
     *
     * @param actor
     */
    public void enterKeyvalue(Actor actor) {
        By element_by = (By) Serenity.sessionVariableCalled("googleinput");
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(element_by));
        Serenity.setSessionVariable("actor").to(actor);
    }

    /**
     * This method will validate that the results shown in the page match with the search criteria
     */
    public void checkResultPage() {
        Actor actor = (Actor) Serenity.sessionVariableCalled("actor");
        By element_by = googleResultPage.getGoogleSearchInput();
        String searchCriteria = ((String) Serenity.sessionVariableCalled("searchCriteria")).replace(' ', '+').toLowerCase();
//        Validate that the search criteria is still displayed in Input Search field
        actor.attemptsTo(Ensure.that(element_by).hasValue(searchCriteria));
        String url = googleResultPage.getDriver().getCurrentUrl();
//        Validate that the url contains the search criteria
        actor.attemptsTo(Ensure.that(url.toLowerCase()).contains(searchCriteria));
    }

    /**
     * This method compares the totals of results using the input parameters as criteria
     * First: the Total Results should be greater than both inputs
     * Note: The expected output Classification  when Total is between the boundaries were not specified.
     *
     * @param less_than_results
     * @param more_than_results
     */
    public void validateTotalResults(Double less_than_results, Double more_than_results) {
        Double total_result = googleResultPage.getResultStatsTotal();
        Actor actor = (Actor) Serenity.sessionVariableCalled("actor");
//        Check that the value is greater than the min and max values introduced
        actor.attemptsTo(Ensure.that(total_result).isGreaterThanOrEqualTo(less_than_results).
                then(Ensure.that(total_result).isGreaterThanOrEqualTo(more_than_results)));


    }
}
