import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}
import starfish.aplha.StarfishCollectorAlpha

object LauncherStarfishAlpha {

  //  run with java-17
  def main(args: Array[String]): Unit = {
    val config = new Lwjgl3ApplicationConfiguration()
    config.setTitle("StarfishCollectorAlpha")
    config.setWindowedMode(800,600)
    config.setForegroundFPS(60)
    new Lwjgl3Application(new StarfishCollectorAlpha, config)
  }
}

