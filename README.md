# Demoblaze

PRUEBA TECNICA AUTOMATIZACION DE PRUEBAS (WEB)
Requisitos de entrega:
1. Uso del lenguaje Java
2. Uso de Serenity BDD.
3. Uso de patrón de diseño de automatización a su elección
4. Uso de Gradle/Maven a su elección
5. Uso de la herramienta Cucumber
6. La automatización debe ser capaz de ejecutarse en los navegadores Chrome y Firefox.
7. Subir la automatización a un repositorio de GitHub.
   Ingresar a la página https://www.demoblaze.com/

### Caso de uso:
*Realizar el registro de un nuevo usuario en la pagina Product Store.
*Realizar una compra, añadiendo productos al carrito.

NOTA. Tenga en cuenta que, su automatización debe ser genérica, es decir, el flujo funcional realizar
una compra, tiene diferentes categorias (Phones, Laptops, Monitors) y dentro de estas categorias
están los productos asociados a estas categorias, su automatización debe ser capaz de seleccionar
una categoria, y un producto, dependendiendo de los datos de entrada de la automatización, por
ejemplo: Sí quiero añadir un producto, de la categoria Phone, y que sea un producto Samsung,
entonces, su automatización debe ser capaz de seleccionar la categoria Phone, y solamente
producto Samsung. Asi mismo, si quiero nuevamente ejecutar su automatización, pero ahora deseo
seleccionar la categoria Laptops, y producto Sony, su automatización debe ir a esta categoria
mencionada, y seleccionar solamente producto Sony.
Por lo tanto, la automatización de este flujo de realizar una compra, debe recibir datos de entrada,
los cuales debe saber utilizar para seleccionar la categoria y el producto a elegir.


## Patron de Diseño Utilizado
* ScreenPlay

## Features
* Dentro de cada Feature en los ejemplos, los datos de pueden inyectar diretamente al escenario. La primera fila son los nombres de las variables y las siguientes filas los valores de las mismas.
* Si se desea cambiar los datos de entrada (categoria y producto), solo es necesario cambiar los valores de las variables (segunda Fila) o agregar otra linea de valores, lo que ejecutara dos veces el escenario con cada valor correspondiente de variables.
* De igual forma, el navegador a usar en cada caso, esta parametrizado en el feature, y para cambiarlo entre las opciones solicitadas, solo es necesario en los ejemmplos  cambiar el valor de la variable "navegador" por : "firefox" o "chrome", según su elección.
