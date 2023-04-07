package cl.uchile.dcc
package gwent


/** A class representing a unit card
 * The card has two properties (For now): a name and it's strength
 *
 * @param nombre The name of the card
 * @param fuerza The strength of the card
 *
 * @constructor Creates a unit card with the specified name and strength
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


class cartaUnidad (var nombre: String, var fuerza: Int)



/** A class representing a weather card
 * The card has one property (For now): a name
 *
 * @param nombre The name of the card
 *
 * @constructor Creates a weather card with the specified name
 *
 * @example
 * {{{
 * val clima = new cartaClima("Monsoon")
 * }}}
 *
 * @author Raul Aliste
 * @since 1.0.0
 * @version 1.0.0
 */


class cartaClima (var nombre: String) 
