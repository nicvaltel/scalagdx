package starfish.beta.engine

import com.badlogic.gdx.graphics.g2d.{Animation, TextureRegion}
import com.badlogic.gdx.math.{MathUtils, Rectangle, Vector2}
import com.badlogic.gdx.scenes.scene2d.{Actor, Stage}

class Entity(val id: EntityId, val rectangle: Rectangle, s: Stage, isVisible: Boolean, val layer: Int) extends Actor() {

  val renderEntity: RenderEntity = new RenderEntity
  var elapsedTime: Float = 0
  private var animationPaused: Boolean = false
  private var velocityVec : Vector2 = new Vector2(0,0)
  private var accelerationVec : Vector2 = new Vector2(0,0)
  private var privateAcceleration : Float = 0
  private var privateMaxSpeed: Float = 1000
  private var privateDeceleration: Float = 0


  setVisible(isVisible)
  setAllSizesFromRect()
  s.addActor(this)

  private def setAllSizesFromRect():Unit = {
    setPosition(rectangle.x, rectangle.y)
    setSize(rectangle.getWidth, rectangle.getHeight)
    setOrigin(rectangle.getWidth / 2, rectangle.getHeight / 2)
  }

  def setAnimation(animation: Animation[TextureRegion]): Unit = {
    if (this.renderEntity.animation == null) {
      this.renderEntity.animation = animation
      val tr: TextureRegion = animation.getKeyFrame(0)
      val w: Float = tr.getRegionWidth
      val h: Float = tr.getRegionHeight
      setSize(w, h)
      setOrigin(w / 2, h / 2)
    }
  }

  def setAnimationPaused(paused:Boolean):Unit ={
    animationPaused = paused
  }

  def isAnimationFinished(): Boolean = {
    renderEntity.animation.isAnimationFinished(elapsedTime)
  }


  override def moveBy(x: Float, y: Float): Unit = {
    super.moveBy(x, y)
    rectangle.setPosition(getX, getY)
  }

  def overlaps(other: Entity): Boolean = this.rectangle.overlaps(other.rectangle)

  override def act(dt:Float):Unit ={
    super.act(dt)
    if(!animationPaused) elapsedTime += dt
  }

  def speed_=(speed : Float) {
    if (velocityVec.len() == 0)
      velocityVec.set(speed,0)
    else
      velocityVec.setLength(speed)
  }

  def speed: Float = velocityVec.len


  def motionAngle_=(angle: Float): Unit = {
    velocityVec.setAngleDeg(angle)
  }

  def motionAngle: Float = velocityVec.angleDeg()

  def isMoving: Boolean = velocityVec.len > 0

  def acceleration_=(acc : Float): Unit = {
    privateAcceleration = acc
  }

  def accelerateAtAngle(angle: Float): Unit = {
    accelerationVec.add(new Vector2(privateAcceleration,0).setAngleDeg(angle))
  }

  def accelerateForward() : Unit = accelerateAtAngle(getRotation)


  def maxSpeed_=(ms: Float) {privateMaxSpeed = ms}

  def deceleration_=(dec:Float) {privateDeceleration = dec}

  def applyPhysics(dt: Float): Unit = {
    velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt)

    val deltaSpeed =
      if (accelerationVec.len == 0) -1 * privateDeceleration * dt
      else 0

    speed = MathUtils.clamp(speed + deltaSpeed,0, privateMaxSpeed)

    moveBy(velocityVec.x * dt, velocityVec.y * dt)

    accelerationVec.set(0,0)
  }

}


