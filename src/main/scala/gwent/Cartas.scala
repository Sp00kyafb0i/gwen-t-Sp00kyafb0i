package cl.uchile.dcc
package gwent


/** A class representing a unit card
 * The card has three properties (For now): a name and it's strength two times
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @param fuerzaOriginal The original strength of the card
 *
 * @constructor Creates a unit card with the specified name and strengths
 *
 * @example
 * {{{
 * val unidad = new cartaUnidad("Yennefer", 4)
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.0
 * @version 1.0.0
 */


class cartaUnidad (var nombre: String, var fuerza: Int) {
  private val fuerzaOriginal: Int = fuerza
/** Returns the card current strength*/
  def getFuerza(): Int = {
    this.fuerza
  }
/** Makes the card strength equal to it's original strength */
  def restablecer(): Unit = {
    this.fuerza = this.fuerzaOriginal
  }
/** Increases the card strength by 1 */
  def aumentarFuerza(): Unit = {
    this.fuerza += 1
  }
/** Decreases the card strength to 1 */
  def disminuirFuerza(): Unit = {
    this.fuerza = 1
  }
}





