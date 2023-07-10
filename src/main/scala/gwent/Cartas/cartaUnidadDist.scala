package cl.uchile.dcc
package gwent.Cartas

import gwent.Cartas.abstractCartaUnidad

import cl.uchile.dcc.gwent.Tablero.{Seccion, SeccionUnidades, Tablero}

import java.util.Objects

/** A class representing a ranged unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @param fuerzaOriginal The original strength of the card
 * @param refuerzo This indicates if the card is a refuerzo card
 * @param vinculo this indicates if the card is a vinculo card  
 * @constructor Creates a ranged unit card with the specified name and strength
 *
 * @example {{{
 * val ejemplo = new cartaUnidadCac("Yennefer", 4, false, false)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.3
 */

class cartaUnidadDist(nombre: String, fuerza: Int, refuerzo: Boolean, vinculo: Boolean) extends abstractCartaUnidad(nombre, fuerza, refuerzo, vinculo) with Equals {


  /** plays the card in the board and applies it's effects */
  override def play(tablero: Tablero): Unit = {
    var seccionDist = tablero.getSeccionDist()
    var lista = seccionDist.getLista()
    seccionDist = new SeccionUnidades(this :: lista)
    tablero.setSeccionDist(seccionDist)
    if (this.refuerzo == true) {
      seccionDist.refuerzoMoral(this)
    }
    if (this.vinculo == true) {
      seccionDist.vinculoEstrecho(this)
    }
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadDist]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadDist]
      nombre == other.nombre && fuerza == other.fuerza && refuerzo == other.refuerzo && vinculo == other.vinculo
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadDist], nombre, fuerza, refuerzo, vinculo)
  }
}