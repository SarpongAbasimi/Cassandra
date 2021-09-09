package connector

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint, KeySpace}
import com.outworkers.phantom.dsl._

object Connector {
  /**Will move this to a config**/

  val keySpace = "learnCassandra"
  val port: Int = 7000

  def connector: CassandraConnection = ContactPoint(port).keySpace(
    KeySpace(keySpace).ifNotExists().`with`(replication eqs(SimpleStrategy.replication_factor(3)))
  )
}
