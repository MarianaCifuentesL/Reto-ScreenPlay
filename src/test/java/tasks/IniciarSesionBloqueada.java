package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;

public class IniciarSesionBloqueada implements Task {

    private final String usuario;
    private final String contraseña;

    public IniciarSesionBloqueada(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static IniciarSesionBloqueada iniciarSesionBloqueada(String usuario, String contraseña) {
        return Tasks.instrumented(IniciarSesionBloqueada.class, usuario, contraseña);
    }

    @Override
    @Step("{0} intenta iniciar sesión con usuario bloqueado: #usuario AAAAAAAA")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginPage.USER_INPUT),
                Enter.theValue(contraseña).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
