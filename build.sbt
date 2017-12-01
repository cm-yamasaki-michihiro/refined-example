name := "refined-example"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "eu.timepit" %% "refined" % "0.8.4",
  "io.circe" %% "circe-core" % "0.8.0",
  "io.circe" %% "circe-generic" % "0.8.0",
  "io.circe" %% "circe-parser" % "0.8.0",
  "io.circe" %% "circe-refined" % "0.8.0"
)
