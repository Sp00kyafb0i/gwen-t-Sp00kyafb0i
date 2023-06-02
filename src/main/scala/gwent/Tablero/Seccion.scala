package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.*
import gwent.Cartas.abstractCartaUnidad

import java.util.Objects



/** A class representing a section of a gwent boards
 * The Seccion class has one property: A list of unit cards
 *
 * @param cartas A list of unit cards representing the cards on this section of the board
 *
 *
 * @constructor Creates a section object with the specified list of unit cards
 *
 * @example
 * {{{
 * val section = new Seccion(List(unit card1, unit card2))
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.2
 */


class Seccion( var cartas: List[abstractCartaUnidad]) extends Equals{



  /** This method returns the sum of the strength of the cards in the section */
  def sumaFuerza: Int = {
    var resultado = 0
    cartas.foreach(resultado += _.getFuerza())
    resultado
  }
  
  /** This method turns the strength of all the cards in the section to 1 */
  def malClima(): Unit = {
    cartas.foreach(_.disminuirFuerza())
  }
  
  /** This method turns the strength of all the cards in the section to their original strength */
  def buenClima(): Unit = {
    cartas.foreach(_.restablecer())
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Seccion]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Seccion]
      cartas == other.cartas
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Seccion], cartas)
  }
  
}
