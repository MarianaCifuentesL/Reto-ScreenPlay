package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.OverViewPage;

public class FinalizarCompra implements Task {

    public static FinalizarCompra finalizarCompra() {
        return Tasks.instrumented(FinalizarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OverViewPage.FINISH_BUTTON)
        );
    }
}
