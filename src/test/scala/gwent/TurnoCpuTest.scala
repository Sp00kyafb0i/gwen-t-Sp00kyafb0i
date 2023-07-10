package cl.uchile.dcc
package gwent
import munit.FunSuite
import gwent.States.*
import gwent.Tablero.*

import cl.uchile.dcc.gwent.Cartas.{abstractCartaUnidad, cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import org.junit.Assert

class TurnoCpuTest extends FunSuite{

  var cpu1: TurnoCpu = _

  var context1 = new GameController

  var turnoJugador = new TurnoJugador(context1)
  var finalRonda =  new FinalRonda(context1)



  override def beforeEach(context: BeforeEach): Unit = {
    cpu1 = new TurnoCpu(context1)
  }

  test("Correct transition") {
    cpu1.toTurnoJugador()
    assertEquals(cpu1.context.state, turnoJugador)
  }
  test("Correct transition") {
    cpu1.toFinalRonda()
    assertEquals(cpu1.context.state, finalRonda)
  }

  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => cpu1.toTurnoCpu())
    Assert.assertThrows(classOf[Exception], () => cpu1.toFinalPartida())
    Assert.assertThrows(classOf[Exception], () => cpu1.toInicioRonda())
    Assert.assertThrows(classOf[Exception], () => cpu1.toSeleccionarCarta())
  }


}
