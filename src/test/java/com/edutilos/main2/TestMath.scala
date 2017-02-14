package com.edutilos.main2

import junit.framework.TestCase
import org.junit.Assert._


class TestMath extends TestCase{
   // val rand = new Random()
  def testAdd() : Unit = {
    var x = 10.0
     var y = 20.0
     var sum = SimpleMath.add(x, y)
      assertEquals(30, sum , 0.0)
   }

   def testMult(): Unit = {
      var x = 10.0
      var y = 20.0
     var mult = SimpleMath.mult(x, y)
     assertEquals(200.0, mult , 0.0)
   }

  def testSub(): Unit = {
      var x = 10.0
    var y = 20.0
    var sub = SimpleMath.sub(x, y)
    assertEquals(-10.0, sub, 0.0)

  }

   def testDiv(): Unit = {
      var x = 20.0
     var y = 10.0
     var div = SimpleMath.div(x, y)
     assertEquals(2, div , 0.0)
   }

}


