package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.Cartas.{abstractCartaUnidad, cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import cl.uchile.dcc.gwent.Tablero.{Seccion, Tablero}
import munit.FunSuite
import gwent.States._

class GameControllerTest extends FunSuite{

  var gc1: GameController = _
  var gc2: GameController = _
  var gc3: GameController = _

  val nombre: String = "Test"
  val gemas: Int = 2
  val nombre2: String = "Test2"
  val gemas2: Int = 3

  var carta1 = new cartaUnidadCaC("Geralt", 3)
  var carta2 = new cartaUnidadAsed("Trebuchet", 4)
  var carta3 = new cartaUnidadDist("Yennefer", 3)
  var carta4 = new cartaClima("Sunny day")

  val sectionCaC: Seccion = new Seccion(List(carta1))
  val sectionAsed: Seccion = new Seccion(List(carta2))
  val sectionDist: Seccion = new Seccion(List(carta3))

  val sectionCaC2: Seccion = new Seccion(List(carta1, carta1))

  var mazo1: List[abstractCartaUnidad] = List(carta1, carta2, carta3)
  var mazo2: List[abstractCartaUnidad] = List(carta2, carta3)
  var mazo3: List[abstractCartaUnidad] = List(carta1, carta2)
  var mazo4: List[abstractCartaUnidad] = List(carta2, carta1)

  var mano: List[abstractCartaUnidad] = List()
  var mano2: List[abstractCartaUnidad] = List(carta1)

  val tablero1: Tablero = new Tablero
  val tablero2: Tablero = new Tablero
  tablero2.seccionCac = new Seccion(List(carta1))

  var player = new Jugador(nombre, gemas, mano, mazo1, tablero1)
  var player2 = new Jugador(nombre, gemas, mano, mazo1, tablero1)
  var player3 = new Jugador(nombre2, gemas, mano, mazo3, tablero2)

  override def beforeEach(context: BeforeEach): Unit = {
    gc1 = new GameController
    gc2 = new GameController
    gc3 = new GameController

  }

  test("A gamecontroller must be created") {
    assertEquals(new GameController, gc1)
  }

  test("A gamecontroller must be able to add a player") {
    gc1.addJugador(nombre, mano, mazo1, tablero1)
    assertEquals(gc1.getJugador, player)
  }

  test("A gamecontroller must be able to add a cpu") {
    gc1.addCpu(nombre, mano, mazo1, tablero1)
    assertEquals(gc1.getCpu, player)
  }

  test("A gamecontroller must be able to start a game") {
    gc1.startGame(nombre, mano, mazo1, tablero1, nombre2, mano, mazo3, tablero2)
    assertEquals(gc1.getJugador, player)
    assertEquals(gc1.getCpu, player3)
  }

}
