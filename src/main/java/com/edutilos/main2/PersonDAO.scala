package com.edutilos.main2

import scala.collection.mutable.ListBuffer


trait PersonDAO {
  def save(person: Person)
  def update(id:Long , newP:Person)
  def delete(id:Long)
  def findById(id:Long): Person
  def findAll(): ListBuffer[Person]
  def deleteAll()
}
