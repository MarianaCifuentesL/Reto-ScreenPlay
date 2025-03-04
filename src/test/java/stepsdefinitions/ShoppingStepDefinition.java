package stepsdefinitions;

import hook.AbrirNavegador;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.MensajeConfirmacionCompra;
import tasks.*;
import java.util.Collections;
import java.util.List;

import static constants.Constantes.*;

public class ShoppingStepDefinition {

    @Dado("un usuario ingresó a la página principal de Swag Labs")
    public void unUsuarioIngresóALaPáginaPrincipalDeSwagLabs() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                AbrirNavegador.abrirNavegador(URL));
    }

    @Y("inició sesión con el usuario {string} y la contraseña {string}")
    public void inicióSesiónConElUsuarioYLaContraseña(String usuario, String contraseña) {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                IniciarSesion.iniciarSesion(usuario, contraseña));
    }

    @Cuando("ordena los productos por {string}")
    public void ordenaLosProductosPor(String criterio){
        OnStage.theActorCalled(ACTOR).attemptsTo(OrdenarProductos.ordenarProductos(criterio));
    }

    @Y("agrega los siguientes productos al carrito:")
    public void agregaLosSiguientesProductosAlCarrito(io.cucumber.datatable.DataTable productos) {
        List<String> nombresDeProductos = productos.asList(String.class).subList(1, productos.asList().size());
        nombresDeProductos.forEach(producto -> {
            OnStage.theActorCalled(ACTOR).attemptsTo(AgregarProductos.agregarProductos(Collections.singletonList(producto)));
        });
    }

    @Y("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String producto) {
        OnStage.theActorCalled(ACTOR).attemptsTo(EliminarProducto.eliminarProducto(producto));
    }

    @Y("procede al checkout")
    public void procedeAlCheckout() {
        OnStage.theActorCalled(ACTOR).attemptsTo(HacerCheckout.hacerCheckout());
    }

    @Y("completa el formulario de compra con los datos:")
    public void completarFormulario(io.cucumber.datatable.DataTable datos) {
        var datosFormulario = datos.asMaps().get(0);
        OnStage.theActorCalled(ACTOR).attemptsTo(CompletarFormularioCompra
                .completarFormularioCompra(
                datosFormulario.get("Nombre"),
                datosFormulario.get("Apellido"),
                datosFormulario.get("Código Postal")
        ));
    }

    @Y("finaliza la compra")
    public void finalizaLaCompra() {
        OnStage.theActorCalled(ACTOR).attemptsTo(FinalizarCompra.finalizarCompra());
    }

    @Entonces("debería ver el mensaje {string} confirmando la compra")
    public void deberíaVerElMensajeConfirmandoLaCompra(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MensajeConfirmacionCompra.texto()).isEqualTo(mensajeEsperado)
        );
    }
}
