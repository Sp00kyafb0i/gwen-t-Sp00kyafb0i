package cl.uchile.dcc
package gwent.States

import java.util.Objects


/** A class representing a game state
 *
 * @param context Receives the game controller
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.3                    
 */

class GameState (val context: GameController) extends Equals{
  context.state = this

  
  /** Changes state to TurnoJugador */
  def toTurnoJugador(): Unit = {
    transitionError("TurnoJugador")
  }
  
  /** Changes state to TurnoCpu */
  def toTurnoCpu(): Unit = {
    transitionError("TurnoCpu")
  }

  
  /** Changes state to SeleccionarCarta */
  def toSeleccionarCarta(): Unit = {
    transitionError("SeleccionarCarta")
  }

  
  /** Changes state to FinalRonda */
  def toFinalRonda(): Unit = {
    transitionError("FinalRonda")
  }
  
  /** Changes state to InicioRonda */
  def toInicioRonda(): Unit = {
    transitionError("InicioRonda")
  }

  /** Changes state to FinalPartida */
  def toFinalPartida(): Unit = {
    transitionError("FinalPartida")

  }

/** An exception to indicate a transition error */
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
