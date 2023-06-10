package starfish.aplha.starfish


import starfish.aplha.engine.{Entity, EntityId, World}

import scala.collection.mutable


class StarfishCollectorWorld(entities: mutable.Map[EntityId, Entity]) extends World(entities) {
  private var winFlag = false

  override def updateWorld(dt: Float): Unit = {

    val turtle = entities.getOrElse(StarfishEntityIds.TurtleId, throw new Exception("ERROR: Turtle is not fount in Entities"))
    val starfish = entities.getOrElse(StarfishEntityIds.StarfishId, throw new Exception("ERROR: Starfish is not fount in Entities"))
    turtle.act(dt)

    if (!winFlag && turtle.overlaps(starfish)) {
      winFlag = true
      starfish.isVisible = false
      val winMsg = entities.getOrElse(StarfishEntityIds.WinMsgId, throw new Exception("ERROR: WinMsg is not fount in Entities"))
      winMsg.isVisible = true
    }
  }
}

