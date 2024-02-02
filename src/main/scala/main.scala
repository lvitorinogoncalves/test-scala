@main
def main(): Unit = {
  println("Teste")

//  RunCodes.runCodes()
  val transformData = new TransformData
  transformData.readAndTransformData()
}
