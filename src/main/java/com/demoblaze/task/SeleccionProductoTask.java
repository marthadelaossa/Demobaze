package com.demoblaze.task;

import com.demoblaze.questions.ValidacionAlertaQuestion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HtmlAlert;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import static com.demoblaze.userInterface.PaginaCarritoUI.BTN_PUSRCHAE;
import static com.demoblaze.userInterface.PaginaInicioUI.*;
import static com.demoblaze.userInterface.PaginaProductoUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.assertj.core.api.Assertions.assertThat;


public class SeleccionProductoTask implements Task {
    String producto;
    String categoria;


    public SeleccionProductoTask(String producto, String categoria) {
        this.producto = producto;
        this.categoria = categoria;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
            String productoAValidar=null;
            actor.attemptsTo(
                    WaitUntil.the(LNK_CATEGORIAS(categoria), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(LNK_CATEGORIAS(categoria))
            );
            boolean clickProducto=false;
            while (!clickProducto){
                actor.attemptsTo(WaitUntil.the(LNK_PRODUCTOS, isClickable()).forNoMoreThan(30).seconds());
                if (LNK_PRODUCTO(producto).isVisibleFor(actor)){
                    productoAValidar=LNK_PRODUCTO(producto).resolveFor(actor).getText();
                    actor.attemptsTo(
                            Scroll.to(LNK_PRODUCTO(producto)).andAlignToBottom(),
                            Click.on(LNK_PRODUCTO(producto)));
                    clickProducto=true;
                }else if (BTN_NEXT.isVisibleFor(actor)){
                    actor.attemptsTo(
                            Scroll.to(BTN_NEXT).andAlignToBottom(),
                            Click.on(BTN_NEXT));
                }else{
                    Serenity.recordReportData().withTitle("No se encontro el producto "+producto+" dentro de la categoria "+categoria )
                            .andContents("No se encontro el producto "+producto+" dentro de la categoria "+categoria );
                    Assert.fail ("No se encontro el producto "+producto+" dentro de la categoria "+categoria );
                }
            }
        actor.attemptsTo(
                WaitUntil.the(BTN_ADD_CART, isClickable()).forNoMoreThan(30).seconds()
        );
        Ensure.that( productoAValidar).equals(LBL_PRODUCTO.resolveFor(actor).getText());
        actor.remember("nombreProducto", productoAValidar);
        actor.attemptsTo( Click.on(BTN_ADD_CART));
        Assert.assertTrue("Validacion Mensaje Alerta", actor.asksFor(ValidacionAlertaQuestion.ir("Product added.")));



    }
public static Performable ir (String producto, String categoria) {
        return Instrumented.instanceOf(SeleccionProductoTask.class).withProperties(producto, categoria);
    }
}