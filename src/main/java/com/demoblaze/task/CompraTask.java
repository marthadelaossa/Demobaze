package com.demoblaze.task;

import com.demoblaze.enums.Datos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.demoblaze.enums.Datos.*;

import static com.demoblaze.userInterface.PaginaCarritoUI.*;
import static com.demoblaze.userInterface.PaginaProductoUI.LNK_MENU_CART;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class CompraTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
            String productoAValidar=actor.recall("nombreProducto");
            actor.attemptsTo(Click.on(LNK_MENU_CART));

        actor.attemptsTo(
                    WaitUntil.the(LBL_PRODUCTO(productoAValidar),  isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_PLACE_ORDER)
            );

        actor.attemptsTo(
                WaitUntil.the(POPUP_COMPRA, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(valor(NAME)).into(INPUT_NAME),
                Enter.theValue(valor(COUNTRY)).into(INPUT_COUNTRY),
                Enter.theValue(valor(CITY)).into(INPUT_CITY),
                Enter.theValue(valor(CARD)).into(INPUT_CREDIT_CARD),
                Enter.theValue(valor(MONTH)).into(INPUT_MONTH),
                Enter.theValue(valor(YEAR)).into(INPUT_YEAR),
                Scroll.to(BTN_PUSRCHAE).andAlignToBottom(),
                Click.on(BTN_PUSRCHAE)
        );

        actor.attemptsTo(
                WaitUntil.the(LBL_COMPRA,  isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_OK)
        );
    }
public static Performable ir () {
        return Instrumented.instanceOf(CompraTask.class).withProperties();
    }
}