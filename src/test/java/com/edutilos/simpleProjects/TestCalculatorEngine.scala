package com.edutilos.simpleProjects

import com.edutilos.simpleProjects.CalculatorEngine
import junit.framework.TestCase
import org.junit.Assert._

class  TestCalculatorEngine extends TestCase {
  private val engine = new CalculatorEngine

  def testMethod1(): Unit = {
    var input = "1+2"
    var res:Double = engine.calculate(input)
    assertEquals(3 , res, 0.0)
    input = "(1+2)*3 + (4+2)"
    res = engine.calculate(input)
    assertEquals(15, res, 0.0)
  }

  def testMethod2(): Unit = {
    var input = "Math.sin(15)"
    var res = engine.calculate(input)
    assertEquals(0.65028784015, res, 0.1)
    input = "Math.cos(15)"
    res = engine.calculate(input)
    assertEquals(-0.75968791285, res, 0.1)
  }
}
