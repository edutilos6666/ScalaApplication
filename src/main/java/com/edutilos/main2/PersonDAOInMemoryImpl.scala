package com.edutilos.main2

import scala.collection.mutable.ListBuffer


class PersonDAOInMemoryImpl() extends PersonDAO {
   private var personMap: Map[Long, Person] = Map()

 override def save(person: Person): Unit =  {
        personMap += (person.getId() -> person)
  }

  override def update(id: Long, newP: Person): Unit =  {
     personMap += (id -> newP)
  }

  override def findById(id: Long): Person =  {
      return personMap.get(id).get
  }

  override def findAll(): ListBuffer[Person] =  {
      var personList:ListBuffer[Person] = new ListBuffer[Person]()
      personMap.foreach(t =>
        personList += t._2
      )

    return personList
  }

  override def delete(id: Long): Unit = {
      personMap -= id
  }

  override def deleteAll(): Unit =  {
      personMap = Map()
  }
}
