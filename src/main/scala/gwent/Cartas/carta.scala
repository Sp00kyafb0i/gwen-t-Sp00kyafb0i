package cl.uchile.dcc
package gwent.Cartas

import gwent.Tablero.Tablero



/** An trait representing acard
 * The card has onre property: a name
 *
 * @param nombre The name of the card
 * @constructor Creates a unit card with the specified name
 * @author Raul Aliste
 * @since 1.0.3
 * @version 1.0.3
 */

trait carta(var nombre: String) {

  /** Returns the card's name */
  def getNombre(): String = {
    this.nombre
  }
/** Plays the card in a board */
  def play(tablero: Tablero): Unit
}
