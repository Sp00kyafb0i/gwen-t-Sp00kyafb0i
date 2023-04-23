package cl.uchile.dcc
package gwent

import java.util.Objects

/** A class representing a melee unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 *
 * @constructor Creates a melee unit card with the specified name and strength
 *
 * @example {{{
 * val ejemplo = new cartaUnidadCac("Geralt", 4)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.1
 */
class cartaUnidadCaC(nombre: String, fuerza: Int) extends abstractCartaUnidad(nombre, fuerza) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadCaC]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadCaC]
      nombre == other.nombre && fuerza == other.fuerza
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadCaC], nombre, fuerza)
  }
}
