package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ui.OverViewPage.MENSAJE_CONFIRMACION;

public class MensajeConfirmacionCompra implements Question<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MensajeConfirmacionCompra.class);

    @Override
    public String answeredBy(Actor actor) {

        String mensajeConfirmacion = Text.of(MENSAJE_CONFIRMACION).answeredBy(actor);

        if (mensajeConfirmacion.isEmpty()) {
            LOGGER.warn(
                    "{} no encontró ningún mensaje de confirmación de compra en el elemento '{}'",
                    actor.getName(),
                    MENSAJE_CONFIRMACION.getName()
            );
        } else {
            LOGGER.info(
                    "{} verificó que el mensaje de confirmación '{}' se encuentra en el elemento '{}'",
                    actor.getName(),
                    mensajeConfirmacion,
                    MENSAJE_CONFIRMACION.getName()
            );
        }
        return mensajeConfirmacion;
    }

    public static MensajeConfirmacionCompra texto() {
        return new MensajeConfirmacionCompra();
    }
}
