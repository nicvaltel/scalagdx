ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

Compile / resourceDirectory := baseDirectory.value / "assets"
Compile / unmanagedResourceDirectories += baseDirectory.value / "assets"


val gdxVersion = "1.11.0"


lazy val root = (project in file("."))
  .settings(
    name := "scalagdx"
  )

libraryDependencies ++= Seq(
//  "org.scala-lang" % "scala-library" % "2.13.11",
  "com.badlogicgames.gdx" % "gdx" % "1.11.0",
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % "1.11.0",
  "com.badlogicgames.gdx" % "gdx-platform" %  "1.11.0" classifier "natives-desktop"
)

//"org.scala-lang:scala-library:$scalaVersion"
//api "com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion"
//api "com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop"
//api "com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop"
//api "com.badlogicgames.gdx-controllers:gdx-controllers-desktop:$gdxControllersVersion"
