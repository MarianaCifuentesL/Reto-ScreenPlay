package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.CartPage;
import ui.ProductsPage;

public class EliminarProducto implements Task {

    private String producto;

    public EliminarProducto(String producto) {
        this.producto = producto;
    }

    public static EliminarProducto eliminarProducto(String producto) {
        return Tasks.instrumented(EliminarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.CAR_ICON),
                Click.on(CartPage.removeProductButton(producto))
        );
    }
}
