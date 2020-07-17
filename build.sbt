name := """bookshop"""
organization := "com.safnas.example"

version := "1.0-SNAPSHOT"

lazy val hello = taskKey[Unit]("Custom Task")

lazy val root = (project in file(".")).enablePlugins(PlayJava).settings(
  hello := { println("this is a custom task!!")}
)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  javaJdbc,
  cacheApi,
  guice)
