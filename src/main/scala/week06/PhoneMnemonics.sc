val words = List("") filter (s => s forall (c => c.isLetter))

val mnemonics = Map('2' -> "ABC", '3' -> "DEF",
  '4' -> "GHI", '5' -> "JKL",
  '6' -> "MNO", '7' -> "PQRS",
  '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char, Char] = mnemonics.flatMap(p => {
  val (number, letters) = p;
  letters.map(l => (l, number))
})

def wordCode(word: String) = word.toUpperCase map charCode

val wordsForNum: Map[String, Seq[String]] = words groupBy wordCode

def encode(number: String)


