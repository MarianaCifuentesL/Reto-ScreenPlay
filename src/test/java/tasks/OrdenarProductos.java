package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import ui.ProductsPage;

public class OrdenarProductos implements Task {

    private String criterio;

    public OrdenarProductos(String criterio) {
        this.criterio = criterio;
    }

    public static OrdenarProductos ordenarProductos(String criterio) {
        return Tasks.instrumented(OrdenarProductos.class, criterio);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(criterio).from(ProductsPage.SORT_SELECT)
        );

    }
}
