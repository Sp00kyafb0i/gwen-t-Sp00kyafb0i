package cl.uchile.dcc
package gwent

import gwent.States.*
import munit.FunSuite
import org.junit.Assert

class TurnoJugadorTest extends FunSuite{

  var turnoJugador: TurnoJugador = _

  var context1 = new GameController

  var seleccionarCarta = new SeleccionarCarta(context1)
  var finalRonda = new FinalRonda(context1)
  var turnoCpu =  new TurnoCpu(context1)


  override def beforeEach(context: BeforeEach): Unit = {
    turnoJugador = new TurnoJugador(context1)
  }

  test("Correct transition") {
    turnoJugador.toSeleccionarCarta()
    assertEquals(turnoJugador.context.state, seleccionarCarta)
  }
  test("Correct transition") {
    turnoJugador.toFinalRonda()
    assertEquals(turnoJugador.context.state, finalRonda)
  }

  test("Correct transition") {
    turnoJugador.toTurnoCpu()
    assertEquals(turnoJugador.context.state, turnoCpu)
  }

  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => turnoJugador.toTurnoJugador())
    Assert.assertThrows(classOf[Exception], () => turnoJugador.toFinalPartida())
    Assert.assertThrows(classOf[Exception], () => turnoJugador.toInicioRonda())
  }

}
