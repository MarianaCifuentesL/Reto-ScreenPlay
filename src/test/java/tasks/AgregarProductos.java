package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.ProductsPage;

import java.util.List;

public class AgregarProductos implements Task {

    private List<String> productos;

    public AgregarProductos(List<String> productos) {
        this.productos = productos;
    }

    public static AgregarProductos agregarProductos(List<String> productos) {
        return Tasks.instrumented(AgregarProductos.class, productos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String producto : productos) {
            actor.attemptsTo(
                    Click.on(ProductsPage.addToCarButton(producto))
            );
        }
    }
}
