package starfish.aplha.engine

import com.badlogic.gdx.math.Rectangle

class Entity(val id : EntityId, var rectangle: Rectangle, var isVisible: Boolean, var layer: Int) {

  def setX(x: Float): Unit = rectangle.x = x
  def setY(y: Float): Unit = rectangle.y = y

  def moveBy(dx:Float, dy:Float):Unit = {
    setX(rectangle.x + dx)
    setY(rectangle.y + dy)
  }

  def act(dt: Float):Unit = {}

  def overlaps(other: Entity): Boolean = this.rectangle.overlaps(other.rectangle)

}


