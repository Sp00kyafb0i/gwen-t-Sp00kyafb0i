package cl.uchile.dcc
package gwent.Cartas

import gwent.Cartas.abstractCartaUnidad

import java.util.Objects

/** A class representing a ranged unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @constructor Creates a ranged unit card with the specified name and strength
 * @example {{{
 * val ejemplo = new cartaUnidadDist("Yennefer", 4)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.1
 */

class cartaUnidadDist(nombre: String, fuerza: Int) extends abstractCartaUnidad(nombre, fuerza) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadDist]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadDist]
      nombre == other.nombre && fuerza == other.fuerza
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadDist], nombre, fuerza)
  }
}