import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object Launcher {

  //  run with java-17
  def main(args: Array[String]): Unit = {
    val config = new Lwjgl3ApplicationConfiguration()
    config.setTitle("Hello, World!")
    config.setWindowedMode(800,60)
    new Lwjgl3Application(new HelloWorld, config)
  }
}

