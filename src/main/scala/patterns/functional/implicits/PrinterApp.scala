package patterns.functional.implicits

sealed trait OutputFileType
case class PDF(fileLocation: String) extends OutputFileType
case class XLS(fileLocation: String) extends OutputFileType
case class TXT(fileLocation: String) extends OutputFileType
case class TIFF(fileLocation: String) extends OutputFileType

trait Printer[P] {
  def print(outputFileType: P) : Unit
}

object PrinterApp {
  implicit object PDFPrinter extends Printer[PDF] {
    override def print(outputFileType: PDF): Unit = {
      println("PDF Printing started..." + outputFileType.toString)
    }
  }
  implicit object XLSPrinter extends Printer[XLS] {
    override def print(outputFileType: XLS): Unit = {
      println("XLS Printing started..." + outputFileType.toString)
    }
  }
  implicit object TXTPrinter extends Printer[TXT] {
    override def print(outputFileType: TXT): Unit = {
      println("TXT Printing started..." + outputFileType.toString)
    }
  }
  implicit object TIFFPrinter extends Printer[TIFF] {
    override def print(outputFileType: TIFF): Unit = {
      println("TIFF Printing started..." + outputFileType.toString)
    }
  }

  def printFile2 [T] (outputFileType: T) (implicit printer: Printer[T]): Unit = {
    printer.print(outputFileType)
  }

  def printFile [T: Printer] (outputFileType: T): Unit = {
    implicitly[Printer[T]].print(outputFileType)
  }

  def prints[T: Printer](xs: List[T]): Unit = {
    for (x <- xs) { implicitly[Printer[T]].print(x) }
  }

  def main(args: Array[String]): Unit = {
    printFile(PDF("/home/kishoj/test1.pdf"))
    printFile2(PDF("/home/kishoj/test2.pdf"))

    printFile(XLS("/home/kishoj/test3.xls"))
    printFile2(XLS("/home/kishoj/test4.xls"))

    //prints(List(PDF("/home/kishoj/one.pdf"), XLS("/home/kishoj/two.xls")))
  }
}
