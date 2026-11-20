import ArbolSufijos._
import Oraculo._

package object ReconstCadenas {


  private val ultimoIndexAlfabeto = alfabeto.length - 1
  private val primerCaracterAlfabeto = alfabeto.head
  private val ultimoCaracterAlfabeto = alfabeto.last
  private val getSiguienteCaracter = alfabeto.zip(alfabeto.tail :+ alfabeto.head).toMap

  def reconstruirCadenaIngenuo(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida

    def getSiguienteCadena(subSiguienteCadena:Seq[Char],subActualCadena:Seq[Char]):Seq[Char] = subActualCadena match {
      //recibe una cadena y retorna la siguiente cadena en base al alfabeto
      //dada una cadena  c = seq(c1 ,c2 ,...,cn) , el alfabeto E =(e1, e2, e3 ... , em) y la siguiente cadena  s = seq(s1, s2,..., sn) se cumple:
      //s1 es igual al siguiente caracter de c1 en el alfabeto
      //Si c(i) es igual al ultimo caracter del alfabeto , entonces  s(i)  y s(i+1) son  iguales al siguiente caracter de c(i) y c(i+1)  en el alfabeto respectivamente

      case primerCaracter +: resto =>
        val siguienteCaracter = getSiguienteCaracter(primerCaracter)
        if (primerCaracter == ultimoCaracterAlfabeto) getSiguienteCadena(subSiguienteCadena :+ siguienteCaracter,resto)
        else (subSiguienteCadena :+ siguienteCaracter) ++ resto
      case _ => Seq()
    }

    def reconstruirCadena(posibleCadena:Seq[Char]) : Seq[Char] = {
      //recorre cada cadena del alfabeto con longitud = n hasta que encuentra la correcta usando el oraculo y la retorna.
      if(o(posibleCadena)) posibleCadena
      else{
        val siguienteCadena = getSiguienteCadena(Seq(), posibleCadena)
        reconstruirCadena(siguienteCadena)
      }
    }
    val cadenaInicial = Seq.fill(n)(primerCaracterAlfabeto)
    reconstruirCadena(cadenaInicial)
  }

  def reconstruirCadenaMejorado(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    ???
  }

  def reconstruirCadenaTurbo(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    ???
  }

  def reconstruirCadenaTurboMejorada(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa el filtro para ir mas rapido
    ???
  }

  def reconstruirCadenaTurboAcelerada(n: Int, o: Oraculo): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa el filtro para ir mas rapido
    // Usa arboles de sufijos para guardar Seq[Seq[Char]]
    ???
  }
}