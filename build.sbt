ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10" //Versão compatível com o akka porém já tem a 3.x.x

lazy val root = (project in file("."))
  .settings(
    name := "test-scala"
  )
