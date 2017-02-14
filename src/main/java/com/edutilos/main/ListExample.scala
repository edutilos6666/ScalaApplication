package com.edutilos.main



object ListExample {
  def main(args: Array[String]) {
    var l1 = List("foo", "bar", "bim")
     println("first list")
    for(el <- l1)
      print(s"$el, " )
    println()


    var l2 = List(
      List("foo", 10 , 100.0),
      List("bar", 20 , 200.0),
      List("bim", 30 , 300.0)
    )

    println("List inside List")
    for(l <- l2) {
      for(el <- l)
        print(s"$el, ")
      println()
    }

    l2.foreach(l => {
       l.foreach(el => {
         print(s"$el , ")
       })
      println()
    })

    var l3 = 1::2::3::Nil

    println("list3 ")
    for(el <- l3)
      print(s"$el , ")
    println()


    var a1= List("foo", "bar")
    var a2 = List("edu", "tilos")
    var a3 = List("pako", "deko")
    var aConcat1 = List.concat(a1, a2, a3)

    println("<<aConcat1>>")
    for(el <- aConcat1) print(s"$el ; ")
    println()

    var aConcat2 = a1 ::: a2 ::: a3
    println("<<aConcat2>>")
    for(el <- aConcat2) print(s"$el; ")
    println()



    var aUniform = List.fill(10)("foo")
    println("uniform list: ")
    for(el <- aUniform) print(s"$el; ")
    println()


    var aTabulate = List.tabulate(10)(x => Math.pow(x, 3))
    println("aTabulate (x^3): ")
    for(el <- aTabulate) print(s"$el , ")
    println()

    println(aTabulate.reverse)

    aTabulate
  }

}
