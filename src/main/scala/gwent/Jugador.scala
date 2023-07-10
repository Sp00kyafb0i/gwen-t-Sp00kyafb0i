package cl.uchile.dcc
package gwent

import gwent.Cartas.*
import gwent.Tablero.*

import sun.jvm.hotspot.utilities.Observer

import java.util.Objects

/** A class representing a player
 * The player class has four properties: a name, the player gems (health), a hand of cards, a deck of cards and a board
 *
 * @param nombre The name of the player
 * @param gemas The amount of gems that the player has
 * @param _mano A list of cards representing the hand of cards of the player
 * @param _mazo A list of cards representing the deck of cards of the player
 * @param tablero A class representing a section of the board corresponding this player
 *
 * @constructor Creates a player object with the specified name, gems, hand, deck and board
 *
 * @example
 * {{{
 * val player = new Jugador("Geralt", 2, [new cartaUnidadCaC("Geralt", 2)], [new cartaUnidadDist("Yennefer", 2)], new Tablero())
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.0
 * @version 1.0.3
 */


class Jugador (val nombre: String, var gemas: Int, private var _mano: List[carta], private var _mazo: List[carta], private var tablero: Tablero) extends Equals {

  
  var observers: List[observerJugador] = List()


  /** Registers an observer */
  def registrarObserver(observer: observerJugador): Unit = {
    observers = observer :: observers
  }

  /** Deletes an observer */
  def eliminarObserver(observer: observerJugador): Unit = {
    observers = observers.filterNot(_ == observer)
  }

  /** Returns the list of observers */
  def getObservers: List[observerJugador] = observers


  /** Returns the number of gems */
  def getGemas(): Int = {
    this.gemas
  }


  /** Notifies when the player has 0 gems */
  def notificarSinGemas(): Unit = {
    observers.foreach(_.sinGemas(this))
  }
  
  /** Decreases the player gems by 1 */
  def quitarGema(): Unit = {
    this.gemas -= 1
    notificarSinGemas()

  }
  /** Returns the player's name */
  def getNombre(): String = {
    this.nombre
  }

  /** Accessor method for the player's hand */
  def mano: List[carta] = _mano

  /** Accessor method for the player's deck */
  def mazo: List[carta] = _mazo

  def getTablero: Tablero = this.tablero

  /** Draws a card from the deck and returns the card */
  def sacarCarta(): carta = {
    val carta = mazo.head
    _mazo = mazo.tail
    _mano = carta :: mano
    carta

  }
  /** Shuffles the deck */
  def mezclar(): Unit = {
    _mazo = scala.util.Random.shuffle(_mazo)
  }


  /** Plays a card from the player's hand into the board, removing it from the hand, it actually creates a new list of cards without the one
   * that was played */
  def play(carta: carta, tablero: Tablero): Unit ={
    tablero.play(carta)
    _mano = mano.filterNot(_ eq carta)
  }



  

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Jugador]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Jugador]
      nombre == other.nombre && gemas == other.gemas && _mano == other.mano && _mazo == other.mazo && tablero == other.tablero
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Jugador], nombre, gemas, _mano, _mazo, tablero)
  }
}