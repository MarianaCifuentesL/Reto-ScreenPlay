package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsPage {

    public static final Target SORT_SELECT = Target.the("Selector de orden de productos")
            .located(By.className("product_sort_container"));

    public static Target addToCartButton(String producto) {
        return Target.the("Botón para agregar el producto " + producto)
                .locatedBy("//div[@class='inventory_item_name' and contains(text(),'{0}')]/ancestor::div[@class='inventory_item']//button")
                .of(producto);
    }


    public static final Target CAR_ICON = Target.the("Icono del carrito de compras")
            .located(By.id("shopping_cart_container"));
}
