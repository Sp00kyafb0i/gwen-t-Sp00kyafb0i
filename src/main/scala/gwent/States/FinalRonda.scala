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

class FinalRonda(context: GameController) extends GameState(context) with Equals{

  
  /** Changes state to finalPartida */
  override def toFinalPartida(): Unit =
    context.state = new FinalPartida(context)

  
  /** Changes state to InicioRonda */
  override def toInicioRonda(): Unit =
    context.state = new InicioRonda(context)





  override def canEqual(that: Any): Boolean = that.isInstanceOf[FinalRonda]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[FinalRonda]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[FinalRonda], context)
  }

}
