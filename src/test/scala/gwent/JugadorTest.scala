package cl.uchile.dcc
package gwent

import munit.FunSuite

class JugadorTest extends FunSuite {
  val nombre: String = "Test"
  val gemas: Int = 2
  val nombre2: String = "Test2"
  val gemas2: Int = 3

  var player: Jugador = _
  var player2: Jugador = _
  var player3: Jugador = _
  var player4: Jugador = _
  var player5: Jugador = _


  override def beforeEach(context: BeforeEach): Unit = {
    player = new Jugador(nombre, gemas)
    player2 = new Jugador(nombre, gemas)
    player3 = new Jugador(nombre2, gemas2)
    player4 = new Jugador(nombre2, gemas)
    player5 = new Jugador(nombre, gemas2)
  }


  test("A player should be created with a name and an amount of gems") {
    assertEquals(new Jugador(nombre, gemas), player)
  }

  test("A player should be able to lose a gem") {
    player.quitarGema()
    assertEquals(player.gemas, gemas-1)
  }

  test("A player should be able to return it's name") {
    assertEquals(player.getNombre(), nombre)
  }

  test("A player should have a minimum number of gems of 0") {
    assert(player.gemas >= 0)
  }

  test("Two players with the same name and gems should be the same") {
    assertEquals(player, player2)
    assertEquals(player2, player)
    assertNotEquals(player, player3)
    assertNotEquals(player, player4)
    assertNotEquals(player, player5)
    assertNotEquals(player3, player)
    assertNotEquals(player4, player)
    assertNotEquals(player5, player)
    assertEquals(player.hashCode(), player2.hashCode())
    assertNotEquals(player.hashCode(), player3.hashCode())
  }

  test("A player must be a Jugador class") {
    player.equals(nombre)
  }

}
