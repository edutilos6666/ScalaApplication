package com.edutilos.main2

import java.sql._

import com.mysql.cj.jdbc

import scala.collection.mutable.ListBuffer


class PersonDAOMysqlImpl extends PersonDAO {


  //properties
  private val url = "jdbc:mysql://localhost/test"
  private val user = "root"
  private val pass = ""

  //variables
  private var conn:Connection = null
  private var stmt:Statement = null
  private var pstmt:PreparedStatement = null
  private var rs:ResultSet = null


  //default constructor

    DriverManager.registerDriver(new jdbc.Driver)
    dropCreateTable()


  private def connect(): Unit = {
    try {
      conn = DriverManager.getConnection(url, user, pass)
      stmt = conn.createStatement()
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    }

  private def disconnect(): Unit = {
    try {
      if (rs != null) rs.close()
      if (pstmt != null) pstmt.close()
      if (stmt != null) stmt.close()
      if (conn != null) conn.close()
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    }

  private def dropCreateTable(): Unit = {
    connect()
/*    var cmd: String = """drop table if exists Person"""
     stmt.executeUpdate(cmd)*/

    var cmd  =
      """create table if not exists Person (
        |id bigint not null primary key ,
        |name varchar(50) not null ,
        |age int not null ,
        |wage double not null,
        |patient boolean not null
        |)
      """.stripMargin
    try {
      stmt.executeUpdate(cmd)
    } catch  {
      case ex:Exception => println(ex.getMessage)
    }
     disconnect()
  }


  override def save(person: Person): Unit =  {
    connect()
   val cmd:String =
     s"""insert into Person VALUES
        |(${person.getId}, "${person.getName}", ${person.getAge}, ${person.getWage}, ${person.isPatient})""".stripMargin
    try {
      stmt.executeUpdate(cmd)
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    disconnect()
  }

  override def deleteAll(): Unit =  {
    connect()
    val cmd:String = s"""delete from Person"""
    try {
      stmt.executeUpdate(cmd)
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    disconnect()
  }

  override def update(id: Long, newP: Person): Unit =  {
    connect()
    val cmd:String =
      s"""update Person set name = "${newP.getName}",
         |age = ${newP.getAge()}, wage = ${newP.getWage()}, patient = ${newP.isPatient()}
         |where id = id
       """.stripMargin
    try {
       stmt.executeUpdate(cmd)
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    disconnect()
  }

  override def findById(id: Long): Person =  {
    connect()
    var p:Person = null
    val  cmd:String = s"""select * from Person where id = ${id}"""
    try {
      rs = stmt.executeQuery(cmd)
      rs.next()
      p = rsToPerson()
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    disconnect()
    return p
  }

  private def rsToPerson() : Person = {
    var p = new Person()
    p.setId(rs.getLong(1))
    p.setName(rs.getString(2))
    p.setAge(rs.getInt(3))
    p.setWage(rs.getDouble(4))
    p.setPatient(rs.getBoolean(5))
    return p
  }

  override def findAll(): ListBuffer[Person] =  {
    val list: ListBuffer[Person] = new ListBuffer[Person]()
    connect()
     val cmd = s"""select * from Person"""
     try {
        rs = stmt.executeQuery(cmd)
       while(rs.next()) {
         list += rsToPerson()
       }
     } catch {
       case ex:Exception => println(ex.getMessage)
     }
    disconnect()
    return list
  }

  override def delete(id: Long): Unit =  {
    connect()
     val cmd = s"""delete from Person where id = $id"""
    try {
       stmt.executeUpdate(cmd)
    } catch {
      case ex:Exception => println(ex.getMessage)
    }
    disconnect()
  }
}
