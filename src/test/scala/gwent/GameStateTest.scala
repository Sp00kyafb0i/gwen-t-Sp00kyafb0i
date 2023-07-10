package cl.uchile.dcc
package gwent

import gwent.States.*
import munit.FunSuite
import org.junit.Assert

class GameStateTest extends FunSuite {

  var gameState: GameState = _

  var context1 = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    gameState = new GameState(context1)
  }

  test("Invalid Transition") {
    Assert.assertThrows(classOf[Exception], () => gameState.toInicioRonda())
    Assert.assertThrows(classOf[Exception], () => gameState.toFinalPartida())
    Assert.assertThrows(classOf[Exception], () => gameState.toFinalRonda())
    Assert.assertThrows(classOf[Exception], () => gameState.toSeleccionarCarta())
    Assert.assertThrows(classOf[Exception], () => gameState.toTurnoCpu())
    Assert.assertThrows(classOf[Exception], () => gameState.toTurnoJugador())
  }

  test("A gamestate can be created") {
    assertEquals(new GameState(context1), gameState)
  }

}
