package starfish.beta.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.{Batch, SpriteBatch}
import com.badlogic.gdx.graphics.{Color, GL20}

class Renderer(val batch: SpriteBatch) {

  def drawEntity(e: Entity, batch: Batch, parentAlpha: Float): Unit = {
    e.draw(batch, parentAlpha)
    val c: Color = e.getColor
    batch.setColor(c.r, c.g, c.b, c.a)
    if (e.renderEntity.animation != null && e.isVisible) {
      batch.draw(
        e.renderEntity.animation.getKeyFrame(e.elapsedTime),
        e.getX, e.getY,
        e.getOriginX, e.getOriginY,
        e.getWidth, e.getHeight,
        e.getScaleX, e.getScaleY,
        e.getRotation)
    }
  }

  def render(world: World): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin()
    world.entities.values.filter(_.isVisible).toList.sortBy(_.layer).foreach(e => drawEntity(e, batch, 0.5F))
    batch.end()
  }

}
