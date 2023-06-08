package starfish.aplha

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.{Game, Gdx}
import com.badlogic.gdx.graphics.{GL20, Texture}
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle

class StarfishCollectorAlpha extends Game{
  private var batch: SpriteBatch = _

  private var turtleTexture: Texture = _
  private var turtleX: Float = _
  private var turtleY: Float = _
  private var turtleRectangle: Rectangle = _

  private var starfishTexture: Texture = _
  private var starfishX: Float = _
  private var starfishY: Float = _
  private var starfishRectangle: Rectangle = _

  private var oceanTexture: Texture = _
  private var winMessageTexture: Texture = _

  private var win: Boolean = _

  override def create(): Unit = {
    batch = new SpriteBatch()

    turtleTexture = new Texture("turtle-1.png")
    turtleX = 20
    turtleY = 20


    turtleRectangle = new Rectangle(turtleX, turtleY, turtleTexture.getWidth, turtleTexture.getHeight)

    starfishTexture = new Texture("starfish.png")
    starfishX = 380
    starfishY = 380
    starfishRectangle = new Rectangle(starfishX,starfishY,starfishTexture.getWidth, starfishTexture.getWidth)

    oceanTexture = new Texture("water.jpg")
    winMessageTexture = new Texture("you-win.png")

    win = false
  }

  override def render(): Unit = {
    if(Gdx.input.isKeyPressed(Keys.LEFT)) turtleX -= 1
    if(Gdx.input.isKeyPressed(Keys.RIGHT)) turtleX += 1
    if(Gdx.input.isKeyPressed(Keys.UP)) turtleY += 1
    if(Gdx.input.isKeyPressed(Keys.DOWN)) turtleY -= 1

    turtleRectangle.setPosition(turtleX, turtleY)

    if(turtleRectangle.overlaps(starfishRectangle)) win = true

    Gdx.gl.glClearColor(0,0,0,1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin()
    batch.draw(oceanTexture,0,0)
    if (!win)
      batch.draw(starfishTexture, starfishX, starfishY)
    batch.draw(turtleTexture,turtleX,turtleY)
    if(win)
      batch.draw(winMessageTexture,180,180)
    batch.end()
  }
}
