package testsCodes

object RunCodes {
  def runCodes(): Unit = {
    val animalsList: List[String] = List("cat", "dog", "fish", "bird", "mouse")
    val numbres: List[Int] = List(1,2,3,4,5,6,7,8,9)

    val animalTarget = "dog"
    val animalFound = animalsList.find(_ == animalTarget)

    println(animalFound)

//    animalFound match
//      case Some(animalFoundOk) =>
//        println(s"Animal '$animalFoundOk' was found")
//      case None =>
//        println(s"Animal '$animalTarget' not found")

    val resultNumbersList = multiplyNumbers(numbres)
    println(resultNumbersList)

    val list1: List[String] = List("cat", "dog", "bird", "mouse", "lion", "tiger", "elephant", "alligator")
    val list2: List[String] = List("cat", "dog", "bird", "mouse")

    val resultVerifyPetAnimals = findPetAnimals(list1, list2)
    println(resultVerifyPetAnimals)
  }

  def multiplyNumbers(listNumbers: List[Int]): List[Int] = {
    listNumbers.map(_ * 2)
  }

  def findPetAnimals(list1: List[String], list2: List[String]): List[String] = {
    val (largerList, smallerList) = if (list1.length >= list2.length) (list1, list2) else (list2, list1)
    val listPets = smallerList.filter(largerList.contains)
    listPets.map(item => item + " pode ser um pet")
  }
}
