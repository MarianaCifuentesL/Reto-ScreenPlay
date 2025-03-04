package tasks;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.steps.ClickSteps;
import tasks.steps.InputSteps;
import ui.CheckoutPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompletarFormularioCompra implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompletarFormularioCompra.class);
    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    @Steps
    private InputSteps inputSteps;

    @Steps
    private ClickSteps clickSteps;

    public CompletarFormularioCompra(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static CompletarFormularioCompra completarFormularioCompra(String nombre, String apellido, String codigoPostal) {
        return Tasks.instrumented(CompletarFormularioCompra.class, nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        inputSteps.enterText(actor, nombre, CheckoutPage.NAME_INPUT);
        inputSteps.enterText(actor, apellido, CheckoutPage.LASTNAME_INPUT);
        inputSteps.enterText(actor, codigoPostal, CheckoutPage.POSTALCODE_INPUT);
        clickSteps.clickOn(actor, CheckoutPage.CONTINUE_BUTTON);
        LOGGER.info("Formulario de compra completado");
    }
}
