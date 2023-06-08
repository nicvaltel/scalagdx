package starfish.aplha.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Rendered(val batch: SpriteBatch) {

  def render(world: World): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin()
    world.entities.values.filter(_.isVisible).toList.sortBy(_.layer).foreach(e => batch.draw(e.texture, e.x, e.y))
    batch.end()
  }

}
