package cl.uchile.dcc
package gwent.Cartas

import gwent.Cartas.abstractCartaUnidad

import cl.uchile.dcc.gwent.Tablero.{Seccion, SeccionUnidades, Tablero}

import java.util.Objects

/** A class representing a melee unit card
 *
 * @param nombre The name of the card
 * @param fuerza The current strength of the card
 * @param fuerzaOriginal The original strength of the card
 * @param refuerzo This indicates if the card is a refuerzo card
 * @param vinculo this indicates if the card is a vinculo card  
 * @constructor Creates a melee unit card with the specified name and strength
 *
 * @example {{{
 * val ejemplo = new cartaUnidadCac("Geralt", 4, false, false)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.3
 */
class cartaUnidadCaC(nombre: String, fuerza: Int, refuerzo: Boolean, vinculo: Boolean) extends abstractCartaUnidad(nombre, fuerza, refuerzo, vinculo) with Equals {



  /** plays the card in the board and applies it's effects */
  override def play(tablero: Tablero): Unit = {
    var seccionCac = tablero.getSeccionCac()
    var lista = seccionCac.getLista()
    seccionCac = new SeccionUnidades(this :: lista)
    tablero.setSeccionCac(seccionCac)
    if (this.refuerzo == true) {
      seccionCac.refuerzoMoral(this)
    }
    if (this.vinculo == true) {
      seccionCac.vinculoEstrecho(this)
    }
    
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaUnidadCaC]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaUnidadCaC]
      nombre == other.nombre && fuerza == other.fuerza && refuerzo == other.refuerzo && vinculo == other.vinculo
    } else {
      false
    }
  }

  override def hashCode: Int = {
    Objects.hash(classOf[cartaUnidadCaC], nombre, fuerza, refuerzo, vinculo)
  }
}
