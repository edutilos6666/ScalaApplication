package com.edutilos.simpleProjects

import java.util.Stack
import javax.script.ScriptEngineManager


class CalculatorEngine {
  def calculate(input:String):Double =  {
    var res = 0.0
    try {
       val jsEngine = new ScriptEngineManager().getEngineByName("JavaScript")
      res = jsEngine.eval(input).toString.toDouble
      println(res)
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    return res
  }
}
