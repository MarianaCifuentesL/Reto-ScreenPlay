package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import ui.LoginPage;

public class MensajeErrorLogin implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
//        return Visibility.of(LoginPage.ERROR_BUTTON).viewedBy(actor).asBoolean();
        return Visibility.of(LoginPage.ERROR_BUTTON).answeredBy(actor).toString();
    }

    public static MensajeErrorLogin mensajeErrorLogin() {
        return new MensajeErrorLogin();
    }

}
