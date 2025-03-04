package stepsdefinitions;

import hook.AbrirNavegador;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import questions.MensajeErrorLogin;
import tasks.IniciarSesionBloqueada;
import static constants.Constantes.*;

public class LockedUserStepDefinition {

    @Dado("el usuario está en la página de inicio de sesión")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                AbrirNavegador.abrirNavegador(URL)
        );
    }

    @Cuando("intenta iniciar sesión con el usuario {string} y la contraseña {string}")
    public void intentaIniciarSesiónConElUsuarioYLaContraseña(String usuario, String contraseña) {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                IniciarSesionBloqueada.iniciarSesionBloqueada(usuario, contraseña)
        );
    }

    @Entonces("debería ver un mensaje de error que dice {string}")
    public void deberíaVerUnMensajeDeErrorQueDice(String mensajeEsperado) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Ensure.that(MensajeErrorLogin.texto()).isEqualTo(mensajeEsperado)
        );
    }
}
