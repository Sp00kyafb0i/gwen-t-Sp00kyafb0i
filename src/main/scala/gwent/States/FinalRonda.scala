package cl.uchile.dcc
package gwent.States

import java.util.Objects

class FinalRonda(context: GameController) extends GameState(context) with Equals{

  override def toFinalPartida(): Unit =
    context.state = new FinalPartida(context)

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
