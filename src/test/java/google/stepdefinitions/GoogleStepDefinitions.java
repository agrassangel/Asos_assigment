package google.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;

public class GoogleStepDefinitions {
    @Steps
    private GoogleDefinitons googleDefinitons;


    @Given("{actor} is on Google home page")
    public void user_is_on_google_home_page(Actor actor) {
        googleDefinitons.user_is_on_google_home_page(actor);
    }

    @When("{actor} introduces the search criteria {string}")
    public void user_introduces_the_search_criteria(Actor actor, String criteria) {
        googleDefinitons.introduceSearchCriteria(actor, criteria);
    }

    @When("{actor} hit on ENTER key")
    public void user_hit_on_enter_key(Actor actor) {
        googleDefinitons.enterKeyvalue(actor);

    }

    @Then("Google should redirect to result web page")
    public void google_should_redirect_to_result_web_page() {
        googleDefinitons.checkResultPage();

    }

    @Then("The total of results should be match the conditions allowed {string} and {string}")
    public void the_total_of_results_should_be_match_the_conditions_allowed_and(String less_than_results, String more_than_results) {
        googleDefinitons.validateTotalResults(Double.parseDouble(less_than_results), Double.parseDouble((more_than_results)));
    }
}
