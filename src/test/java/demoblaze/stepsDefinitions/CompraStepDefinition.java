package demoblaze.stepsDefinitions;



import com.demoblaze.task.CompraTask;
import com.demoblaze.task.SeleccionProductoTask;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;

public class CompraStepDefinition {

    @Y("^el usuario agraga al carrito un (.*) de la (.*)$")
    public void elUsuarioAgragaAlCarritoUnDeLa(String producto,String categoria) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionProductoTask.ir(producto,categoria));
    }

    @Entonces("el realiza la compra exitosamente desde el carrito")
    public void elRealizaLaCompraExitosamenteDesdeElCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(CompraTask.ir());

    }

}
