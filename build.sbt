name := "cassandra"

version := "0.1"

scalaVersion := "2.12.8"

lazy val Versions = new {
  val phantom = "2.39.0"
  val util = "0.50.0"
  val scalatest = "3.0.5"
  val pureConfigVersion = "0.16.0"
  val configVersion = "1.4.1"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.typesafeRepo("releases"),
  Resolver.bintrayRepo("websudos", "oss-releases")
)

libraryDependencies ++= Seq(
  "com.outworkers"  %%  "phantom-dsl"       % Versions.phantom,
  "com.outworkers"  %%  "phantom-streams"   % Versions.phantom,
  "com.outworkers"  %%  "util-testing"      % Versions.util % Test,
  "org.scalatest"   %%  "scalatest"         % Versions.scalatest % Test,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.github.pureconfig" %% "pureconfig" % Versions.pureConfigVersion,
  "com.typesafe" % "config" % Versions.configVersion
)