import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}
import starfish.aplha.starfish.StarfishCollectorAlpha
import cats.effect._

object LauncherStarfishAlpha extends IOApp{

  //  run with java-17
  override def run(args: List[String]): IO[ExitCode] = {
    val config = new Lwjgl3ApplicationConfiguration()
    config.setTitle("StarfishCollectorAlpha")
    config.setWindowedMode(800,600)
    config.setForegroundFPS(60)
    new Lwjgl3Application(new StarfishCollectorAlpha, config)
    IO {ExitCode.Success}
  }
}


