# language: es

Característica: Compra de productos en Swag Labs

  Escenario: Ordenar productos, agregar y eliminar del carrito, y completar la compra
    Dado el usuario ha iniciado sesión en Swag Labs
    Cuando ordena los productos por "Price (low to high)"
    Y agrega los siguientes productos al carrito:
      | Producto                 |
      | Sauce Labs Onesie       |
      | Sauce Labs Bike Light |
    Y elimina el producto "Sauce Labs Bike Light" del carrito
    Y procede al checkout
    Y completa el formulario de compra con:
      | Nombre | Apellido | Código Postal |
      | Juan   | Pérez    | 12345         |
    Y finaliza la compra
    Entonces debería ver el mensaje "THANK YOU FOR YOUR ORDER"
