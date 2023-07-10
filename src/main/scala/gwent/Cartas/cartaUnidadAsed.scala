package cl.uchile.dcc
package gwent.Cartas

import gwent.Tablero.{Seccion, SeccionUnidades, Tablero}
import gwent.Cartas.abstractCartaUnidad

import java.util.Objects

/** A class representing a siege unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @param fuerzaOriginal The original strength of the card
 * @param refuerzo This indicates if the card is a refuerzo card
 * @param vinculo this indicates if the card is a vinculo card               
 * @constructor Creates a siege unit card with the specified name and strength
 * @example {{{
 * val ejemplo = new cartaUnidadAsed("Trebuchet", 4, false, false)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.3
 */
class cartaUnidadAsed(nombre: String, fuerza: Int, refuerzo: Boolean, vinculo: Boolean) extends abstractCartaUnidad(nombre, fuerza, refuerzo, vinculo) with Equals {

  
  /** plays the card in the board and applies it's effects */
  override def play(tablero: Tablero): Unit = {
    var seccionAsed = tablero.getSeccionAsed()
    var lista = seccionAsed.getLista()
    seccionAsed = new SeccionUnidades(this :: lista)
    tablero.setSeccionAsed(seccionAsed)
    if (this.refuerzo == true) {
      seccionAsed.refuerzoMoral(this)
    }
    if (this.vinculo == true) {
      seccionAsed.vinculoEstrecho(this)
    }
  }
  
  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadAsed]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadAsed]
      nombre == other.nombre && fuerza == other.fuerza && refuerzo == other.refuerzo && vinculo == other.vinculo
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadAsed], nombre, fuerza, refuerzo, vinculo)
  }
}
