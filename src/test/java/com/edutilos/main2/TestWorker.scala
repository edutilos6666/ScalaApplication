package com.edutilos.main2

import junit.framework.TestCase
import org.junit.Assert._

class TestWorker extends TestCase {

  def testMethod1(): Unit = {
     var worker = new Worker("foo", 10, 100.0)
     assertEquals("foo", worker.getName())
    assertEquals(10, worker.getAge())
    assertEquals(100.0 , worker.getWage(), 0.0)

     worker.setName("newFoo")
    assertEquals("newFoo", worker.getName())

      worker.setAge(20)
    assertEquals(20, worker.getAge())
    worker.setWage(200.0)
    assertEquals(200.0 , worker.getWage(), 1.0)
  }
}
