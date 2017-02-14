package com.edutilos.simpleProjects

import junit.framework.TestCase
import org.junit.Assert._

class TestByteConverterEngine extends TestCase {
   private val engine = new ByteConverterEngine

    def testMethod1(): Unit = {
      val metrics = List("Byte", "Kilobyte", "Kibibyte", "Megabyte", "Mebibyte", "Gigabyte", "Gibibyte")
      var input:Double = 12 //GB
      metrics.foreach(metric2 =>
        println(engine.convert(12, "Gigabyte", metric2))
      )
    }
}
