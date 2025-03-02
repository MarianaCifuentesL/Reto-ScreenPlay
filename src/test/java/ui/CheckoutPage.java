package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target NAME_INPUT = Target.the("Campo de nombre")
            .located(By.id("first-name"));

    public static final Target LASTNAME_INPUT = Target.the("Campo de apellido")
            .located(By.id("last-name"));

    public static final Target POSTALCODE_INPUT = Target.the("Campo de código postal")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("Botón para continuar con la compra")
            .locatedBy("//input[@class='btn_primary cart_button']");

}
