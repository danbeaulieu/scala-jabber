import java.io.PrintWriter
import sbt._
import Keys._

object BuildSettings {

  val buildOrganization = "com.z0rchain"
  val buildVersion = "1.0"
  val buildScalaVersion = "2.9.2"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    scalacOptions := Seq("-deprecation", "-unchecked")
  )
}

object Dependencies {
  val smack = "org.igniterealtime.smack" % "smack" % "3.2.1"
  val smackx = "org.igniterealtime.smack" % "smackx" % "3.2.1"
}

object JabberBuild extends Build {
  import Resolvers._
  import Dependencies._
  import BuildSettings._

  lazy val jabber = Project(
    id = "jabber", 
    base = file("."), 
    settings = buildSettings ++ Seq(libraryDependencies ++= Seq(smack, smackx))) 
}