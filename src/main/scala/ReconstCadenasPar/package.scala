import common._
import Oraculo._
import ArbolSufijos._
import ReconstCadenas._

package object ReconstCadenasPar {
  // Ahora versiones paralelas

  def reconstruirCadenaIngenuoPar(umbral: Int)(n: Int, o: Oraculo):Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa paralelismo de tareas
    val posiblesCadenas=getAlfabetoN(n)

    def reconstruirCadena(posiblesCadenas:Seq[Seq[Char]]):Seq[Char]={
      //recibe la secuencia de cadenas candidatas
      //si la longitud de la secuencia es mayor al umbral se parte en dos para hacer paralelismo de tareas
      //si la longitud es igual o menor al umbral se busca la secuencia del oraculo usando el metodo secuencial
      val cantidadCadenas=posiblesCadenas.length
      if(cantidadCadenas>umbral){
        val (posiblesCadenas1,posiblesCadenas2) = posiblesCadenas.splitAt(cantidadCadenas/2)
        val (resultado1,resultado2)= parallel(reconstruirCadena(posiblesCadenas1),reconstruirCadena(posiblesCadenas2))
        resultado1++resultado2
      }
      else {
        encontrarCadena(posiblesCadenas,o)
      }
    }
    reconstruirCadena(posiblesCadenas)
  }

  def reconstruirCadenaMejoradoPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa paralelismo de tareas y/o datos
    ???
  }

  def reconstruirCadenaTurboPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa paralelismo de tareas y/o datos
    ???
  }

  def reconstruirCadenaTurboMejoradaPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa paralelismo de tareas y/o datos
    ???
  }

  def reconstruirCadenaTurboAceleradaPar(umbral: Int)(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa arboles de sufijos para guardar Seq[Seq[Char]]
    // Usa paralelismo de tareas y/o datos
    ???
  }
}