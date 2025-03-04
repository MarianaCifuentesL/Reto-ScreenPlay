package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.LoginPage;

public class MensajeErrorLogin implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MensajeErrorLogin.class);

    @Override
    public String answeredBy(Actor actor) {

        String mensajeError = Text.of(LoginPage.ERROR_MESSAGE).asString().answeredBy(actor);

        if (mensajeError.isEmpty()) {
            LOGGER.warn(
                    "{} no encontró ningún mensaje de error en el elemento '{}'",
                    actor.getName(),
                    LoginPage.ERROR_MESSAGE.getName()
            );
        } else {
            LOGGER.info(
                    "{} verificó que el mensaje de error '{}' se encuentra en el elemento '{}'",
                    actor.getName(),
                    mensajeError,
                    LoginPage.ERROR_MESSAGE.getName()
            );
        }
        return mensajeError;
    }

    public static MensajeErrorLogin texto() {
        return new MensajeErrorLogin();
    }
}
