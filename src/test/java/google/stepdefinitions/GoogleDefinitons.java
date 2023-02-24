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

    public void user_is_on_google_home_page(Actor actor) {
        actor.wasAbleTo(PageNavigationTo.openBrowser(googleHomePage, "navigating"));


    }


    public void introduceSearchCriteria(Actor actor, String criteria) {
        By element_by = googleHomePage.getGoogleSearchInput();
        actor.attemptsTo(Enter.theValue(criteria).into(element_by));
        Serenity.setSessionVariable("googleinput").to(element_by);
        Serenity.setSessionVariable("searchCriteria").to(criteria);
    }

    public void enterKeyvalue(Actor actor) {
        By element_by = (By) Serenity.sessionVariableCalled("googleinput");
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(element_by));
        Serenity.setSessionVariable("actor").to(actor);
    }

    public void checkResultPage() {
        Actor actor = (Actor) Serenity.sessionVariableCalled("actor");
        By element_by = googleResultPage.getGoogleSearchInput();
        String searchCriteria = ((String) Serenity.sessionVariableCalled("searchCriteria")).replace(' ', '+').toLowerCase();
//        Validate that the search criteria is still displayed in Input Search field
        actor.attemptsTo(Ensure.that(element_by).hasValue(searchCriteria));
        String url = googleResultPage.getDriver().getCurrentUrl();
//        Validate that the url contains the serach criteria
        actor.attemptsTo(Ensure.that(url.toLowerCase()).contains(searchCriteria));
    }

    public void validateTotalResults(Double less_than_results, Double more_than_results) {
        Double total_result = googleResultPage.getResultStatsTotal();
        Actor actor = (Actor) Serenity.sessionVariableCalled("actor");
//        Check that the value is greater than the min and max values introduced
        actor.attemptsTo(Ensure.that(total_result).isGreaterThanOrEqualTo(less_than_results).
                then(Ensure.that(total_result).isGreaterThanOrEqualTo(more_than_results)));


    }
}
