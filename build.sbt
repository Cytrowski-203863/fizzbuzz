name := "fizzbuzz"

version := "0.1"

scalaVersion := "2.12.6"

lazy val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test,
  "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test
)

lazy val lib = (project in file("lib"))
  .settings(libraryDependencies ++= testDependencies)