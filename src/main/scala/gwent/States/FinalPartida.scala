package cl.uchile.dcc
package gwent.States

import java.util.Objects

class FinalPartida(context: GameController) extends GameState(context) with Equals {



  override def canEqual(that: Any): Boolean = that.isInstanceOf[FinalPartida]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[FinalPartida]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[FinalPartida], context)
  }

}
