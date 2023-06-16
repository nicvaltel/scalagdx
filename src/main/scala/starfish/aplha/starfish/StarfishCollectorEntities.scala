package starfish.aplha.starfish

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import starfish.aplha.engine.{Entity, RenderEntity}


object StarfishEntityIds {
  val TurtleId = 1
  val StarfishId = 2
  val OceanId = 3
  val WinMsgId = 4
}


class Turtle(x: Float, y: Float) extends Entity(
  StarfishEntityIds.TurtleId,
  new RenderEntity(new TextureRegion(new Texture("turtle-1.png"))),
  new Rectangle(x, y, 100, 93), true, 10) {
  override def act(dt: Float): Unit = {
    super.act(dt)

    if (Gdx.input.isKeyPressed(Keys.LEFT)) this.moveBy(-1, 0)
    if (Gdx.input.isKeyPressed(Keys.RIGHT)) this.moveBy(1, 0)
    if (Gdx.input.isKeyPressed(Keys.UP)) this.moveBy(0, 1)
    if (Gdx.input.isKeyPressed(Keys.DOWN)) this.moveBy(0, -1)
  }

}

class Starfish(x: Float, y: Float) extends Entity(
  StarfishEntityIds.StarfishId,
  new RenderEntity(new TextureRegion(new Texture("starfish.png"))),
  new Rectangle(x, y, 60, 53), true, 10) {
}

class Ocean extends Entity(
  StarfishEntityIds.OceanId,
  new RenderEntity(new TextureRegion(new Texture("water.jpg"))),
  new Rectangle(0, 0, 800, 600), true, 0) {
}

class WinMsg(x: Float, y: Float) extends Entity(
  StarfishEntityIds.WinMsgId,
  new RenderEntity(new TextureRegion(new Texture("you-win.png"))),
  new Rectangle(x, y, 437, 98), false, 100) {
}


