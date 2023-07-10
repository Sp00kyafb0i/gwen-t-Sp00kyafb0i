package cl.uchile.dcc
package gwent


import cl.uchile.dcc.gwent.Cartas.{cartaClima, cartaUnidadAsed, cartaUnidadCaC, cartaUnidadDist}
import cl.uchile.dcc.gwent.Tablero.SeccionUnidades
import munit.FunSuite
class SeccionUnidadesTest extends FunSuite {
  
  val falso: Boolean = false


  var carta1 = new cartaUnidadCaC("Geralt", 3, falso, falso)
  var carta2 = new cartaUnidadAsed("Trebuchet", 4, falso, falso)
  var carta3 = new cartaUnidadDist("Yennefer", 3, falso, falso)
  var carta4 = new cartaClima("Sunny day", falso, falso, falso)
  var carta5 = new cartaUnidadCaC("prueba", 1, true, falso)
  var carta6 = new cartaUnidadCaC("prueba", 1, falso, true)
  var carta7 = new cartaUnidadCaC("prueba", 1, falso, true)

  var listaCaC = List(carta1, carta1, carta1)
  var listaAsed = List(carta2, carta2, carta2)
  var listaDist = List(carta3, carta3, carta3)
  var listaRefuerzo = List(carta5, carta1)
  var listaVinculo = List(carta6, carta7, carta1)

  var seccion1: SeccionUnidades = _
  var seccion2: SeccionUnidades = _
  var seccion3: SeccionUnidades = _
  var seccion4: SeccionUnidades = _
  var seccion5: SeccionUnidades = _
  var seccionRefuerzo: SeccionUnidades = _
  var seccionVinculo: SeccionUnidades = _

  override def beforeEach(context: BeforeEach): Unit = {
    seccion1 = new SeccionUnidades(listaCaC)
    seccion2 = new SeccionUnidades(listaAsed)
    seccion3 = new SeccionUnidades(listaDist)
    seccion4 = new SeccionUnidades(listaCaC)
    seccion5 = new SeccionUnidades(listaAsed)
    seccionRefuerzo = new SeccionUnidades(listaRefuerzo)
    seccionVinculo = new SeccionUnidades(listaVinculo)
  }

  test("A section should be able to react to a vinculo estrecho card") {
    seccionVinculo.vinculoEstrecho(carta6)
    var suma = seccionVinculo.sumaFuerza
    assertEquals(suma, 7)
  }

  test("A section should be able to react to a refuerzo moral card") {
    seccionRefuerzo.refuerzoMoral(carta5)
    var suma = seccionRefuerzo.sumaFuerza
    assertEquals(suma, 5)
  }

  test("A section should be created with a list of cards") {
    assertEquals(new SeccionUnidades(listaCaC), seccion1)
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
