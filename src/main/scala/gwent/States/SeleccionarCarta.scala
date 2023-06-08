package cl.uchile.dcc
package gwent.States

import java.util.Objects

class SeleccionarCarta(context: GameController) extends GameState(context) with Equals{

  override def toTurnoJugador(): Unit =
    context.state = new TurnoJugador(context)




  override def canEqual(that: Any): Boolean = that.isInstanceOf[SeleccionarCarta]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[SeleccionarCarta]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[SeleccionarCarta], context)
  }

}
