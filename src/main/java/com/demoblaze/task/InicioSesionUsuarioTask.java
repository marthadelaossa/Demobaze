package com.demoblaze.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demoblaze.userInterface.PaginaInicioUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class InicioSesionUsuarioTask implements Task {
    String correo;
    String clave;


    public InicioSesionUsuarioTask(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    WaitUntil.the(LNK_MENU_LOGIN, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LNK_MENU_LOGIN),
                    WaitUntil.the(POPUP_LOGIN, isClickable()).forNoMoreThan(30).seconds(),
                    Enter.theValue(correo).into(INPUT_USERNAME_LOGIN),
                    Enter.theValue(clave).into(INPUT_PASSWORD_LOGIN),
                    Click.on(BTN_LOGIN)
            );

        actor.attemptsTo(
                WaitUntil.the(LBL_WELCOME(correo), isVisible()).forNoMoreThan(30).seconds()
        );

    }
public static Performable ir (String correo, String clave) {
        return Instrumented.instanceOf(InicioSesionUsuarioTask.class).withProperties(correo, clave);
    }
}