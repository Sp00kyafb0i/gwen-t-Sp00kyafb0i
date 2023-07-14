package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.Cartas.{cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import cl.uchile.dcc.gwent.Tablero._
import munit.FunSuite
class TableroTest extends FunSuite {

  val falso: Boolean = false
  val True: Boolean = true

  var carta1: cartaUnidadCaC = _
  var carta2: cartaUnidadAsed = _
  var carta3: cartaUnidadDist = _
  var carta4: cartaClima = _
  var carta5: cartaClima = _
  var cartaNieve: cartaClima = _
  var cartaNiebla: cartaClima = _
  var cartaLluvia: cartaClima = _


  var listaCaC: List[cartaUnidadCaC] = _
  var listaAsed: List[cartaUnidadAsed] = _
  var listaDist: List[cartaUnidadDist] = _
  var listaCaC2: List[cartaUnidadCaC] = _
  var listaAsed2: List[cartaUnidadAsed] = _
  var listaDist2: List[cartaUnidadDist] = _
  var listaClima: List[cartaClima] = _
  var listaNieve: List[cartaClima] = _
  var listaNiebla: List[cartaClima] = _
  var listaLluvia: List[cartaClima] = _


  var seccion1: SeccionUnidades = _
  var seccion2: SeccionUnidades = _
  var seccion3: SeccionUnidades = _
  var seccion4: SeccionUnidades = _
  var seccion5: SeccionUnidades = _
  var seccion6: SeccionUnidades = _
  var seccion7: Seccion = _
  var seccion8: Seccion = _
  var seccionNieve: Seccion = _
  var seccionNiebla: Seccion = _
  var seccionLluvia: Seccion = _





  var tablero1: Tablero = _
  var tablero2: Tablero = _
  var tablero3: Tablero = _
  var tablero4: Tablero = _
  var tableroNieve: Tablero = _
  var tableroNiebla: Tablero = _
  var tableroLluvia: Tablero = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new cartaUnidadCaC("Geralt", 3, falso, falso)
    carta2 = new cartaUnidadAsed("Trebuchet", 4, falso, falso)
    carta3 = new cartaUnidadDist("Yennefer", 3, falso, falso)
    carta4 = new cartaClima("Sunny day", falso, falso, falso)
    carta5 = new cartaClima("Cloudy day", falso, True, falso)
    cartaNieve = new cartaClima("prueba", True, falso, falso)
    cartaNiebla = new cartaClima("prueba", falso, True, falso)
    cartaLluvia = new cartaClima("prueba", falso, falso, True)


    listaCaC = List(carta1, carta1, carta1)
    listaAsed = List(carta2, carta2, carta2)
    listaDist = List(carta3, carta3, carta3)
    listaCaC2 = List(carta1, carta1)
    listaAsed2 = List(carta2, carta2)
    listaDist2 = List(carta3, carta3)
    listaClima = List(carta4)
    listaNieve = List(cartaNieve)
    listaNiebla = List(cartaNiebla)
    listaLluvia = List(cartaLluvia)


    seccion1 = new SeccionUnidades(listaCaC)
    seccion2 = new SeccionUnidades(listaAsed)
    seccion3 = new SeccionUnidades(listaDist)
    seccion4 = new SeccionUnidades(listaCaC2)
    seccion5 = new SeccionUnidades(listaAsed2)
    seccion6 = new SeccionUnidades(listaDist2)
    seccion7 = new Seccion(listaClima)
    seccion8 = new Seccion(List())
    seccionNieve = new Seccion(listaNieve)
    seccionNiebla = new Seccion(listaNiebla)
    seccionLluvia = new Seccion(listaLluvia)



    tablero1 = new Tablero
    tablero1.setSecciones(seccion1, seccion3, seccion2, seccion7)
    tablero2 = new Tablero
    tablero2.setSecciones(seccion1, seccion3, seccion2, seccion7)
    tablero3 = new Tablero
    tablero3.setSecciones(seccion4, seccion6, seccion5, seccion8)
    tablero4 = new Tablero
    tableroNieve = new Tablero
    tableroNieve.setSecciones(seccion1, seccion3, seccion2, seccionNieve)
    tableroNiebla = new Tablero
    tableroNieve.setSecciones(seccion1, seccion3, seccion2, seccionNiebla)
    tableroLluvia = new Tablero
    tableroLluvia.setSecciones(seccion1, seccion3, seccion2, seccionLluvia)
  }



  test("A player should be able to play cards on the board"){
    tablero3.setEnemigo(tablero1)
    tablero1.setEnemigo(tablero3)
    tablero3.play(carta1)
    tablero3.play(carta2)
    tablero3.play(carta3)
    tablero3.play(carta4)
    tablero3.play(cartaNieve)
    assertEquals(tablero1.seccionClima, tablero3.seccionClima)
    tablero3.play(cartaNiebla)
    assertEquals(tablero1.seccionClima, tablero3.seccionClima)
    tablero3.play(cartaLluvia)
    assertEquals(tablero1.seccionClima, tablero3.seccionClima)
    assertEquals(tablero3, tablero1)
  }

  test("Two boards with the same cards should be the same") {
    assertEquals(tablero1, tablero2)
    assertNotEquals(tablero1, tablero3)
    assertEquals(tablero1.hashCode, tablero2.hashCode)
    assertNotEquals(tablero1.hashCode, tablero3.hashCode)
  }

  test("A board should be created") {
    assertEquals(new Tablero, tablero4)
  }

  test("A board should be able to be cleared") {
    tablero1.clear()
    assertEquals(tablero1, tablero4)
  }

  test("A board should be able to return the total strength of all cards played on ti") {
    assertEquals(tablero1.fuerzaTablero, 30)
  }



}
