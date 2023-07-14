package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.*
import gwent.Cartas.abstractCartaUnidad

import java.util.Objects



/** A class representing a section of a gwent board
 * The Seccion class has one property: A list of cards
 *
 * @param cartas A list of cards representing the cards on this section of the board
 *
 *
 * @constructor Creates a section object with the specified list of cards
 *
 * @example
 * {{{
 * val section = new Seccion(List(card1, card2))
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.3
 */


class Seccion( var cartas: List[carta]) extends Equals{


  /** Returns the list of cards of this section */
  def getLista(): List[carta] = this.cartas

  

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
