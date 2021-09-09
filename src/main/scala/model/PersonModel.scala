package model

import entity.Person
import scala.concurrent.Future
import com.outworkers.phantom.dsl._


object PersonModel {
  abstract class PersonModel extends Table[PersonModel, Person] {
    object id extends UUIDColumn with PartitionKey {
      override val name = "person_id"
    }
    object name extends StringColumn
    object age extends IntColumn

    def findById(id: UUID): Future[Option[Person]] = {
      select.where(_.id eqs id ).one()
    }

    def deleteById(id: UUID): Future[Option[Person]] = {
      select.where(_.id eqs id).one()
    }
  }
}
