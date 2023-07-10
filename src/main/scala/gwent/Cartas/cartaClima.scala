package cl.uchile.dcc
package gwent.Cartas

import gwent.Tablero.{Seccion, Tablero}

import java.util.Objects

/** A class representing a weather card
 *
 * @param nombre The name of the card
 * @param nieve indicates if this is a escarcha mordiente card
 * @param niebla indicates if this is a niebla card
 * @param indicates if this is a lluvia card
 *
 * @constructor Creates a weather card with the specified name
 *
 * @example {{{
 * val ejemplo = new cartaClima("Monsoon", false, false, true)
 * }}}
 * @author Raul Aliste
 * @since 1.0.1
 * @version 1.0.3
 */
class cartaClima(nombre: String, var nieve: Boolean, var niebla: Boolean, var lluvia: Boolean) extends carta(nombre: String) with Equals {


  
  /** Plays the card in a board and applys it's effect */
  override def play(tablero: Tablero): Unit = {
    var seccionClima = tablero.getSeccionClima()
    var lista = seccionClima.getLista()
    seccionClima = new Seccion(this :: lista)
    tablero.setSeccionClima(seccionClima)
    var enemigo = tablero.getEnemigo()
    enemigo.setSeccionClima(seccionClima)
    if (this.nieve) {
      tablero.getSeccionCac().malClima()
      enemigo.getSeccionCac().malClima()
    }
    if (this.lluvia) {
      tablero.getSeccionDist().malClima()
      enemigo.getSeccionDist().malClima()
    }
    if (this.niebla) {
      tablero.getSeccionAsed().malClima()
      enemigo.getSeccionAsed().malClima()
    }
    else {
      tablero.getSeccionAsed().buenClima()
      enemigo.getSeccionAsed().buenClima()
    }
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[cartaClima]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[cartaClima]
      nombre == other.getNombre() && nieve == other.nieve && niebla == other.niebla && lluvia == other.lluvia
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[cartaClima], nombre, nieve, niebla, lluvia)
  }
}
