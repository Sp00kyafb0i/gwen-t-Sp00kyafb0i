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

class InicioRonda(context: GameController) extends GameState(context) with Equals{

  
  /** Changes state to TurnoJugador */
  override def toTurnoJugador(): Unit =
    context.state = new TurnoJugador(context)

  
  /** Changes state to TurnoCpu */
  override def toTurnoCpu(): Unit =
    context.state = new TurnoCpu(context)



  override def canEqual(that: Any): Boolean = that.isInstanceOf[InicioRonda]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[InicioRonda]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[InicioRonda], context)
  }

}
