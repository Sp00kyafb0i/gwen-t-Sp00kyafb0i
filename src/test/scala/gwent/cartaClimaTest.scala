package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.Cartas.cartaClima
import munit.FunSuite

class cartaClimaTest extends FunSuite {
  val nombre: String = "Test"
  val nombre2: String = "Test2"

  var carta: cartaClima = _
  var carta2: cartaClima = _
  var carta3: cartaClima = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta = new cartaClima(nombre)
    carta2 = new cartaClima(nombre)
    carta3 = new cartaClima(nombre2)
  }


  test("A weather card can be created with a name") {
    assertEquals(new cartaClima(nombre), carta)
  }

  test("A weather card must be able to return it's name") {
    assertEquals(carta3.getNombre(), nombre2)
  }

  test("A weather card must be a cartaClima class") {
    carta.equals(nombre)
  }

  test("Two weather cards with the same name should be the same") {
    assertEquals(carta, carta2)
    assertEquals(carta2, carta)
    assertNotEquals(carta, carta3)
    assertEquals(carta.hashCode(), carta2.hashCode())
    assertNotEquals(carta.hashCode(), carta3.hashCode())
  }
}
