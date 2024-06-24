package com.demoblaze.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicioUI extends PageObject {

    public static final Target LNK_MENU_LOGIN = Target.the("Link Menu LogIn").locatedBy("//a[@id='login2']");
    public static final Target LNK_MENU_SIGNUP= Target.the("Link Menu SingUp").locatedBy("//a[@id='signin2']");
    public static final Target POPUP_LOGIN = Target.the("PopUp LogIn").locatedBy("//div[@id='logInModal']");
    public static final Target INPUT_USERNAME_LOGIN = Target.the("Input Usermame LogIn ").locatedBy("//input[@id='loginusername']");
    public static final Target INPUT_PASSWORD_LOGIN = Target.the("Input Password LogIn ").locatedBy("//input[@id='loginpassword']");
    public static final Target BTN_LOGIN = Target.the("Boton LogIn").locatedBy("//button[@onclick='logIn()']");
    public static final Target POPUP_SIGNUP = Target.the("PopUp SignUp").locatedBy("//div[@id='signInModal']");
    public static final Target INPUT_USERNAME_SIGNUP = Target.the("Input Usermame SignUp ").locatedBy("//input[@id='sign-username']");
    public static final Target INPUT_PASSWORD_SIGNUP = Target.the("Input Password SignUp ").locatedBy("//input[@id='sign-password']");
    public static final Target BTN_SIGNUP = Target.the("Boton SignUp").locatedBy("//button[@onclick='register()']");

    public static final Target LNK_PRODUCTOS = Target.the("Link Productos").locatedBy("//a[@class='hrefch']");

    public static Target LBL_WELCOME(String usuario) {
        return Target.the("LBL Welcome "+usuario).locatedBy("//a[contains(text(), 'Welcome " +usuario+"')]");
    }
    public static Target LNK_CATEGORIAS(String categoria) {
        return Target.the("Categoria "+categoria).locatedBy(" //a[contains(text(),'"+categoria+"')][parent::*[@class='list-group']]");
    }

    public static Target LNK_PRODUCTO(String producto) {
        return Target.the("Producto "+producto).locatedBy(" //a[contains(text(),'"+producto+"')][ancestor::*[@id='tbodyid']]");
    }

    public static final Target BTN_NEXT = Target.the("Boton Next").locatedBy("//button[@id='next2]");

}
