package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.Cartas.{cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import cl.uchile.dcc.gwent.Tablero._
import munit.FunSuite
class TableroTest extends FunSuite {

  var carta1 = new cartaUnidadCaC("Geralt", 3)
  var carta2 = new cartaUnidadAsed("Trebuchet", 4)
  var carta3 = new cartaUnidadDist("Yennefer", 3)
  var carta4 = new cartaClima("Sunny day")

  var listaCaC = List(carta1, carta1, carta1)
  var listaAsed = List(carta2, carta2, carta2)
  var listaDist = List(carta3, carta3, carta3)
  var listaCaC2 = List(carta1, carta1)
  var listaAsed2 = List(carta2, carta2)
  var listaDist2 = List(carta3, carta3)


  var seccion1 = new Seccion(listaCaC)
  var seccion2 = new Seccion(listaAsed)
  var seccion3 = new Seccion(listaDist)
  var seccion4 = new Seccion(listaCaC2)
  var seccion5 = new Seccion(listaAsed2)
  var seccion6 = new Seccion(listaDist2)

  var tablero1: Tablero = _
  var tablero2: Tablero = _
  var tablero3: Tablero = _
  var tablero4: Tablero = _

  override def beforeEach(context: BeforeEach): Unit = {
    tablero1 = new Tablero
    tablero1.setSecciones(seccion1, seccion3, seccion2, carta4)
    tablero2 = new Tablero
    tablero2.setSecciones(seccion1, seccion3, seccion2, carta4)
    tablero3 = new Tablero
    tablero3.setSecciones(seccion4, seccion6, seccion5, null)
    tablero4 = new Tablero
  }

  test("A player should be able to play cards on the board"){
    tablero3.play(carta1)
    tablero3.play(carta2)
    tablero3.play(carta3)
    tablero3.play(carta4)
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
