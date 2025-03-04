package tasks.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.steps.ScenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClickSteps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClickSteps.class);

    @Step("{0} hace clic en el botón '{1}'")
    public void clickOn(Actor actor, Target elemento) {
        LOGGER.info("{} hace clic en el botón '{}'", actor.getName(), elemento.getName());
        actor.attemptsTo(Click.on(elemento));
    }
}
