ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.20"

lazy val root = (project in file("."))
  .settings(
    name := "proyecto_programacion_funcional"
  )
libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.19" % Test
testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")
// Recommended: run benchmarks sequentially to avoid CPU contention
Test / parallelExecution := false