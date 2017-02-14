package com.edutilos.main2

import junit.framework.TestCase
import org.junit.Assert._

class TestPersonDAOMongoImpl extends TestCase{
  private var dao:PersonDAO = new PersonDAOMongoImpl

  private def insert(): Unit =  {
      dao.save(new Person(1, "foo", 10, 100.0 , true))
    dao.save(new Person(2, "bar", 20, 200.0 , false))
  }

   def testSave(): Unit = {
      insert()
       val list = dao.findAll()
     assertEquals(2, list.size)
      val p1 = list(0)
     assertEquals(1, p1.getId())
     assertEquals("foo", p1.getName())
     assertEquals(10, p1.getAge())
     assertEquals(100.0 , p1.getWage(), 0.0)
     assertEquals(true , p1.isPatient())
     clean()
   }

    def testUpdate(): Unit = {
       insert()
       dao.update(1, new Person(1, "newfoo", 66, 666.6, false))
      val p = dao.findById(1)
      assertEquals(1, p.getId())
      assertEquals("newfoo", p.getName())
      assertEquals(66, p.getAge())
      assertEquals(666.6, p.getWage(), 0.0)
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
      assertEquals(0 , size)
      clean()
    }

  private def clean(): Unit = {
   dao.deleteAll()
  }
}
