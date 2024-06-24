package demoblaze.stepsDefinitions;


import com.demoblaze.driver.Driver;
import com.demoblaze.questions.ValidacionAlertaQuestion;
import com.demoblaze.task.InicioSesionUsuarioTask;
import com.demoblaze.task.RegistroUsuarioTask;
import com.demoblaze.task.ValidacionExitosaRegistroUsuarioTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Assert;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;


public class InicioSesionStepDefinition {

    @Before
    public void setStage() {setTheStage(new OnlineCast());
    }

    @Dado("^que el usuario se encuentra en la pagina (.*) (.*)$")
    public void queElUsuarioSeEncuentraEnLaPagina(String navegador,String url) {
        OnStage.theActorCalled("tester").can(BrowseTheWeb.with(Driver.getDriver(url,navegador)));

    }

    @Cuando("^el usuario se registra como usuario (.*) (.*)$")
    public void elUsuarioSeRegistraComoUsuario(String correo,String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(RegistroUsuarioTask.ir(correo,clave));
    }

    @Entonces("el usuario valida la creacion del usuario exitoxamente")
    public void elUsuarioValidaLaCreacionDelUsuarioExitoxamente() {
        Assert.assertTrue("Validacion Mensaje Alerta",OnStage.theActorInTheSpotlight().asksFor(ValidacionAlertaQuestion.ir("Sign up successful.")));
    }

    @Cuando("^el usuario inicia sesion (.*) (.*)$")
    public void elUsuarioIniciaSesion(String correo,String clave) {
        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionUsuarioTask.ir(correo,clave));

    }


}
