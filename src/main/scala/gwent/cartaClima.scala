package cl.uchile.dcc
package gwent

import java.util.Objects

/** A class representing a weather card
 *
 * @param nombre The name of the card
 *
 * @constructor Creates a weather card with the specified name
 *
 * @example {{{
 * val ejemplo = new cartaClima("Monsoon")
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.1
 */
class cartaClima(nombre: String) extends abstractCarta(nombre) with Equals {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaClima]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaClima]
      nombre == other.nombre
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[cartaClima], nombre)
  }
}
