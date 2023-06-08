package starfish.aplha.starfish

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import starfish.aplha.engine.{Entity, Rendered}

import scala.collection.mutable

class StarfishCollectorAlpha extends Game {
  private var rendered: Rendered = _
  private var world: StarfishCollectorWorld = _

  override def create(): Unit = {
    rendered = new Rendered(new SpriteBatch())

    world = new StarfishCollectorWorld(mutable.Map(
      "turtle" -> new Entity(new Texture("turtle-1.png"), 20, 20, true, 10),
      "starfish" -> new Entity(new Texture("starfish.png"), 380, 380, true, 10),
      "ocean" -> new Entity(new Texture("water.jpg"), 0, 0, true, 0),
      "win-msg" -> new Entity(new Texture("you-win.png"), 180, 180, false, 100)))
  }

  override def render(): Unit = {
    world.updateWorld()
    rendered.render(world)
  }
}
