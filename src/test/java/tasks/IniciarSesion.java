package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.LoginPage;

public class IniciarSesion implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(IniciarSesion.class);
    private String usuario;
    private String contraseña;

    public IniciarSesion(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static IniciarSesion iniciarSesion(String usuario, String contraseña) {
        return Tasks.instrumented(IniciarSesion.class, usuario, contraseña);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Iniciando sesión con credenciales asignadas");
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USER_INPUT),
                Enter.theValue(contraseña).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
        LOGGER.info("Inicio de sesión exitoso");
    }
}
