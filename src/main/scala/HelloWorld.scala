import com.badlogic.gdx.{ApplicationAdapter, Gdx}
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class HelloWorld extends ApplicationAdapter {
  private var camera: OrthographicCamera = _
  private var batch: SpriteBatch = _

  override def create(): Unit = {
    camera = new OrthographicCamera()
    camera.setToOrtho(false)
    batch = new SpriteBatch()
  }

  override def render(): Unit = {
    Gdx.gl.glClearColor(0.2f, 0.4f, 0.6f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    batch.end()
  }

  override def dispose(): Unit = {
    batch.dispose()
  }
}

