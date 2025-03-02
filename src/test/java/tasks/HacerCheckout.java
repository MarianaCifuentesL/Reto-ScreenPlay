package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.CarPage;

public class HacerCheckout implements Task {


    public static HacerCheckout hacerCheckout() {
        return Tasks.instrumented(HacerCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CarPage.CHECKOUT_BUTTON)
        );
    }
}
