package cl.uchile.dcc
package gwent

import munit.FunSuite





class TestJugador extends FunSuite {
  var player: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new Jugador("Jugador", 2)
  }
  test("El jugador debe tener nombre") {
    assertEquals(player.nombre, "Jugador")
  }
  test("El jugador debe tener gemas") {
    assertEquals(player.gemas, 2)
  }
  test("El jugador debe tener 0 o mas gemas") {
    assert(player.gemas >= 0)
  }

  test("El jugador debe poder perder 1 gema") {
    player.quitarGema()
    assert(player.gemas == 1)
  }

}
