package com.edutilos

import scala.util.Random


object MyFunctions {
  def main(args:Array[String]): Unit = {
    val adder = (x:Double, y:Double)  => x + y

    var multiplier = (x:Double, y:Double) => x* y

    var divider = (x:Double, y:Double) => x /y

    var processor = (f:(Double, Double)=> Double, x:Double, y:Double) => f(x,y)


    var x:Double = 10
    var y:Double = 5
    var res = processor(adder, x, y)
    println(s"${x} + ${y} = ${res}")
    res = processor(multiplier, x, y)
    println(s"${x} * ${y} = ${res}")
    res = processor(divider, x, y)
    println(s"${x} / ${y} = ${res}")



    var propPrinter = (name:String , age:Int, wage:Double, active:Boolean) => println(s"$name, $age, $wage, $active")

    combiner(adder, multiplier , (x:Double, y:Double)=> x -y , (x:Double, y:Double)=> x/y , propPrinter ,
      x, y,
    "foo", 10, 100.0, true)


    val defaultName = "foo"
    val defaultAge = 10
    val defaultWage = 100.0

    var printOnlyWage = printProps(name=defaultName, age = defaultAge , _:Double)

    val rand = new Random()

    printOnlyWage(rand.nextDouble())


    var printOnlyName = printProps(_:String , age = defaultAge , wage = defaultWage)
    printOnlyName("edutilos")


    var printOnlyAge = printProps(name = defaultName, _:Int , wage = defaultWage)
    printOnlyAge(rand.nextInt())


    printPropsCurry(defaultName)(defaultAge)(defaultWage)



  }


   def Add(x:Double, y:Double): Double = {
     return x + y
   }

  def Mult(x:Double, y:Double):Double = {
    return x * y
  }

  def printPropsCurry(name:String)(age:Int)(wage:Double):Unit = {
    println(s"$name , $age, $wage")
  }


  def printProps(name:String , age:Int , wage:Double): Unit = {
     println(s"$name , $age, $wage")
  }



  def combiner (adder: (Double, Double) => Double,
                multiplier:(Double, Double)=> Double ,
                subtractor:(Double, Double)=> Double,
                divider:(Double, Double)=> Double,
                propPrinter:(String , Int, Double, Boolean)=> Unit,
                n1:Double, n2:Double ,
                name:String, age:Int , wage:Double, active:Boolean
               ) :Unit = {


    println("<<combiner results>>")
    var res = adder(n1, n2)
    println(s"${n1}+ ${n2} = ${res}")
    res = multiplier(n1, n2)
    println(s"${n1}* ${n2} = ${res}")
    res = subtractor(n1, n2)
    println(s"${n1} - ${n2}= ${res}")
    res = divider(n1, n2)
    println(s"${n1}/ ${n2}= ${res}")
    propPrinter(name, age, wage, active)
  }

}
