package com.edutilos.main

import scala.util.Random


object ArrayExample {
   def main(args:Array[String]): Unit = {
     var names1= new Array[String](3)
     names1(0) = "foo"
     names1(1)= "bar"
     names1(2) = "bim"

     for(name <- names1) {
       println(name)
     }

     println("foreach")
     names1.foreach(name => println(name))


     var names2 = Array("edu", "tilos", "pakos")

     for(name <- names2)
       print(s"$name, " )
     println()



     var matrix = Array.ofDim[Double](5, 5)

     val rand = new Random()
       for(i <- 0 to 4) {
         for(j <- 0 until 5) {
            matrix(i)(j) = rand.nextDouble()* 100
         }
       }

     println("<<printing matrix >>")
     for(i <- 0 to 4) {
       for(j <- 0 to  4) {
         print(s"${matrix(i)(j)} ; ")
       }
       println()
     }


     var arr1 = Array(1, 2, 3)
     var arr2 = Array(4,5,6)
     var arr3 = Array(7, 8,9)

     var concat = Array.concat(arr1, arr2, arr3)

     for(el <- concat)
       print(s"$el; ")
     println()


     var arrFromRange = Array.range(10 ,100 , 10)

     println("<<arrFromRange>>")
     for(el <- arrFromRange)
       print(s"$el ; ")
     println()


       var iterator = concat.iterator
     println("<<iterator>>")
     while(iterator.hasNext)
       print(s"${iterator.next} ; ")
     println()

      var reverseIterator = concat.reverseIterator
     println("<<reverseIterator>>")
     while(reverseIterator.hasNext)
       print(s"${reverseIterator.next()}; ")
     println()



     var array3D = Array.ofDim[Double](5, 5,5)

     for(i <- 0 until 5) {
       for(j <- 0 until 5) {
         for(k <- 0 until 5) {
           array3D(i)(j)(k) = rand.nextDouble()* 100
         }
       }
     }

     println("<<printing array3D>>")
     for(i <-0 until 5) {
       for(j <-0 until 5) {
         for(k <-0 until 5) {
           print(s"${array3D(i)(j)(k) ; }")
         }
         println()
       }
       println()
     }

     var tabulatedArr1 = Array.tabulate[Int](5)(x => x * 2 )
     var tabulatedArr2 = Array.tabulate(5)(_ + 1)
     var tabulatedArr3 = Array.tabulate(5)( Math.sin(_))
     var tabulatedArr4 = Array.tabulate(5)("foo "+ _)

     println("tabulatedArr1: ")
     tabulatedArr1.foreach(println(_))
     println("tabulatedArr2: ")
     tabulatedArr2.foreach(println(_))
    println("tabulatedArr3: ")
     tabulatedArr3.foreach(println(_))
     println("tabulatedArr4: ")
     tabulatedArr4.foreach(println(_))


     var copiedArr = new Array[Int](3)
       Array.copy(concat , 0 , copiedArr, 0 , 3)
     println("copied array")
     copiedArr.foreach(println(_))
   }
}
