package com.edutilos.main2

import junit.framework.TestCase
import org.junit.Assert._

import scala.collection.mutable.ListBuffer

/**
  * Created by edutilos on 14/02/2017.
  */
class TestPersonDAOInMemoryImpl extends TestCase {

  private var dao:PersonDAO = new PersonDAOInMemoryImpl()


  def testSave(): Unit = {
     insert()
    val list = dao.findAll()
     var size = list.size
      assertEquals(2 , size)

     var p1 =  list(0)
      assertEquals("foo", p1.getName())
    assertEquals(10 , p1.getAge())
    assertEquals(1 , p1.getId())

    clean()
  }


    def testUpdate(): Unit = {
      insert()
       dao.update(1L , new Person(1L , "newfoo", 66, 666.6, false))

      val p = dao.findById(1)
      assertEquals(1l , p.getId())
      assertEquals("newfoo", p.getName())
      assertEquals(66, p.getAge())
      assertEquals(666.6, p.getWage(), 1.0)
      assertEquals(false, p.isPatient())

      clean()
    }

     def testDelete(): Unit = {
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
      dao.save(new Person(1l, "foo", 10, 100.0 , true))
      dao.save(new Person(2L , "bar", 20, 200.0 , false))
  }

  private def clean():Unit = {
      dao.deleteAll()
  }
}
