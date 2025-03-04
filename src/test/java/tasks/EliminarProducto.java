package tasks;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.steps.ClickSteps;
import ui.CartPage;
import ui.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EliminarProducto implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(EliminarProducto.class);
    private final String producto;

    @Steps
    private ClickSteps clickSteps;

    public EliminarProducto(String producto) {
        this.producto = producto;
    }

    public static EliminarProducto eliminarProducto(String producto) {
        return Tasks.instrumented(EliminarProducto.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        clickSteps.clickOn(actor, ProductsPage.CAR_ICON);
        clickSteps.clickOn(actor, CartPage.removeProductButton(producto));
        LOGGER.info("{} eliminó el producto '{}' del carrito", actor.getName(), producto);
    }
}
