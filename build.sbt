ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

Compile / resourceDirectory := baseDirectory.value / "assets"
Compile / unmanagedResourceDirectories += baseDirectory.value / "assets"


val gdxVersion = "1.11.0"
val catsCoreVersion = "2.6.1"
val catsEffectVersion = "3.4.10"


lazy val root = (project in file("."))
  .settings(
    name := "scalagdx"
  )

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % gdxVersion,
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % gdxVersion,
  "com.badlogicgames.gdx" % "gdx-platform" %  gdxVersion classifier "natives-desktop",
  "org.typelevel" %% "cats-core" % catsCoreVersion,
  "org.typelevel" %% "cats-effect" % catsEffectVersion
)

//libraryDependencies += "org.typelevel" %% "cats-core" % "2.2.0"
//libraryDependencies += "org.typelevel" %% "cats-effect" % "3.4.10"

//scalacOptions ++= Seq(
//  "-feature",
//  "-deprecation",
//  "-unchecked",
//  "-language:postfixOps"
//)


//libraryDependencies += "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
//
//
//libraryDependencies += "com.disneystreaming" %% "weaver-cats" % "0.7.6" % Test
//testFrameworks += new TestFramework("weaver.framework.CatsEffect")