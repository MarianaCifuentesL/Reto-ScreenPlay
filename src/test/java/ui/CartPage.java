package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    public static Target removeProductButton(String producto) {
        return Target.the("Botón para eliminar el producto " + producto)
                .locatedBy("//div[text()='{0}']/ancestor::div[@class='cart_item']//button")
                .of(producto);
    }

    public static final Target CHECKOUT_BUTTON = Target.the("Botón para proceder al checkout")
            .locatedBy("//a[@class='btn_action checkout_button']");
}
