package com.edutilos.main2

import com.mongodb.MongoClient
import com.mongodb.client.model.Filters
import com.mongodb.client.{MongoCursor, MongoCollection, MongoDatabase}
import org.bson.Document

import scala.collection.mutable.ListBuffer


class PersonDAOMongoImpl extends PersonDAO {

  //properties
  private def host:String = "localhost"
  private def port:Int = 27017

  //variables
  private var client:MongoClient = null
  private var db:MongoDatabase = null
  private var collPerson:MongoCollection[Document] = null

  private def connect(): Unit = {
    client = new MongoClient(host , port)
    db = client.getDatabase("test2")
    collPerson = db.getCollection("person")
  }

  private def disconnect(): Unit = {
     client.close()
  }


  override def save(person: Person): Unit =  {
    connect()
    val doc:Document = new Document("id", person.getId())
      .append("name", person.getName())
      .append("age", person.getAge())
      .append("wage", person.getWage())
      .append("patient", person.isPatient())
    collPerson.insertOne(doc)
    disconnect()
  }

  override def deleteAll(): Unit =  {
    connect()
    collPerson.drop()
    disconnect()
  }

  override def update(id: Long, newP: Person): Unit = {
    connect()
    collPerson.replaceOne(Filters.eq("id", id),
      new Document("id", newP.getId())
      .append("name", newP.getName())
      .append("age", newP.getAge())
      .append("wage", newP.getWage())
      .append("patient", newP.isPatient()))
    disconnect()
  }

  override def findById(id: Long): Person =  {
   connect()
    val cursor = collPerson.find(Filters.eq("id", id)).iterator()
    val doc = cursor.next()
     val p = docToPerson(doc)
    disconnect()
    return p
  }

  private def docToPerson(doc:Document) : Person = {
    val id = doc.getLong("id")
    val name = doc.getString("name")
    val age = doc.getInteger("age")
    val wage = doc.getDouble("wage")
    val patient = doc.getBoolean("patient")
     return new Person(id, name, age, wage, patient)
  }

  override def findAll(): ListBuffer[Person] =   {
    val buffer = new ListBuffer[Person]()
    connect()
     val cursor= collPerson.find().iterator()
    while(cursor.hasNext) {
      val doc = cursor.next()
      buffer += docToPerson(doc)
    }
    disconnect()
    return buffer
  }

  override def delete(id: Long): Unit =  {
     connect()
      collPerson.deleteOne(Filters.eq("id", id))
    disconnect()
  }
}
