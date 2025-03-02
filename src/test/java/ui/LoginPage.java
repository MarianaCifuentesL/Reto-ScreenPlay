package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target USER_INPUT = Target.the("Campo de usuario")
            .located(By.id("user-name"));

    public static final Target PASSWORD_INPUT = Target.the("Campo de contraseña")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("Botón de inicio de sesión")
            .located(By.id("login-button"));

    public static final Target ERROR_BUTTON = Target.the("Mensaje de error en el login")
            .locatedBy("//button [@class='error-button']");
//
//    public static final Target ERROR_MESSAGE = Target.the("Mensaje de error en el login")
//            .locatedBy("//h3[contains(text(), "sadface")]");
}
