package starfish.aplha.starfish


import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import starfish.aplha.engine.{Entity, EntityId, World}

import scala.collection.mutable


class StarfishCollectorWorld(override val entities: mutable.Map[EntityId, Entity]) extends World(entities) {
  private var winFlag: Boolean = false

  private def turtle() = entities.get("turtle").get

  private def starfish() = entities.get("starfish").get

  private def winMsg() = entities.get("win-msg").get


  override def updateWorld(): Unit = {
    if (Gdx.input.isKeyPressed(Keys.LEFT)) turtle().x -= 1
    if (Gdx.input.isKeyPressed(Keys.RIGHT)) turtle().x += 1
    if (Gdx.input.isKeyPressed(Keys.UP)) turtle().y += 1
    if (Gdx.input.isKeyPressed(Keys.DOWN)) turtle().y -= 1

    turtle().rectangle.setPosition(turtle().x, turtle().y)

    if (turtle().rectangle.overlaps(starfish().rectangle)) {
      winFlag = true
      starfish().isVisible = false
      winMsg().isVisible = true
    }
  }

}
