package starfish.beta.engine

import com.badlogic.gdx.graphics.g2d.{Animation, TextureRegion}
import com.badlogic.gdx.scenes.scene2d.{Actor, Stage}

class BaseActor private() extends Actor {

  private var animation: Animation[TextureRegion] = _
  private var elapsedTime: Float = 0
  private var animationPaused: Boolean = false

  def this(x: Float, y: Float, s: Stage) = {
    this()
    setPosition(x, y)
    s.addActor(this)
  }

  def setAnimation(animation: Animation[TextureRegion]):Unit = {
    this.animation = animation
    val tr: TextureRegion = animation.getKeyFrame(0)
    val w:Float = tr.getRegionWidth
    val h:Float = tr.getRegionHeight
    setSize(w,h)
    setOrigin(w/2,h/2)
  }

}
