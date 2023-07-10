package cl.uchile.dcc
package gwent

import gwent.States.*
import munit.FunSuite
import org.junit.Assert
class InicioRondaTest extends FunSuite{

  var inicioRonda: InicioRonda = _

  var context1 = new GameController

  var turnoJugador = new TurnoJugador(context1)
  var turnoCpu = new TurnoCpu(context1)


  override def beforeEach(context: BeforeEach): Unit = {
    inicioRonda = new InicioRonda(context1)
  }

  test("Correct transition") {
    inicioRonda.toTurnoCpu()
    assertEquals(inicioRonda.context.state, turnoCpu)
  }
  test("Correct transition") {
    inicioRonda.toTurnoJugador()
    assertEquals(inicioRonda.context.state, turnoJugador)
  }

  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => inicioRonda.toInicioRonda())
    Assert.assertThrows(classOf[Exception], () => inicioRonda.toFinalPartida())
    Assert.assertThrows(classOf[Exception], () => inicioRonda.toFinalRonda())
    Assert.assertThrows(classOf[Exception], () => inicioRonda.toSeleccionarCarta())
  }

}
