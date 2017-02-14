package com.edutilos.main

/**
  * Created by edutilos on 14/02/2017.
  */
object SetExample {
  def main(args: Array[String]) {
    var set1 = Set(1, 2, 3,4)
    var set2 = Set(2, 3, 4, 5)

    var setDiff12 = set1.diff(set2)
    var setDiff21 = set2.diff(set1)
    var setIntersect = set1.intersect(set2)


    println(set1)
    set1 = set1 + 10
    println(set1)

    var setCombined = set1 ++ set2
    println(setCombined)

    println(setDiff12)
    println(setDiff21)
    println(setIntersect)

    setCombined = setDiff12 ++ setDiff21 ++ setIntersect
    println(setCombined)
  }

}
