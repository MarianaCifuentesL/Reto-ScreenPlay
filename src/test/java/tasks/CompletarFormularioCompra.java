package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.CheckoutPage;

public class CompletarFormularioCompra implements Task {

    private String nombre;
    private String apellido;
    private String codigoPostal;

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
        actor.attemptsTo(
                Enter.theValue(nombre).into(CheckoutPage.NAME_INPUT),
                Enter.theValue(apellido).into(CheckoutPage.LASTNAME_INPUT),
                Enter.theValue(codigoPostal).into(CheckoutPage.POSTALCODE_INPUT),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}
