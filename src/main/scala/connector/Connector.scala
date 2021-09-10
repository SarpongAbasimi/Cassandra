package connector

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoint, KeySpace}
import com.outworkers.phantom.dsl._
import config.CassandraConfig

object Connector {
  def connector(config: CassandraConfig): CassandraConnection = ContactPoint(config.port).keySpace(
    KeySpace(config.keySpace).ifNotExists().`with`(replication eqs(SimpleStrategy.replication_factor(3)))
  )
}
