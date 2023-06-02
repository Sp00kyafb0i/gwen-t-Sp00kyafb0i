package cl.uchile.dcc
package gwent


import cl.uchile.dcc.gwent.Cartas.{cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import cl.uchile.dcc.gwent.Tablero.Seccion
import munit.FunSuite
class SeccionTest extends FunSuite {


  var carta1 = new cartaUnidadCaC("Geralt", 3)
  var carta2 = new cartaUnidadAsed("Trebuchet", 4)
  var carta3 = new cartaUnidadDist("Yennefer", 3)
  var carta4 = new cartaClima("Sunny day")

  var listaCaC = List(carta1, carta1, carta1)
  var listaAsed = List(carta2, carta2, carta2)
  var listaDist = List(carta3, carta3, carta3)

  var seccion1: Seccion = _
  var seccion2: Seccion = _
  var seccion3: Seccion = _
  var seccion4: Seccion = _
  var seccion5: Seccion = _

  override def beforeEach(context: BeforeEach): Unit = {
    seccion1 = new Seccion(listaCaC)
    seccion2 = new Seccion(listaAsed)
    seccion3 = new Seccion(listaDist)
    seccion4 = new Seccion(listaCaC)
    seccion5 = new Seccion(listaAsed)
  }

  test("A section should be created with a list of cards") {
    assertEquals(new Seccion(listaCaC), seccion1)
  }

  test("Two sections with the same list of cards should be the same") {
    assertEquals(seccion1, seccion4)
    assertNotEquals(seccion1, seccion3)
    assertEquals(seccion1.hashCode, seccion4.hashCode)
    assertNotEquals(seccion1.hashCode, seccion3.hashCode)
  }

  test("A section should be able to return the sum of the strength of its cards") {
    assertEquals(seccion1.sumaFuerza, carta1.getFuerza()*3)
  }

  test("A section should be able to decrease it's cards strength to one") {
    seccion1.malClima()
    assertEquals(seccion1.sumaFuerza, 3)
  }

  test("A section should be able to restore it's cards strength to their original amount") {
    seccion1.malClima()
    seccion1.buenClima()
    assertEquals(seccion1.sumaFuerza, carta1.getFuerza()*3)
  }

  test("A section must be a Seccion class") {
    seccion1.equals(carta1)
  }


}
