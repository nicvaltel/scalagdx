package starfish.aplha.engine

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.scenes.scene2d.Actor

class Entity(val id: EntityId, val renderEntity: RenderEntity, val rectangle: Rectangle, isVisible: Boolean, val layer: Int) extends Actor() {

  setVisible(isVisible)
  setAllSizesFromRect()

  private def setAllSizesFromRect():Unit = {
    setPosition(rectangle.x, rectangle.y)
    setSize(rectangle.getWidth, rectangle.getHeight)
    setOrigin(rectangle.getWidth / 2, rectangle.getHeight / 2)
  }


  def setTexture(t: Texture): Unit = {
    renderEntity.textureRegion.setRegion(t)
    rectangle.setSize(t.getWidth, t.getHeight)
    setAllSizesFromRect()
  }

  override def moveBy(x: Float, y: Float): Unit = {
    super.moveBy(x, y)
    rectangle.setPosition(getX, getY)
  }

  def overlaps(other: Entity): Boolean = this.rectangle.overlaps(other.rectangle)

}


