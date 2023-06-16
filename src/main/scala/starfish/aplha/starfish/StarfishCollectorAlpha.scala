package starfish.aplha.starfish

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import starfish.aplha.engine.{Entity, EntityId, Rendered}

import scala.collection.mutable

class StarfishCollectorAlpha extends Game {
  private var rendered: Rendered = _
  private var world: StarfishCollectorWorld = _

  override def create(): Unit = {
    rendered = new Rendered(new SpriteBatch())

    val entities: mutable.Map[EntityId, Entity] = mutable.Map(
      StarfishEntityIds.TurtleId -> new Turtle(20, 20),
      StarfishEntityIds.StarfishId -> new Starfish(380, 380),
      StarfishEntityIds.OceanId -> new Ocean(),
      StarfishEntityIds.WinMsgId -> new WinMsg(180, 180))

    world = new StarfishCollectorWorld(entities)
  }

  override def render(): Unit = {
    world.updateWorld(0F)
    rendered.render(world)
  }
}
