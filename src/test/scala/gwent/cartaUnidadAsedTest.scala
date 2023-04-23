package cl.uchile.dcc
package gwent

import munit.FunSuite

class cartaUnidadAsedTest extends FunSuite {
  val nombre = "Test"
  val nombre2 = "Test2"
  val fuerza = 3
  val fuerza2 = 4

  var carta: cartaUnidadAsed = _
  var carta2: cartaUnidadAsed = _
  var carta3: cartaUnidadAsed = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta = new cartaUnidadAsed(nombre, fuerza)
    carta2 = new cartaUnidadAsed(nombre, fuerza)
    carta3 = new cartaUnidadAsed(nombre2, fuerza2)
  }

  test("A melee unit card can be created with a name and a strength") {
    assertEquals(new cartaUnidadAsed(nombre, fuerza), carta)
  }

  test("The hash code of a cartaUnidadCaC i consistent with equals") {
    assertEquals(new cartaUnidadAsed(nombre, fuerza).##, carta.##)
  }

  test("A card's strength must be larger or equal to 0") {
    assert(carta.fuerza >= 0)
  }

  test("A card must be able to return it's strength") {
    assertEquals(carta.getFuerza(), fuerza)
  }

  test("A card must be able to increase it's strength by 1") {
    carta.aumentarFuerza()
    assertEquals(carta.fuerza, fuerza+1)
  }

  test("A card must be able to go back to it's original strength") {
    carta.aumentarFuerza()
    carta.restablecer()
    assertEquals(carta.fuerza, fuerza)
  }

  test("A card must be able to decrease it's strength to 1") {
    carta.disminuirFuerza()
    assertEquals(carta.fuerza, 1)
  }

  test("A card must be able to return it's original strength") {
    assertEquals(carta.getFuerzaOriginal(), fuerza)
  }

  test("Two siege cards with the same name and strength should be the same") {
    assertEquals(carta, carta2)
    assertEquals(carta2, carta)
    assertNotEquals(carta, carta3)
    assertEquals(carta.hashCode(), carta2.hashCode())
    assertNotEquals(carta.hashCode(), carta3.hashCode())
  }

  test("A siege card must be a cartaUnidadAsed class") {
    carta.equals(nombre)
  }

}
