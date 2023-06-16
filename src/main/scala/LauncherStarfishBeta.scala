import cats.effect._
import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}
import starfish.beta.starfish.StarfishCollectorBeta

object LauncherStarfishBeta extends IOApp {

  //  run with java-17
  override def run(args: List[String]): IO[ExitCode] = {
    val config = new Lwjgl3ApplicationConfiguration()
    config.setTitle("StarfishCollectorBeta")
    config.setWindowedMode(800, 600)
    config.setForegroundFPS(60)
    new Lwjgl3Application(new StarfishCollectorBeta, config)
    IO {
      ExitCode.Success
    }
  }
}


