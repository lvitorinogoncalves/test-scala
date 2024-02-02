import testsCodes.{RunCodes, TransformData}

object main {
  def main(agrs: Array[String]): Unit = {
    println("API-Scala")
    RunCodes.runCodes()
    val transformData = new TransformData
    transformData.readAndTransformData()
  }
}