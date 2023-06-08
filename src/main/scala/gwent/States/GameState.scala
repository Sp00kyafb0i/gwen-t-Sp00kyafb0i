package cl.uchile.dcc
package gwent.States

import java.util.Objects

class GameState (val context: GameController) extends Equals{
  context.state = this

  def toTurnoJugador(): Unit = {
    transitionError("TurnoJugador")
  }
  def toTurnoCpu(): Unit = {
    transitionError("TurnoCpu")
  }

  def toSeleccionarCarta(): Unit = {
    transitionError("SeleccionarCarta")
  }

  def toFinalRonda(): Unit = {
    transitionError("FinalRonda")
  }

  def toInicioRonda(): Unit = {
    transitionError("InicioRonda")
  }

  def toFinalPartida(): Unit = {
    transitionError("FinalPartida")

  }


  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }


  override def canEqual(that: Any): Boolean = that.isInstanceOf[GameState]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameState]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[GameState], context)
  }

}
