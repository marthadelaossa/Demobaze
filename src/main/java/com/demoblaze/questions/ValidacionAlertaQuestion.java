package com.demoblaze.questions;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.HtmlAlert;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilExpectation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidacionAlertaQuestion implements Question<Boolean> {


    String mensaje;

    public ValidacionAlertaQuestion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        actor.attemptsTo(
                Switch.toAlert());
        Serenity.takeScreenshot();
        assertThat(actor.asksFor(HtmlAlert.text())).isEqualTo(mensaje);
        actor.attemptsTo(Switch.toAlert().andAccept());
        return true;
    }

    public static Question<Boolean> ir (String mensaje){
        return new ValidacionAlertaQuestion(mensaje);
    }

}
