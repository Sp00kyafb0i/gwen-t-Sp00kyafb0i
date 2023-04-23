package cl.uchile.dcc
package gwent

/** An abstract class representing a card with a name
 *
 * @param nombre The name of the card
 * @constructor Create a new card with the given name
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.1
 *
 */

abstract class abstractCarta(val nombre: String) {
  /** Returns the card's name */
  def getNombre(): String = {
    this.nombre
  }
}
