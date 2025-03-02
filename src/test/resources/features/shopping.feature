# language: es

Característica: Compra de productos en Swag Labs

  Escenario: Ordenar productos, agregar y eliminar del carrito, y completar la compra
    Dado el usuario ha iniciado sesión en Swag Labs
    Cuando ordena los productos por "Precio (de menor a mayor)"
    Y agrega los siguientes productos al carrito:
      | Producto                 |
      | Mochila Sauce Labs       |
      | Camiseta Sauce Labs Bolt |
    Y elimina el producto "Camiseta Sauce Labs Bolt" del carrito
    Y procede al checkout
    Y completa el formulario de compra con:
      | Nombre | Apellido | Código Postal |
      | Juan   | Pérez    | 12345         |
    Y finaliza la compra
    Entonces debería ver el mensaje "¡Gracias por tu orden!"
