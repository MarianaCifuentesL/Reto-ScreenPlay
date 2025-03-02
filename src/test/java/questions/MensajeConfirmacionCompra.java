package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static ui.OverViewPage.MENSAJE_CONFIRMACION;

public class MensajeConfirmacionCompra implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MENSAJE_CONFIRMACION).answeredBy(actor);
    }

    public static MensajeConfirmacionCompra texto() {
        return new MensajeConfirmacionCompra();
    }
}
