package cl.uchile.dcc
package gwent

import munit.FunSuite
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class observerGemasTest extends FunSuite {

  var player: Jugador = _

  var observer: observerGemas = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new Jugador("Player", 1, List(), List(), null)
    observer = new observerGemas
    player.registrarObserver(observer)


  }


  test("An observerGemas class should notify when the player gems reach 0") {
    val outputFlow = new ByteArrayOutputStream()
    val originalOutputFlow = System.out
    try {
      System.setOut(new PrintStream(outputFlow))
      player.quitarGema()
      val output = outputFlow.toString().trim()
      assertEquals(output, "Ya no te quedan gemas")
    } finally {
      System.setOut(originalOutputFlow)
    }

  }

}
