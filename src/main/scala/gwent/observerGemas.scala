package cl.uchile.dcc
package gwent

class observerGemas extends observerJugador {
  
  /** Notifies when a player has less than 1 gem */
  override def sinGemas(player: Jugador): Unit = {
    if (player.getGemas() < 1) {
      println("Ya no te quedan gemas")
    }
    
  }

}
