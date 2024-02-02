package testsCodes

import java.io.PrintWriter
import scala.io.Source
class TransformData {
  def readAndTransformData(): Unit = {
    val inputFile = "input.csv"
    val outFile = "output.csv"

    val lines = Source.fromFile(inputFile).getLines().toList

    val outputHeader = "Nome, País"

    val transformData = lines.tail
      .map(_.split(","))
      .filter(fields => fields.length >= 4 && fields(1).toInt >= 18)
      .map(fields => s"${fields(0)},${fields(3)}")

    new PrintWriter(outFile) {
      write(outputHeader + "\n")
      transformData.foreach(line => write(line + "\n"))
      close()
    }

    println("Data transformation")
  }
}
