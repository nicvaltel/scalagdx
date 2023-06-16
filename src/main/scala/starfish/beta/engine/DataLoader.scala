package starfish.beta.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter
import com.badlogic.gdx.graphics.g2d.{Animation, TextureRegion}

class DataLoader {

}


object LoadAnimation{

  def loadAnimationFromFiles(fileNames: Array[String], frameDuration: Float, loop: Boolean): Animation[TextureRegion] = {
    val fileCount: Int = fileNames.length
    val textureArray: com.badlogic.gdx.utils.Array[TextureRegion] = new com.badlogic.gdx.utils.Array[TextureRegion]
    fileNames.toList.foreach(fileName => {
      val texture: Texture = new Texture(fileName)
      texture.setFilter(TextureFilter.Linear, TextureFilter.Linear)
      textureArray.add(new TextureRegion(texture))
    })

    val anim: Animation[TextureRegion] = new Animation[TextureRegion](frameDuration, textureArray)
    anim.setPlayMode(if (loop) Animation.PlayMode.LOOP else Animation.PlayMode.NORMAL)
    anim
  }

  def loadAnimationFromSheet(fileName: String, rows: Int, cols: Int, frameDuration: Float, loop: Boolean): Animation[TextureRegion] = {
    val texture: Texture= new Texture(Gdx.files.internal(fileName), true)
    texture.setFilter(TextureFilter.Linear, TextureFilter.Linear)
    val frameWidth: Int = texture.getWidth / cols
    val frameHeight: Int = texture.getHeight/ rows
    val temp1: Array[Array[TextureRegion]] = TextureRegion.split(texture,frameWidth,frameHeight)
    val textureArray: com.badlogic.gdx.utils.Array[TextureRegion] = new com.badlogic.gdx.utils.Array[TextureRegion]
    for(r <- 0 until rows){ for (c <- 0 until cols){ textureArray.add(temp1(r)(c)) } }

    val anim: Animation[TextureRegion] = new Animation[TextureRegion](frameDuration, textureArray)
    anim.setPlayMode(if (loop) Animation.PlayMode.LOOP else Animation.PlayMode.NORMAL)

    anim
  }

  def loadTexture(fileName: String ): Animation[TextureRegion] = {
    val fileNames: Array[String] = new Array[String](1)
    fileNames(0) = fileName
    loadAnimationFromFiles(fileNames,1, true)
  }
}
