package tasks.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.steps.ScenarioSteps;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputSteps extends ScenarioSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(InputSteps.class);

    @Step("{0} ingresa '{1}' en '{2}'")
    public void enterText(Actor actor, String value, Target campo) {
        LOGGER.info("{} ingresa '{}' en '{}'", actor.getName(), value, campo.getName());
        actor.attemptsTo(Enter.theValue(value).into(campo));
    }
}
