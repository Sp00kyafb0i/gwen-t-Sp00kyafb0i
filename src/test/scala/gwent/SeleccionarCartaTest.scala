package cl.uchile.dcc
package gwent

import gwent.States.*
import munit.FunSuite
import org.junit.Assert

class SeleccionarCartaTest extends FunSuite {

  var seleccionarCarta: SeleccionarCarta = _

  var context1 = new GameController

  var turnoJugador = new TurnoJugador(context1)


  override def beforeEach(context: BeforeEach): Unit = {
    seleccionarCarta = new SeleccionarCarta(context1)
  }

  test("Correct transition") {
    seleccionarCarta.toTurnoJugador()
    assertEquals(seleccionarCarta.context.state, turnoJugador)
  }


  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => seleccionarCarta.toInicioRonda())
    Assert.assertThrows(classOf[Exception], () => seleccionarCarta.toFinalPartida())
    Assert.assertThrows(classOf[Exception], () => seleccionarCarta.toFinalRonda())
    Assert.assertThrows(classOf[Exception], () => seleccionarCarta.toSeleccionarCarta())
    Assert.assertThrows(classOf[Exception], () => seleccionarCarta.toTurnoCpu())
  }

}
