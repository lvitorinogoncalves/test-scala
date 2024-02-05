ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10" //Versão compatível com o akka porém já tem a 3.x.x

lazy val root = (project in file("."))
  .settings(
    name := "test-scala",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.5.0",
      "com.typesafe.akka" %% "akka-actor-typed" % "2.8.0",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.5.0",
      "com.typesafe.akka" %% "akka-stream" % "2.8.0"
    )
  )
