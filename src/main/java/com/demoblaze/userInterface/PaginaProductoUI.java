package com.demoblaze.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaProductoUI extends PageObject {

    public static final Target BTN_ADD_CART = Target.the("Boton Add to Cart").locatedBy("//a[@class='btn btn-success btn-lg']");
    public static final Target LNK_MENU_CART = Target.the("Link Menu Cart").locatedBy("//a[@id='cartur']");

    public static final Target LBL_PRODUCTO = Target.the("Label Producto").locatedBy("//h2[parent::*[@id='tbodyid']]");


}
