name := "googleapi.scala.js"
organization := "com.outr"
version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.6"
crossScalaVersions := List("2.12.6", "2.11.12")
scalacOptions += "-P:scalajs:sjsDefinedByDefault"

enablePlugins(ScalaJSPlugin)

jsDependencies += ProvidedJS / "platform.js"
skip in packageJSDependencies := false

publishTo in ThisBuild := sonatypePublishTo.value
sonatypeProfileName in ThisBuild := "com.outr"
publishMavenStyle in ThisBuild := true
licenses in ThisBuild := Seq("MIT" -> url("https://github.com/outr/googleapi.scala.js/blob/master/LICENSE"))
sonatypeProjectHosting in ThisBuild := Some(xerial.sbt.Sonatype.GitHubHosting("outr", "googleapi.scala.js", "matt@outr.com"))
homepage in ThisBuild := Some(url("https://github.com/outr/googleapi.scala.js"))
scmInfo in ThisBuild := Some(
  ScmInfo(
    url("https://github.com/outr/googleapi.scala.js"),
    "scm:git@github.com:outr/googleapi.scala.js.git"
  )
)
developers in ThisBuild := List(
  Developer(id="darkfrog", name="Matt Hicks", email="matt@matthicks.com", url=url("http://matthicks.com"))
)

val scalaJSDOM = "0.9.6"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % scalaJSDOM,
  "com.outr" %%% "profig" % "2.3.1"
)
