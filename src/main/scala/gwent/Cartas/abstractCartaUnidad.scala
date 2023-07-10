package cl.uchile.dcc
package gwent.Cartas

import gwent.Tablero.Tablero
import gwent.Cartas.carta

/** An abstract class representing an unit card
 * The card has five properties: a name and it's strength two times, one is used to store the card original strength and the other stores the card's current strength, it also has two booleans indicating if the card is a vinculo or refuerzo card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @param fuerzaOriginal The original strength of the card
 * @param refuerzo This indicates if the card is a refuerzo card
 * @param vinculo this indicates if the card is a vinculo card
 * @constructor Creates a unit card with the specified name and strengths and refuerzo and vinculo states
 * @author Raul Aliste
 * @since 1.0.0
 * @version 1.0.3
 */
abstract class abstractCartaUnidad(nombre: String, var fuerza: Int, var refuerzo: Boolean = false, var vinculo: Boolean = false) extends carta(nombre: String) {
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

  /** Doubles the card strength */
  def duplicarFuerza(): Unit = {
    this.fuerza *= 2
  }

  /** Returns a card's original strength */
  def getFuerzaOriginal(): Int = {
    this.fuerzaOriginal
  }
  
  
}