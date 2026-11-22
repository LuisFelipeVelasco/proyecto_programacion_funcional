import ArbolSufijos._
import Oraculo._

package object ReconstCadenas {

  private val ultimoIndexAlfabeto = alfabeto.length - 1
  private val primerCaracterAlfabeto = alfabeto.head
  private val ultimoCaracterAlfabeto = alfabeto.last
  private val getSiguienteCaracter = alfabeto.zip(alfabeto.tail :+ alfabeto.head).toMap

  def getSiguienteCadena( subActualCadena: Seq[Char],subSiguienteCadena: Seq[Char]): Seq[Char] = subActualCadena match {
    //recibe una cadena y retorna la siguiente cadena en base al alfabeto como un odometro
    case Seq() => Seq()
    case primerCaracter +: resto =>
      val siguienteCaracter = getSiguienteCaracter(primerCaracter)
      if (primerCaracter == ultimoCaracterAlfabeto) getSiguienteCadena(resto,subSiguienteCadena :+ siguienteCaracter)
      else (subSiguienteCadena :+ siguienteCaracter) ++ resto
  }
  def getAlfabetoN(n:Int): Seq[Seq[Char]] = {
    //recibe un entero n y retorna todas las posibles permutaciones  con longitud n del alfabeto
    val cadenaFinal= Seq.fill(n)(ultimoCaracterAlfabeto)
    val cadenaInicial= Seq.fill(n)(primerCaracterAlfabeto)

    def almacenarCadenas(cadena:Seq[Char] , almacenCadenas:Seq[Seq[Char]]): Seq[Seq[Char]] = {
      if(cadena==cadenaFinal) almacenCadenas :+ cadena
      else almacenarCadenas(getSiguienteCadena(cadena,Seq()), almacenCadenas :+ cadena)
    }
    almacenarCadenas(cadenaInicial,Seq())
  }
  def encontrarCadena(posiblesCadenas:Seq[Seq[Char]], o:Oraculo):Seq[Char]= posiblesCadenas match {
    //recibe un conjunto de cadenas , lo itera y si encuentra la cadena conocida por el oraculo la retorna
    //si el conjunto no contiene la cadena conocida por el oraculo la funcion retorna: Seq()
    case Seq() => Seq()
    case posibleCadena+:resto =>
      if(o(posibleCadena)) posibleCadena
      else encontrarCadena(resto,o)
  }
  def reconstruirCadenaIngenuo(n: Int, o: Oraculo): Seq[Char] = {
    //recibe un entero n , un oraculo  y retorna la cadena conocida por el oraculo en el alfabeto E^n
    val alfabetoN=getAlfabetoN(n)
    encontrarCadena(alfabetoN,o)
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