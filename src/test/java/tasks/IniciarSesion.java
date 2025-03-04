package tasks;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import tasks.steps.ClickSteps;
import tasks.steps.InputSteps;
import ui.LoginPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IniciarSesion implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(IniciarSesion.class);
    private final String usuario;
    private final String contraseña;

    @Steps
    private InputSteps inputSteps;

    @Steps
    private ClickSteps clickSteps;

    public IniciarSesion(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static IniciarSesion iniciarSesion(String usuario, String contraseña) {
        return Tasks.instrumented(IniciarSesion.class, usuario, contraseña);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        inputSteps.enterText(actor, usuario, LoginPage.USER_INPUT);
        inputSteps.enterText(actor, contraseña, LoginPage.PASSWORD_INPUT);
        clickSteps.clickOn(actor, LoginPage.LOGIN_BUTTON);
    }
}
