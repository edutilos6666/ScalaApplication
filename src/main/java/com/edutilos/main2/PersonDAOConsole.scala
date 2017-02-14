package com.edutilos.main2

import java.util.Scanner


object PersonDAOConsole {

  //variables
  private var dao: PersonDAO = new PersonDAOInMemoryImpl()
  private var scanner:Scanner = new Scanner(System.in)


  def main(args: Array[String]): Unit = {
    val menu:String =
      """
        1 -> save person
        2 -> update person
        3 -> delete person
        4 -> findById
        5 -> findAll
        6 -> break
      """.stripMargin

    while(true) {
      println(menu)
      var choice:Int = scanner.nextInt()
      scanner.nextLine()

      if(choice == 1) save()
      else if(choice == 2) update()
      else if(choice == 3) delete()
      else if(choice == 4) findById()
      else if(choice == 5) findAll()
      else if(choice == 6) System.exit(0)
    }

  }




  def save(): Unit = {
    println("insert id , name , age, wage, patient of person (sep by comma): ")
    var input: String = scanner.nextLine()
    var splitted:Array[String] = input.split("\\s*,\\s*")
    try {
       val id:Long = splitted(0).toLong
      val name = splitted(1)
      val age = splitted(2).toInt
      val wage = splitted(3).toDouble
      val patient = splitted(4).toBoolean
      dao.save(new Person(id, name, age, wage, patient))
    } catch {
      case ex:Exception => println(ex.getMessage())
    }
  }

  def update(): Unit = {
    println("insert old id , new name, age, wage, patient (sep by comma): ")
    val input:String = scanner.nextLine()
    val splitted: Array[String] = input.split("\\s*,\\s*")
    try {
      val id = splitted(0).toLong
      val name = splitted(1)
      val age = splitted(2).toInt
      val wage = splitted(3).toDouble
      val active = splitted(4).toBoolean
      dao.update(id , new Person(id, name, age, wage, active))
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
  }

  def delete(): Unit ={
     println("insert id of person: ")
    val id = scanner.nextLong()
    scanner.nextLine()
     dao.delete(id)
  }

  def findById(): Unit = {
      println("insert id of person : ")
    val id = scanner.nextLong()
    scanner.nextLine()
      val p:Person = dao.findById(id)
    println(p)
  }

  def findAll(): Unit = {
     val personList = dao.findAll()
      personList.foreach(p =>
        println(p)
      )
  }


  private def simpleScannerTest(): Unit = {
    var scanner = new Scanner(System.in)
    println("insert your name: ")
    var name = scanner.nextLine()
    println("insert your age: ")
    var age:Int = scanner.nextInt()
    scanner.nextLine()
    println("insert your wage: ")
    var wage:Double = scanner.nextDouble()
    scanner.nextLine()
    println("insert if your are patient or not: ")
    var patient:Boolean = scanner.nextBoolean()
    scanner.nextLine()
    println("insert your id: ")
    var id:Long = scanner.nextLong()
    scanner.nextLine()

    println(s"name = $name, age = $age , wage = $wage , patient = $patient , id = $id")
  }
}
