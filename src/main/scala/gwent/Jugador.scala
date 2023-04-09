package cl.uchile.dcc
package gwent

/** A class representing a player
 * The player class has two properties (For now): a name and the player gems (health)
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
 * @version 1.0.0
 */


class Jugador (var nombre: String, var gemas: Int) {

  /** Decreases the player gems by 1 */
  def quitarGema(): Unit = {
    this.gemas -= 1
  }
}