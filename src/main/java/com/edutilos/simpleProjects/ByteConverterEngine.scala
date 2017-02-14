package com.edutilos.simpleProjects



class ByteConverterEngine {
  def convert(input:Double , metric1:String , metric2:String ):Double = {
    var res:Double = 0

  if(metric2.equals("Gigabyte")) {
    res = convertToGigabyte(input , metric1)
  } else if(metric2.equals("Gibibyte")) {
    res = convertToGibibyte(input, metric1)
  } else if(metric2.equals("Megabyte")) {
    res = convertToMegabyte(input, metric1)
  } else if(metric2.equals("Mebibyte")) {
     res = convertToMebibyte(input , metric1)
  } else if(metric2.equals("Kilobyte")) {
      res = convertToKilobyte(input , metric1)
  } else if(metric2.equals("Kibibyte")) {
     res = convertToKibibyte(input , metric1)
  } else if(metric2.equals("Byte")) {
    res = convertToByte(input , metric1)
  }
    return res
  }

  /*
  Gigabyte
   Megabyte
   Kilobyte
    Gibibyte
    Mebibyte
    Kibibyte
    Byte
   */

  private def convertToByte(input:Double , metric:String): Double = {
    var res:Double = 0
      if(metric.equals("Gigabyte")) {
         res = Math.pow(10, 9).toDouble
      } else if(metric.equals("Gibibyte")) {
         res = Math.pow(2, 30).toDouble
      } else if(metric.equals("Megabyte")) {
         res = Math.pow(10, 6).toDouble
      } else if(metric.equals("Mebibyte")) {
         res = Math.pow(2, 20).toDouble
      } else if(metric.equals("Kilobyte")) {
          res = Math.pow(10, 3).toDouble
      } else if(metric.equals("Kibibyte")) {
          res = Math.pow(2, 10).toDouble
      } else if(metric.equals("Byte")) {
        res = 1
      }
    return res* input 
  }


  private def convertToGigabyte(input:Double , metric:String): Double = {
     var bytes:Double  = convertToByte(input, metric)
      return bytes / Math.pow(10, 9)
  }

  private def convertToGibibyte(input:Double, metric:String): Double = {
    var bytes:Double = convertToByte(input, metric)
    return bytes/ Math.pow(2, 30)
  }

  private def convertToMegabyte(input:Double, metric:String):Double = {
    var bytes = convertToByte(input , metric)
    return bytes/ Math.pow(10, 6)
  }

  private def convertToMebibyte(input:Double, metric:String):Double = {
    var bytes = convertToByte(input , metric)
    return bytes/ Math.pow(2, 20)
  }

  private def convertToKilobyte(input:Double, metric:String):Double = {
    var bytes = convertToByte(input , metric)
    return bytes/ Math.pow(10, 3)
  }

  private def convertToKibibyte(input:Double, metric:String):Double = {
    var bytes = convertToByte(input , metric)
    return bytes/ Math.pow(2, 10)
  }
}
