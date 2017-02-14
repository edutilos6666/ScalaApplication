package main.java.com.edutilos.main

import scala.collection.mutable.ListBuffer

object Example1 {
   def main(args:Array[String]): Unit = {
     println("hello world")

     var name = "foo"
     var age = 10
     var wage = 100.0

     println("name = "+ name)
     println("age = "+ age)
     println("wage = "+ wage)

     var (pName:String, pAge:Int, pWage:Double, pPatient:Boolean) = ("foo", 10, 100.0 , true)
     println("name = "+ pName)
     println("age = "+ pAge)
     println("wage = "+ pWage)
     println("patient = "+ pPatient)
     println(s"name = ${pName}, age = ${pAge}, wage = ${pWage}, patient = ${pPatient}")



     var p1 = new Person("foo", 10, 100.0)
     var p2 = new Person("bim", 20 , 200.0)

     var people:List[Person] = List(p1, p2)

     people.foreach((p:Person)=>
       println(p))



     var (p3, p4) = (new Person("edu", 30, 300.0),
       new Person("tilos", 40, 400.0))

    /* people = p3::people
     people = p4::people
*/
      var buffer = new ListBuffer[Person]()
     people.foreach(p => buffer += p)
     buffer += p3
     buffer += p4

     println("people after :: method: ")
     buffer.foreach(p => println(p))


     var w : Worker = new Worker("foo", 10 , 100.0 , true)
     println(w)
   }
}


class Worker(override val Name:String, override val Age: Int ,
             override val Wage:Double, val Active:Boolean) extends Person(Name, Age, Wage) {
  var active = Active

  def setActive(active:Boolean): Unit = {
    this.active = active
  }

  def isActive(): Boolean = {
    return this.active
  }

  override def toString(): String =  {
     var res = super.toString()
    res  += s", $active"
    return res
  }
}

class Person(val Name:String , val Age:Int,val Wage:Double) {
  var name = Name
  var age = Age
  var wage = Wage

  def setName(name:String): Unit = {
    this.name = name
  }

  def setAge(age:Int): Unit = {
    this.age = age
  }

  def setWage(wage:Double): Unit = {
    this.wage = wage
  }

  def getName(): String = {
    return this.name
  }

  def getAge(): Int = {
    return this.age
  }

  def getWage(): Double = {
    return this.wage
  }


  override def toString() :String = {
    return s"$name , $age, $wage"
  }


  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        name == that.name &&
        age == that.age &&
        wage == that.wage
    case _ => false
  }

  override def hashCode(): Int = {
    var state = Seq(name, age, wage)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
