package cl.uchile.dcc
package gwent.States

import gwent.Jugador
import gwent.Cartas.*
import gwent.Tablero.*
import gwent.observerGemas

import java.util.Objects


/** A class representing a game controller
 *
 * @param jugador Enters a player class
 * @param cpu Enters a player class representing the ai player
 * @param state the current gamestate
 *              
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.3                  
 */

class GameController extends Equals{
  private var jugador: Jugador = _
  private var cpu: Jugador = _
  var state: GameState = new InicioRonda(this)

  /** Returns the player */
  def getJugador: Jugador = jugador

  /** Returns the ai player */
  def getCpu: Jugador = cpu

  /** Adds a player */
  def addJugador(nombre: String, mano: List[carta], mazo: List[carta], tablero: Tablero): Unit = {
    jugador = new Jugador(nombre, 2, mano, mazo, tablero)
  }

  /** Adds an ai player */
  def addCpu(nombre: String, mano: List[carta], mazo: List[carta], tablero: Tablero): Unit = {
    cpu = new Jugador(nombre, 2, mano, mazo, tablero)
  }

  
  /** Starts a game */
  def startGame(nombre1: String,
                mano1: List[carta],
                mazo1: List[carta],
                tablero1: Tablero,
                nombre2: String,
                mano2: List[carta],
                mazo2: List[carta],
                tablero2: Tablero
               ): Unit = {
    addJugador(nombre1, mano1, mazo1, tablero1)
    val observerGemaPlayer = new observerGemas()
    jugador.registrarObserver(observerGemaPlayer)
    addCpu(nombre2, mano2, mazo2, tablero2)
    jugador.getTablero.setEnemigo(cpu.getTablero)
    cpu.getTablero.setEnemigo(jugador.getTablero)
    state =  new InicioRonda(this)
  }



  override def canEqual(that: Any): Boolean = that.isInstanceOf[GameController]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameController]
      jugador == other.getJugador && cpu == other.getCpu
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[GameController], getJugador, getCpu, state)
  }
  
  
  





}
