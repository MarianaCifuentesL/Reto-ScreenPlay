package tasks;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.steps.ClickSteps;
import ui.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class AgregarProductos implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgregarProductos.class);
    private final List<String> productos;

    @Steps
    private ClickSteps clickSteps;

    public AgregarProductos(List<String> productos) {
        this.productos = productos;
    }

    public static AgregarProductos agregarProductos(List<String> productos) {
        return Tasks.instrumented(AgregarProductos.class, productos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String producto : productos) {
            clickSteps.clickOn(actor, ProductsPage.addToCartButton(producto));
            LOGGER.info("{} agrega el producto '{}' al carrito", actor.getName(), producto);

        }
    }
}
