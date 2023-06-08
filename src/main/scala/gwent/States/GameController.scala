package cl.uchile.dcc
package gwent.States

import gwent.Jugador
import gwent.Cartas.*
import gwent.Tablero.*

import java.util.Objects

class GameController extends Equals{
  private var jugador: Jugador = _
  private var cpu: Jugador = _
  var state: GameState = new InicioRonda(this)

  def getJugador: Jugador = jugador

  def getCpu: Jugador = cpu

  def addJugador(nombre: String, mano: List[abstractCartaUnidad], mazo: List[abstractCartaUnidad], tablero: Tablero): Unit = {
    jugador = new Jugador(nombre, 2, mano, mazo, tablero)
  }

  def addCpu(nombre: String, mano: List[abstractCartaUnidad], mazo: List[abstractCartaUnidad], tablero: Tablero): Unit = {
    cpu = new Jugador(nombre, 2, mano, mazo, tablero)
  }

  def startGame(nombre1: String,
                mano1: List[abstractCartaUnidad],
                mazo1: List[abstractCartaUnidad],
                tablero1: Tablero,
                nombre2: String,
                mano2: List[abstractCartaUnidad],
                mazo2: List[abstractCartaUnidad],
                tablero2: Tablero
               ): Unit = {
    addJugador(nombre1, mano1, mazo1, tablero1)
    addCpu(nombre2, mano2, mazo2, tablero2)
    state =  new InicioRonda(this)
  }



  override def canEqual(that: Any): Boolean = that.isInstanceOf[GameController]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[GameController]
      jugador == other.getJugador && cpu == other.getCpu
    } else {
      false
    }
  }


  override def hashCode: Int = {
    Objects.hash(classOf[GameController], getJugador, getCpu, state)
  }
  
  
  





}
