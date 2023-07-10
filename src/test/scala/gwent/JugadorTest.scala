package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.Cartas.{cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist, cartaClima, abstractCartaUnidad, carta}
import cl.uchile.dcc.gwent.Jugador
import cl.uchile.dcc.gwent.Tablero._
import munit.FunSuite


class JugadorTest extends FunSuite {
  val nombre: String = "Test"
  val gemas: Int = 2
  val nombre2: String = "Test2"
  val gemas2: Int = 3
  val falso: Boolean = false


  var player: Jugador = _
  var player2: Jugador = _
  var player3: Jugador = _
  var player4: Jugador = _
  var player5: Jugador = _
  var player6: Jugador = _

  var carta1 = new cartaUnidadCaC("Geralt", 3, falso, falso)
  var carta2 = new cartaUnidadAsed("Trebuchet", 4, falso, falso)
  var carta3 = new cartaUnidadDist("Yennefer", 3, falso, falso)
  var carta4 = new cartaClima("Sunny day", falso, falso, falso)

  val sectionCaC: SeccionUnidades = new SeccionUnidades(List(carta1))
  val sectionAsed: SeccionUnidades = new SeccionUnidades(List(carta2))
  val sectionDist: SeccionUnidades = new SeccionUnidades(List(carta3))

  val sectionCaC2: SeccionUnidades = new SeccionUnidades(List(carta1, carta1))

  var mazo1: List[carta] = List(carta1, carta2, carta3)
  var mazo2: List[carta] = List(carta2, carta3)
  var mazo3: List[carta] = List(carta1, carta2)
  var mazo4: List[carta] = List(carta2, carta1)

  var mano: List[carta] = List()
  var mano2: List[carta] = List(carta1)

  val tablero1: Tablero = new Tablero
  val tablero2: Tablero = new Tablero
  tablero2.seccionCac = new SeccionUnidades(List(carta1))

  var observer: observerGemas = _


  override def beforeEach(context: BeforeEach): Unit = {
    player = new Jugador(nombre, gemas, mano, mazo1, tablero1)
    player2 = new Jugador(nombre, gemas, mano, mazo1, tablero1)
    player3 = new Jugador(nombre2, gemas2, mano, mazo3, tablero1)
    player4 = new Jugador(nombre2, gemas, mano, mazo4, tablero1)
    player5 = new Jugador(nombre, gemas2, mano, mano, tablero1)
    player6 = new Jugador(nombre2, gemas2, mano, mazo4, tablero1)
    observer = new observerGemas
    player.registrarObserver(observer)
  }


  test("A player should be created with a name, an amount of gems, a deck and hand") {
    assertEquals(new Jugador(nombre, gemas, mano, mazo1, tablero1), player)
  }

  test("A player should be able to draw a card from their deck") {
    player.sacarCarta()
    player2.sacarCarta()
    assertNotEquals(player.mano, mano)
    assertEquals(player.mano, mano2)
    assertEquals(player, player2)
  }

  test("A player should be able to remove an observer") {
    player.eliminarObserver(observer)
    assertEquals(player.getObservers, List())
  }

  test("A player should be able to shuffle their deck") {
    player3.mezclar()
    if (player3.mazo == mazo3) {
      assertEquals(player3.mazo, mazo3)
    }
    else {
      assertEquals(player3.mazo, mazo4)
    }

  }


  test("A player should be able to play a card") {
    player.sacarCarta()
    assertEquals(player.mano, mano2)
    var carta: carta = player.mano.apply(0)
    var tablero: Tablero = player.getTablero
    print(carta.getNombre())
    player.play(carta, tablero)
    assertEquals(player.getTablero, tablero2)

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

  test("Two players with the same name, gems, hand. deck and board should be the same") {
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
