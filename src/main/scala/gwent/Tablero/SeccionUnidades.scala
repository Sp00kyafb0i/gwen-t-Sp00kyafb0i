package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.{abstractCartaUnidad, carta}



/** A class representing a unit section of a gwent board
 * The Seccion class has one property: A list of unit cards
 *
 * @param cartas A list of unit cards representing the cards on this section of the board
 *
 *
 * @constructor Creates a section object with the specified list of unit cards
 *
 * @example
 * {{{
 * val section = new Seccion(List(card1, card2))
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.2
 * @version 1.0.3
 */
class SeccionUnidades(cartas: List[abstractCartaUnidad]) extends Seccion(cartas) {

  /** Returns this section list of cards */
  override def getLista(): List[abstractCartaUnidad] = this.cartas

  /** This method returns the sum of the strength of the cards in the section */
  def sumaFuerza: Int = {
    var resultado = 0
    cartas.foreach(resultado += _.getFuerza())
    resultado
  }

  /** This method turns the strength of all the cards in the section to 1 */
  def malClima(): Unit = {
    cartas.foreach(_.disminuirFuerza())
  }

  /** This method turns the strength of all the cards in the section to their original strength */
  def buenClima(): Unit = {
    cartas.foreach(_.restablecer())
  }


  /** Applies the vinculo estrecho effect from the carta card to the section */
  def vinculoEstrecho(carta: abstractCartaUnidad): Unit = {
    for (carta2 <- cartas) {
      if (carta2.getNombre() == carta.getNombre()) {
        carta2.duplicarFuerza()
      }
    }

  }


  /** Applies the refuerzo moral effect from the carta card to the section */
  def refuerzoMoral(carta: abstractCartaUnidad): Unit = {
    for (carta2 <- cartas) {
      if (carta2 != carta) {
        carta2.aumentarFuerza()
      }
    }
  }

}
