package starfish.aplha.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, GL20, Texture}
import com.badlogic.gdx.graphics.g2d.{Batch, SpriteBatch}

import scala.collection.mutable

class Rendered(val batch: SpriteBatch) {

  def drawEntity(e: Entity, batch: Batch, parentAlpha: Float): Unit = {
    e.draw(batch, parentAlpha)
    val c: Color = e.getColor
    batch.setColor(c.r, c.g, c.b, c.a)
    if (true) {
      batch.draw(
        e.renderEntity.textureRegion,
        e.getX, e.getY,
        e.getOriginX, e.getOriginY,
        e.getWidth, e.getHeight,
        e.getScaleX, e.getScaleY,
        e.getRotation)
    }
  }

  def drawEntity1(e: Entity, batch: Batch, parentAlpha: Float): Unit = {
    batch.draw(e.renderEntity.textureRegion.getTexture,e.getX, e.getY,e.getOriginX, e.getOriginY)
//    batch.draw(e.renderEntity.textureRegion.getTexture,e.getX, e.getY)
  }

  def render(world: World): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin()
    //    world.entities.values.filter(_.isVisible).toList.sortBy(_.layer).foreach(e =>
    //      batch.draw(textureMap.get(e.id).get, e.rectangle.x, e.rectangle.y))

    world.entities.values.filter(_.isVisible).toList.sortBy(_.layer).foreach(e => drawEntity(e, batch, 0.5F))
    batch.end()
  }

}
