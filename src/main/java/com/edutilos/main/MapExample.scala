package com.edutilos.main

import scala.util.Random

/**
  * Created by edutilos on 14/02/2017.
  */
object MapExample {
  def main(args: Array[String]) {
    val rand = new Random()

    var map1:Map[String,Double] = Map()
    map1 += ("foo"-> rand.nextDouble()* 100)
    map1 += ("bar"-> rand.nextDouble()* 100)
    map1 += ("bim"-> rand.nextDouble()* 100)

    println(map1.keys)
    println(map1.values)

    map1.foreach(t => println(s"${t._1}, ${t._2}"))

    var iter1 = Iterator(10 , 20 , 30 , 40)
    println(iter1.min)
    iter1 = Iterator(10 , 20 , 30 , 40)
    println(iter1.max)
    iter1 = Iterator(10 , 20 , 30 , 40)
    while(iter1.hasNext)println(iter1.next())
  }
}
