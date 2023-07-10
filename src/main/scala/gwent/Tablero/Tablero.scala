package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas._
import gwent.Tablero.Seccion
import gwent.Tablero.SeccionUnidades

import java.util.Objects


/** A class representing a player's section of a gwent board
 * The Tablero class has five properties: three sections corresponding to a type of unit and a section for a weather card which is meant to
 * be the same for both players, and an enemy section that stores the enemy's board
 *
 * @param seccionCac Melee zone
 * @param seccionDist Ranged zone
 * @param seccionAsed Siege zone
 * @param clima A section to store the weather card currently being played
 * @param enemigo This stores the enemy's board
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
 * @version 1.0.3
 */


class Tablero extends Equals{

  /** This initializes the board as a clean board with no cards on play */
  var seccionCac = new SeccionUnidades(List())
  var seccionAsed = new SeccionUnidades(List())
  var seccionDist = new SeccionUnidades(List())
  var seccionClima = new Seccion(List())


  var enemigo: Tablero = null

  /** Sets the board's enemy */
  def setEnemigo(tableroEnemigo: Tablero): Unit = {
    this.enemigo = tableroEnemigo
  }

  /** Returns the enemy's board */
  def getEnemigo(): Tablero = this.enemigo



/** Each of these methods returns it's corresponding section */
  def getSeccionClima(): Seccion = this.seccionClima
  def getSeccionCac(): SeccionUnidades = this.seccionCac
  def getSeccionAsed(): SeccionUnidades = this.seccionAsed
  def getSeccionDist(): SeccionUnidades = this.seccionDist

/** These methods allow cards to be added to each section of the board, in the case of a weather card, it just replaces the current card */
  def play(carta: carta): Unit = {
    carta.play(this)
  }


  /** Each of these methods sets it's corresponding section */
  def setSeccionAsed(seccion: SeccionUnidades): Unit = {
    this.seccionAsed = seccion
  }

  def setSeccionCac(seccion: SeccionUnidades): Unit = {
    this.seccionCac = seccion
  }

  def setSeccionDist(seccion: SeccionUnidades): Unit = {
    this.seccionDist = seccion
  }
  
  def setSeccionClima(seccion: Seccion): Unit = {
    this.seccionClima = seccion
  }

  
  /** This method sets all sections at the same time */
  def setSecciones(seccionCaC2: SeccionUnidades, seccionDist2: SeccionUnidades, seccionAsed2: SeccionUnidades, seccionClima2: Seccion): Unit = {
    seccionCac = seccionCaC2
    seccionAsed = seccionAsed2
    seccionDist = seccionDist2
    seccionClima = seccionClima2
  }


/** This method clears the board */
  def clear(): Unit = {
    seccionCac = new SeccionUnidades(List())
    seccionAsed = new SeccionUnidades(List())
    seccionDist = new SeccionUnidades(List())
    seccionClima = new Seccion(List())
  }
/** This method returns the sum of the strength of all the cards in this board */
  def fuerzaTablero: Int = {
    seccionDist.sumaFuerza + seccionAsed.sumaFuerza + seccionCac.sumaFuerza
  }


  override def canEqual(that: Any): Boolean = that.isInstanceOf[Tablero]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Tablero]
      seccionCac == other.seccionCac && seccionAsed == other.seccionAsed && seccionDist == other.seccionDist && seccionClima == other.seccionClima
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Tablero], seccionAsed, seccionCac, seccionDist, seccionClima)
  }

}
