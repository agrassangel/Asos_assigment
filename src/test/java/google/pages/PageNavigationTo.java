package google.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;

public class PageNavigationTo {

    public static Performable openBrowser(PageObject page, String message) {
        return Task.where(message, Open.browserOn().the(page));
    }


}
