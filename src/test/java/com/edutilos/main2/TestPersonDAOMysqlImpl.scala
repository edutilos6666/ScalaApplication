package com.edutilos.main2

import junit.framework.TestCase
import org.junit.Assert._

import scala.collection.mutable.ListBuffer

class TestPersonDAOMysqlImpl extends TestCase{
  private def dao:PersonDAO  = new PersonDAOMysqlImpl


  def testSave(): Unit = {
    insert()
    val list:ListBuffer[Person] = dao.findAll()
    assertEquals(2 , list.size)
    var p = list(0)

    assertEquals(1, p.getId())
    assertEquals("foo", p.getName())
    assertEquals(10, p.getAge())
    assertEquals(100.0 , p.getWage(), 0.0)
    assertEquals(true, p.isPatient())
    clean()
  }


  def testUpdate = {
    insert()
    dao.update(1, new Person(1, "newfoo", 66, 666.6, false))
    var p = dao.findById(1)
    assertEquals(1, p.getId())
    assertEquals("newfoo", p.getName())
    assertEquals(66, p.getAge())
    assertEquals(666.6, p.getWage(), 0.0)
    assertEquals(false, p.isPatient())
    clean()
  }

  def testDelete(): Unit =  {
     insert()
      var size = dao.findAll().size
    assertEquals(2, size)
      dao.delete(1)
     size = dao.findAll().size
    assertEquals(1, size)
      dao.delete(2)
    size = dao.findAll().size
    assertEquals(0, size)
     clean()
  }


  private def insert(): Unit = {
    dao.save(new Person(1, "foo", 10, 100.0 , true))
    dao.save(new Person(2, "bar", 20, 200.0 , false))
  }

  private def clean(): Unit = {
    dao.deleteAll()
  }
}
