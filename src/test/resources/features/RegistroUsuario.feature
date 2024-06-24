#language: es
Característica: CASO1 Registro de Usuario

  @CASO1 @registroCorrectoUsuario @Demoblaze
  Esquema del escenario: Registro Correcto de Usuario
    Dado       que el usuario se encuentra en la pagina <navegador> <url>
    Cuando     el usuario se registra como usuario <usuario> <clave>
    Entonces   el usuario valida la creacion del usuario exitoxamente

      Ejemplos:
      | navegador | url|usuario | clave|
      |firefox|https://www.demoblaze.com|juanitoerez@gmail.com|j123456|



