# language: es

Característica: Funcionalidades de inicio de sesión y compra en Swag Labs

  Como usuario de Swag Labs
  Quiero probar el inicio de sesión y la compra de productos
  Para asegurarme de que el sistema funciona correctamente


  Esquema del escenario: Ordenar productos, agregar y eliminar del carrito, y completar la compra
    Dado un usuario ingresó a la página principal de Swag Labs
    Y inició sesión con el usuario "<usuario>" y la contraseña "<contraseña>"
    Cuando ordena los productos por "<criterioOrden>"
    Y agrega los siguientes productos al carrito:
      | Producto          |
      | <primerProducto>  |
      | <segundoProducto> |
    Y elimina el producto "<primerProducto>" del carrito
    Y procede al checkout
    Y completa el formulario de compra con los datos:
      | Nombre | Apellido | Código Postal |
      | <nombre> | <apellido> | <codigoPostal> |
    Y finaliza la compra
    Entonces debería ver el mensaje "<mensaje>" confirmando la compra

    Ejemplos:
      | usuario         | contraseña   | criterioOrden         | primerProducto         | segundoProducto      | nombre | apellido | codigoPostal | mensaje                         |
      | standard_user  | secret_sauce | Price (low to high)   | Sauce Labs Onesie      | Sauce Labs Bike Light | Juan   | Pérez    | 12345        | THANK YOU FOR YOUR ORDER       |



  Esquema del escenario: Intentar iniciar sesión con un usuario bloqueado
    Dado un usuario ingresó a la página principal de Swag Labs
    Cuando intenta iniciar sesión con el usuario "<usuario>" y la contraseña "<contraseña>"
    Entonces debería ver un mensaje de error que dice "<mensaje>"

    Ejemplos:
      | usuario          | contraseña     | mensaje                                             |
      | locked_out_user  | secret_sauce   | Epic sadface: Sorry, this user has been locked out. |
