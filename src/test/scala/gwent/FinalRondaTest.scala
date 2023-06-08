package cl.uchile.dcc
package gwent

import gwent.States.*
import munit.FunSuite
import org.junit.Assert

class FinalRondaTest extends FunSuite {

  var finalRonda: FinalRonda = _

  var context1 = new GameController

  var finalPartida = new FinalPartida(context1)
  var inicioRonda = new InicioRonda(context1)


  override def beforeEach(context: BeforeEach): Unit = {
    finalRonda = new FinalRonda(context1)
  }

  test("Correct transition") {
    finalRonda.toFinalPartida()
    assertEquals(finalRonda.context.state, finalPartida)
  }
  test("Correct transition") {
    finalRonda.toInicioRonda()
    assertEquals(finalRonda.context.state, inicioRonda)
  }

  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => finalRonda.toTurnoCpu())
    Assert.assertThrows(classOf[Exception], () => finalRonda.toTurnoJugador())
    Assert.assertThrows(classOf[Exception], () => finalRonda.toFinalRonda())
    Assert.assertThrows(classOf[Exception], () => finalRonda.toSeleccionarCarta())
  }

}
