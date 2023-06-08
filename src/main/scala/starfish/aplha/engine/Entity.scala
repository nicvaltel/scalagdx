package starfish.aplha.engine

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle

class Entity(var texture: Texture, var x: Float, var y: Float, var isVisible: Boolean, var layer: Int) {
  var rectangle: Rectangle = new Rectangle(x, y, texture.getWidth, texture.getHeight)
}
