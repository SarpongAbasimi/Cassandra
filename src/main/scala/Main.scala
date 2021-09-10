
import database.AppDatabase
import entity.Person
import com.outworkers.phantom.dsl._
import config.CassandraConfig
import connector.Connector
import errors.UserNotFoundError
import java.util.UUID
import scala.concurrent.Future



object Main  {
  lazy val appConfig = CassandraConfig.loadConfig

  object Db extends AppDatabase(Connector.connector(appConfig))

  def main(args: Array[String]): Unit = {
    val person = Person(UUID.fromString("5ce72bc9-be47-4adb-82c6-a25410a1180e"), "Ben", 1)

    Db.person.findById(person.id).flatMap {
      case Some(value) => Future.successful(println(value))
      case _ => Future.failed(UserNotFoundError("The user was not found"))
    }
  }
}
