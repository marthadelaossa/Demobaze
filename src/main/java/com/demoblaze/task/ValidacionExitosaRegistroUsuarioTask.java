package com.demoblaze.task;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.HtmlAlert;
import net.serenitybdd.screenplay.actions.Switch;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidacionExitosaRegistroUsuarioTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    Switch.toAlert()
            );
            Serenity.takeScreenshot();
            assertThat(actor.asksFor(HtmlAlert.text())).isEqualTo("Sign up successful.");
            actor.attemptsTo(Switch.toAlert().andAccept());
        }
    public static Performable ir () {
        return Instrumented.instanceOf(ValidacionExitosaRegistroUsuarioTask.class).withProperties();
    }
}