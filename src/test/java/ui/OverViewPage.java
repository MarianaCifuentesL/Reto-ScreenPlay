package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class OverViewPage {

    public static final Target FINISH_BUTTON = Target.the("Botón para finalizar la compra")
            .located(By.id("finish"));

    public static final Target MENSAJE_CONFIRMACION = Target.the("Mensaje de confirmación de la compra")
            .locatedBy("//h2[text()='Thank you for your order!']");
}
