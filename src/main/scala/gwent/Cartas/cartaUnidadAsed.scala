package cl.uchile.dcc
package gwent.Cartas

import gwent.Cartas.abstractCartaUnidad

import java.util.Objects

/** A class representing a siege unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @constructor Creates a siege unit card with the specified name and strength
 * @example {{{
 * val ejemplo = new cartaUnidadAsed("Trebuchet", 4)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.1
 */
class cartaUnidadAsed(nombre: String, fuerza: Int) extends abstractCartaUnidad(nombre, fuerza) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadAsed]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadAsed]
      nombre == other.nombre && fuerza == other.fuerza
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadAsed], nombre, fuerza)
  }
}
