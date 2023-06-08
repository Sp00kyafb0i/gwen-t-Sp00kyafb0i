package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas._
import gwent.Tablero.Seccion

import java.util.Objects


/** A class representing a player's section of a gwent board
 * The Tablero class has four properties: three sections corresponding to a type of unit and a section for a weather card which is meant to
 * be the same for both players
 *
 * @param seccionCac Melee zone
 * @param seccionDist Ranged zone
 * @param seccionAsed Siege zone
 * @param clima A section to store the weather card currently being played
 *
 *
 * @constructor Creates a board object with the specified sections and weather card
 *
 * @example
 * {{{
 * val board = new Tablero(Seccion, Seccion, Seccion, cartaClima)
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.2
 */


class Tablero extends Equals{

  /** This initializes the board as a clean board with no cards on play */
  var seccionCac = new Seccion(List())
  var seccionAsed = new Seccion(List())
  var seccionDist = new Seccion(List())
  var cartaClima: abstractCartaUnidad = null

/** This variable is used to store a certain list of cards from a certain section */
  var lista: List[abstractCartaUnidad] = List()

/** These methods allow cards to be added to each section of the board, in the case of a weather card, it just replaces the current card */
  def play(carta: abstractCartaUnidad): Unit = {
    if (carta.isInstanceOf[cartaUnidadCaC]) {
      playCaC(carta)
    } else if (carta.isInstanceOf[cartaUnidadAsed]) {
      playAsed(carta)
    } else if (carta.isInstanceOf[cartaUnidadDist]) {
      playDist(carta)
    } else if (carta.isInstanceOf[cartaClima]) {
      playClima(carta)
    }
  }

  def setSecciones(seccionCaC2: Seccion, seccionDist2: Seccion, seccionAsed2: Seccion, cartaClima2: abstractCartaUnidad): Unit = {
    seccionCac = seccionCaC2
    seccionAsed = seccionAsed2
    seccionDist = seccionDist2
    cartaClima = cartaClima2
  }
  def playCaC(carta: abstractCartaUnidad): Unit = {
    lista = seccionCac.cartas
    seccionCac = new Seccion(carta :: lista)
  }
  def playAsed(carta: abstractCartaUnidad): Unit = {
    lista = seccionAsed.cartas
    seccionAsed = new Seccion(carta :: lista)
  }
  def playDist(carta: abstractCartaUnidad): Unit = {
    lista = seccionDist.cartas
    seccionDist = new Seccion(carta :: lista)
  }
  def playClima(carta: abstractCartaUnidad): Unit = {
    cartaClima =  carta
  }


/** This method clears the board */
  def clear(): Unit = {
    seccionCac = new Seccion(List())
    seccionAsed = new Seccion(List())
    seccionDist = new Seccion(List())
    cartaClima = null
  }
/** This method returns the sum of the strength of all the cards in this board */
  def fuerzaTablero: Int = {
    seccionDist.sumaFuerza + seccionAsed.sumaFuerza + seccionCac.sumaFuerza
  }


  override def canEqual(that: Any): Boolean = that.isInstanceOf[Tablero]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Tablero]
      seccionCac == other.seccionCac && seccionAsed == other.seccionAsed && seccionDist == other.seccionDist
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Tablero], seccionAsed, seccionCac, seccionDist, cartaClima)
  }

}
