package starfish.beta.starfish

import com.badlogic.gdx.{Game, Gdx}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import starfish.beta.engine.{Entity, EntityId, Renderer}

import scala.collection.mutable

class StarfishCollectorBeta extends Game {
  private var rendered: Renderer = _
  private var world: StarfishCollectorWorld = _
  private var mainStage: Stage = _

  override def create(): Unit = {
    rendered = new Renderer(new SpriteBatch())

    mainStage = new Stage

    val entities: mutable.Map[EntityId, Entity] = mutable.Map(
      StarfishEntityIds.TurtleId -> new Turtle(20, 20, mainStage),
      StarfishEntityIds.StarfishId -> new Starfish(380, 380, mainStage),
      StarfishEntityIds.OceanId -> new Ocean(mainStage),
      StarfishEntityIds.WinMsgId -> new WinMsg(180, 180, mainStage)
//      StarfishEntityIds.WhirlpoolId -> new Whirlpool(100,100, mainStage)

    )

    world = new StarfishCollectorWorld(entities)
  }

  override def render(): Unit = {
    world.updateWorld(Gdx.graphics.getDeltaTime)
    rendered.render(world)
  }
}
