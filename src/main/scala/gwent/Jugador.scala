package cl.uchile.dcc
package gwent

import java.util.Objects

/** A class representing a player
 * The player class has two properties: a name and the player gems (health)
 *
 * @param nombre The name of the player
 * @param gemas The amount of gems that the player has
 *
 * @constructor Creates a player object with the specified name and gems
 *
 * @example
 * {{{
 * val player = new Jugador("Geralt", 2)
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.0
 * @version 1.0.1
 */


class Jugador (val nombre: String, var gemas: Int) extends Equals {

  /** Decreases the player gems by 1 */
  def quitarGema(): Unit = {
    this.gemas -= 1
  }
  /** Returns the player's name */
  def getNombre(): String = {
    this.nombre
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Jugador]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Jugador]
      nombre == other.nombre && gemas == other.gemas
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[Jugador], nombre, gemas)
  }
}