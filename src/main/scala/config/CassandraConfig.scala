package config

import com.typesafe.config.ConfigFactory
import pureconfig.ConfigSource
import pureconfig.generic.auto._

case class CassandraConfig (keySpace: String, port: Int)

object CassandraConfig {
  def loadConfig: CassandraConfig = ConfigSource
    .fromConfig(ConfigFactory.load().getConfig("cassandra"))
    .loadOrThrow[CassandraConfig]
}
