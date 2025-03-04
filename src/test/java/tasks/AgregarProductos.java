package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.ProductsPage;
import java.util.List;

public class AgregarProductos implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgregarProductos.class);
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
            LOGGER.info("Agregando producto al carrito: {}", producto);
            actor.attemptsTo(Click.on(ProductsPage.addToCartButton(producto)));
        }
        LOGGER.info("Productos añadidos al carrito exitosamente");
    }
}
