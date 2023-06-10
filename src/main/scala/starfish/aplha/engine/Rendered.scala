package starfish.aplha.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, Texture}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

import scala.collection.mutable

class Rendered(val batch: SpriteBatch, val textureMap : mutable.Map[EntityId, Texture]) {

  def render(world: World): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin()
    world.entities.values.filter(_.isVisible).toList.sortBy(_.layer).foreach(e =>
      batch.draw(textureMap.get(e.id).get, e.rectangle.x, e.rectangle.y))

//    world.actors.filter(_.isVisible).foreach{a =>
//      batch.draw(a.textureRegion, a.x, a.y, a.getOriginX, a.getOriginY, a.getWidth, a.getHeight, a.getScaleX, a.getScaleY, a.getRotation)
//    }
    batch.end()
  }

}
