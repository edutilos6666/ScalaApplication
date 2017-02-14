package com.edutilos.main2



class Worker(val Name: String , val Age:Int , val Wage:Double) {
   private var name = Name
   private var age =  Age
  private var wage = Wage


    def setName(name: String): Unit = {
     this.name = name
  }

    def setAge(age:Int): Unit = {
      this.age = age
    }

    def setWage(wage:Double): Unit = {
      this.wage = wage
    }


    def setProps(name:String , age:Int, wage:Double):Unit = {
      this.name = name
      this.age = age
      this.wage = wage
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


    override  def toString(): String = {
        return this.name + " , "+ this.age + " , " + this.wage
    }

}
