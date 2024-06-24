package com.demoblaze.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaCarritoUI extends PageObject {

    public static final Target BTN_PLACE_ORDER = Target.the("Boton Place Order").locatedBy("//button[@class='btn btn-success']");

    public static Target LBL_PRODUCTO(String producto) {
        return Target.the("Label Producto "+producto).locatedBy("//td[contains(text(), '" +producto+"')]");
    }

    public static final Target POPUP_COMPRA = Target.the("PopUp Datos Compra").locatedBy("//div[@id='orderModal']");


    public static final Target INPUT_NAME = Target.the("Input Name").locatedBy("//input[@id='name']");
    public static final Target INPUT_COUNTRY = Target.the("Input Country ").locatedBy("//input[@id='country']");
    public static final Target INPUT_CITY = Target.the("Input City").locatedBy("//input[@id='city']");
    public static final Target INPUT_CREDIT_CARD= Target.the("Input Credit Card").locatedBy("//input[@id='card']");

    public static final Target INPUT_MONTH = Target.the("Input Month").locatedBy("//input[@id='month']");
    public static final Target INPUT_YEAR= Target.the("Input Year").locatedBy("//input[@id='year']");

    public static final Target BTN_PUSRCHAE = Target.the("Boton Purchase").locatedBy("//button[@class='btn btn-primary'][ancestor::*[@id='orderModal']]");

    public static final Target LBL_COMPRA = Target.the("Label Compra Realizada").locatedBy("//h2[contains(text(),'Thank you for your purchase!')]");

    public static final Target BTN_OK = Target.the("Boton OK").locatedBy("//button[contains(text(),'OK')]");


    public static final Target LNK_LOG_OUT = Target.the("Link Menu Log Out").locatedBy("//a[@onclick='logOut()']");

}
