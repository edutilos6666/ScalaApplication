package com.edutilos.main2



class Person(val Id:Long, val Name:String , val Age:Int , val Wage:Double, val Patient:Boolean) {
    var id = Id
  var name = Name
  var age = Age
  var wage = Wage
  var patient = Patient

  def this() {
    this(0, "", 0, 0.0, false)
  }
    def setId(id:Long): Unit = {
      this.id = id
    }

   def setName(name:String): Unit = {
     this.name = name
   }

  def setAge(age:Int): Unit = {
    this.age = age
  }

   def setWage(wage:Double): Unit = {
     this.wage = wage
   }

  def setPatient(patient: Boolean): Unit = {
    this.patient = patient
  }

    def getId():Long = {
      return this.id
    }

    def getName(): String = {
      return this.name
    }

  def getAge(): Int = {
    return this.age
  }

   def getWage(): Double = {
     return this.wage
   }

  def isPatient(): Boolean = {
    return this.patient
  }


   def setProps(id:Long , name:String, age:Int, wage:Double, patient:Boolean): Unit = {
     this.id = id
     this.name = name
     this.age = age
     this.wage = wage
     this.patient = patient
   }

   override def toString(): String = {
     val res:String = s"$id , $name , $age, $wage, $patient"
     return res
   }


}
