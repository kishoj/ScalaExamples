package patterns.functional.implicits

sealed trait FileSource
case class FTPSource(url: String, username: String, password: String) extends FileSource
case class HTTPSource(url: String) extends FileSource
case class LocalFileSource(fileLocation: String) extends FileSource

trait Downloader [T] {
  def download(t: T): Unit
}

object DownloaderTest {

  implicit object FTPFileDownloader extends Downloader[FTPSource] {
    override def download(t: FTPSource): Unit = {
      println("Downloading from FTP source")
    }
  }

  implicit object HTTPFileDownloader extends Downloader[HTTPSource] {
    override def download(t: HTTPSource): Unit = {
      println("Downloading from HTTP source")
    }
  }

  implicit object LocalFileDownloader extends Downloader[LocalFileSource] {
    override def download(t: LocalFileSource): Unit = {
      println("Downloading from Local file source")
    }
  }

  def downloadFileFrom[T](source: T)(implicit downloader: Downloader[T]): Unit = {
    downloader.download(source)
  }

  // preferred way
  def downloadFrom[T: Downloader](source: T): Unit = {
    implicitly[Downloader [T]].download(source)
  }

  def main(args: Array[String]): Unit = {
    downloadFileFrom(FTPSource("FTP url", "FTP username", "FTP password"))
    downloadFileFrom(HTTPSource("HTTP or HTTPs url"))
    downloadFileFrom(LocalFileSource("Local File location"))

    downloadFrom(FTPSource("FTP url", "FTP username", "FTP password"))
    downloadFrom(HTTPSource("HTTP or HTTPs url"))
    downloadFrom(LocalFileSource("Local File location"))
  }
}
