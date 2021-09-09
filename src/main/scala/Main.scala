
import database.AppDatabase
import entity.Person
import com.outworkers.phantom.dsl._
import java.util.UUID
import scala.concurrent.Future

trait Service extends DatabaseProvider[AppDatabase] {
  def find(person: Person): Future[Option[Person]] = {
    for {
      byId <- findById(person.id)
    } yield byId
  }

  def findById(id: UUID): Future[Option[Person]] = db.person.findById(id)
}

object Main  {

  def main(args: Array[String]): Unit = {

  }
}
