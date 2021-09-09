package database

import com.outworkers.phantom.connectors.CassandraConnection
import com.outworkers.phantom.dsl.Database
import model.PersonModel._

class AppDatabase(override val connector: CassandraConnection) extends Database(connector){
  object person extends PersonModel with connector.Connector
}
