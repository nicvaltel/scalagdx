ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

//appName = "ScalaGDX"
val gdxVersion = "1.11.0"
//roboVMVersion = '2.3.19'
//box2DLightsVersion = '1.5'
//ashleyVersion = '1.7.4'
//aiVersion = '1.8.2'
//gdxControllersVersion = '2.2.1'


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
