package cl.uchile.dcc
package gwent

import munit.FunSuite

class TestCartas extends FunSuite {
  var unidad: cartaUnidad = _
  var clima: cartaClima = _

  override def beforeEach(context: BeforeEach): Unit = {
    unidad = cartaUnidad("Unidad", 2)
    clima = cartaClima("Clima")
  }
  
  test("Una carta debe tener nombre") {
    assertEquals(unidad.nombre, "Unidad")
    assertEquals(clima.nombre, "Clima")
  }
  
  test("Una carta de unidad debe tener una fuerza mayor o igual a 0") {
    assert(unidad.fuerza >= 0)
  }

}
