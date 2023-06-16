package starfish.beta.starfish

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.{Action, Stage}
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import starfish.beta.engine.{Entity, LoadAnimation, RenderEntity}


object StarfishEntityIds {
  val TurtleId = 1
  val StarfishId = 2
  val OceanId = 3
  val WinMsgId = 4
  val WhirlpoolId = 5
}

object EntityActions {
  val spin30: Action = Actions.rotateBy(30, 1)
  val spinForever30: Action = Actions.forever(spin30)

  val spin: Action = Actions.rotateBy(180, 2)
  val shift: Action = Actions.moveBy(50, 0, 1)
  val spinTwice: Action = Actions.repeat(2, spin)
  val spinForever: Action = Actions.forever(spin)
}

class Turtle(x: Float, y: Float, s: Stage) extends Entity(
  StarfishEntityIds.TurtleId,
  new Rectangle(x, y, 100, 93), s, true, 10) {

  acceleration_=(400)
  maxSpeed_=(100)
  deceleration_=(400)

  val fileNames: Array[String] = Array(
    "beta/turtle-1.png",
    "beta/turtle-2.png",
    "beta/turtle-3.png",
    "beta/turtle-4.png",
    "beta/turtle-5.png",
    "beta/turtle-6.png")
  this.setAnimation(LoadAnimation.loadAnimationFromFiles(fileNames, 0.1F, true))

  override def act(dt: Float): Unit = {
    super.act(dt)

    if (Gdx.input.isKeyPressed(Keys.LEFT)) accelerateAtAngle(180)
    if (Gdx.input.isKeyPressed(Keys.RIGHT)) accelerateAtAngle(0)
    if (Gdx.input.isKeyPressed(Keys.UP)) accelerateAtAngle(90)
    if (Gdx.input.isKeyPressed(Keys.DOWN)) accelerateAtAngle(270)

    applyPhysics(dt)

    setAnimationPaused(!isMoving)

    if(speed > 0 ) setRotation(motionAngle)
  }

}

class Whirlpool(x: Float, y: Float, s: Stage)  extends Entity(
  StarfishEntityIds.WhirlpoolId,
  new Rectangle(x,y,102,64), s, true, 7) {
  this.setAnimation(LoadAnimation.loadAnimationFromSheet("beta/whirlpool.png", 2, 5, 0.1f, false))

  override def act(dt: Float):Unit = {
    super.act(dt)
    if(isAnimationFinished()) remove()
  }
}

class Starfish(x: Float, y: Float, s: Stage) extends Entity(
  StarfishEntityIds.StarfishId,
  new Rectangle(x, y, 60, 53), s, true, 10) {
  this.setAnimation(LoadAnimation.loadTexture("beta/starfish.png"))
  this.addAction(EntityActions.spinForever30)
}

class Ocean(s: Stage) extends Entity(
  StarfishEntityIds.OceanId,
  new Rectangle(0, 0, 800, 600), s, true, 0) {
  this.setAnimation(LoadAnimation.loadTexture("assets/water.jpg"))
}

class WinMsg(x: Float, y: Float, s: Stage) extends Entity(
  StarfishEntityIds.WinMsgId,
  new Rectangle(x, y, 437, 98), s, false, 100) {
  this.setAnimation(LoadAnimation.loadTexture("assets/you-win.png"))
}


