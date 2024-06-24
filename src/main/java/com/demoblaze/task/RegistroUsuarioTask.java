package com.demoblaze.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.demoblaze.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class RegistroUsuarioTask implements Task {
    String correo;
    String clave;


    public RegistroUsuarioTask(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(LNK_MENU_SIGNUP, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LNK_MENU_SIGNUP),
                    WaitUntil.the(POPUP_SIGNUP, isClickable()).forNoMoreThan(30).seconds(),
                    Enter.theValue(correo).into(INPUT_USERNAME_SIGNUP),
                    Enter.theValue(clave).into(INPUT_PASSWORD_SIGNUP),
                    Click.on(BTN_SIGNUP)
            );
        }
public static Performable ir (String correo, String clave) {
        return Instrumented.instanceOf(RegistroUsuarioTask.class).withProperties(correo, clave);
    }
}