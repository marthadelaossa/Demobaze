#language: es
Característica: CASO2 Proceso de Compra

  @CASO2 @registroCorrectoUsuario @Demoblaze
  Esquema del escenario: Compra Exitosa de Usuario
    Dado       que el usuario se encuentra en la pagina <navegador> <url>
    Cuando     el usuario inicia sesion <usuario> <clave>
    Y          el usuario agraga al carrito un <producto> de la <categoria>
    Entonces   el realiza la compra exitosamente desde el carrito

      Ejemplos:
      | navegador | url|usuario | clave | producto | categoria|
      |chrome|https://www.demoblaze.com|juanitoerez@gmail.com|j123456| Sony vaio i5| Laptops |



