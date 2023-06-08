package cl.uchile.dcc
package gwent.States

import java.util.Objects

class TurnoJugador(context: GameController) extends GameState(context) with Equals{

  override def toSeleccionarCarta(): Unit =
    context.state = new SeleccionarCarta(context)

  override def toTurnoCpu(): Unit =
    context.state = new TurnoCpu(context)

  override def toFinalRonda(): Unit =
    context.state = new FinalRonda(context)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[TurnoJugador]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[TurnoJugador]
      context == other.context
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[TurnoJugador], context)
  }

}
