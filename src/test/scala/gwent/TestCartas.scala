package cl.uchile.dcc
package gwent

import munit.FunSuite

class TestCartas extends FunSuite {
  var unidad: cartaUnidad = _

  override def beforeEach(context: BeforeEach): Unit = {
    unidad = cartaUnidad("Unidad", 2)
  }
  
  test("Una carta debe tener nombre") {
    assertEquals(unidad.nombre, "Unidad")
  }
  
  test("Una carta de unidad debe tener una fuerza mayor o igual a 0") {
    assert(unidad.fuerza >= 0)
  }
  
  test("Una carta debe retornar su fuerza") {
    assert(unidad.getFuerza() == 2)
  }
  
  test("Una carta debe poder aumentar su fuerza en 1") {
    unidad.aumentarFuerza()
    assert(unidad.fuerza == 3)
  }
  
  test("Una carta debe poder reestablecer su fuerza") {
    unidad.fuerza += 1
    unidad.restablecer()
    assert(unidad.fuerza == 2)
  }
  
  test("Una carta debe poder bajar su fuerza a 1") {
    unidad.disminuirFuerza()
    assert(unidad.fuerza == 1)
  }

}
