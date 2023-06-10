package starfish.aplha.starfish

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, TextureRegion}
import starfish.aplha.engine.{Entity, EntityId, Rendered, World}

import scala.collection.mutable

class StarfishCollectorAlpha extends Game {
  private var rendered: Rendered = _
  private var world: StarfishCollectorWorld = _

  override def create(): Unit = {
    val textureMap: mutable.Map[EntityId, Texture] = mutable.Map(
      StarfishEntityIds.TurtleId -> new Texture("turtle-1.png"),
      StarfishEntityIds.StarfishId -> new Texture("starfish.png"),
      StarfishEntityIds.OceanId -> new Texture("water.jpg"),
      StarfishEntityIds.WinMsgId -> new Texture("you-win.png"))


    rendered = new Rendered(new SpriteBatch(), textureMap)

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
