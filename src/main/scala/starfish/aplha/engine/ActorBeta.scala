package starfish.aplha.engine

import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.graphics.g2d.{Batch, TextureRegion}
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor

class ActorBeta() extends Actor{
  private var textureRegion : TextureRegion = new TextureRegion()
  private var rectangle: Rectangle = new Rectangle()

  def setTexture(t: Texture): Unit = {
    textureRegion.setRegion(t)
    setSize(t.getWidth, t.getHeight)
    rectangle.setSize(t.getWidth, t.getHeight)
  }

  def getRectangle : Rectangle = {
    rectangle.setPosition(getX, getY)
    rectangle
  }

  def overlaps(other : ActorBeta): Boolean = this.getRectangle.overlaps(other.getRectangle)

  override def draw(batch : Batch, parentAlpha : Float ) : Unit = {
    super.draw(batch, parentAlpha)
    val c: Color = getColor
    batch.setColor(c.r, c.g, c.b, c.a)
    if(isVisible){
      batch.draw(
        textureRegion,
        getX, getY,
        getOriginX, getOriginY,
        getWidth, getHeight,
        getScaleX, getScaleY,
        getRotation)
    }
  }

}
