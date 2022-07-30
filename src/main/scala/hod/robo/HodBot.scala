package hod.robo

import java.awt.Point
import java.awt.event.{KeyEvent, MouseEvent}

import robocode.{AdvancedRobot, BattleEndedEvent, BulletHitBulletEvent, BulletHitEvent, BulletMissedEvent, DeathEvent, HitByBulletEvent, HitRobotEvent, HitWallEvent, RobotDeathEvent, RoundEndedEvent, ScannedRobotEvent, SkippedTurnEvent, WinEvent}


class HodBot extends AdvancedRobot {

  var cursor:Point = null
  val controls = Controls(this)
  var buttonDown = false
  
  
  override def run(): Unit = {
    while (true) {
      if (cursor!=null) {
        if (buttonDown) {
          controls.turnTowards(cursor)
        }
        controls.aimAt(cursor)
      }
      setTurnRadarLeft(1)
      execute()
    }
  }
  override def onDeath(event: DeathEvent): Unit =
    super.onDeath(event)
  override def onSkippedTurn(event: SkippedTurnEvent): Unit =
    super.onSkippedTurn(event)
  override def onBulletHit(event: BulletHitEvent): Unit =
    super.onBulletHit(event)
  override def onBulletHitBullet(event: BulletHitBulletEvent): Unit =
    super.onBulletHitBullet(event)
  override def onBulletMissed(event: BulletMissedEvent): Unit =
    super.onBulletMissed(event)
  override def onHitByBullet(event: HitByBulletEvent): Unit =
    super.onHitByBullet(event)

  override def onHitRobot(event: HitRobotEvent): Unit =
    super.onHitRobot(event)
  override def onHitWall(event: HitWallEvent): Unit =
    super.onHitWall(event)
  override def onRobotDeath(event: RobotDeathEvent): Unit =
    super.onRobotDeath(event)
  override def onScannedRobot(event: ScannedRobotEvent): Unit =
    super.onScannedRobot(event)
  override def onWin(event: WinEvent): Unit =
    super.onWin(event)
  override def onRoundEnded(event: RoundEndedEvent): Unit =
    super.onRoundEnded(event)
  override def onBattleEnded(event: BattleEndedEvent): Unit =
    super.onBattleEnded(event)
  override def onKeyPressed(e: KeyEvent): Unit =
    super.onKeyPressed(e)
  override def onKeyReleased(e: KeyEvent): Unit =
    super.onKeyReleased(e)
  override def onMousePressed(e: MouseEvent): Unit =
    super.onMousePressed(e)
    buttonDown = true
  override def onMouseMoved(e: MouseEvent): Unit =
    super.onMouseMoved(e)
    cursor = e.getPoint

  override def onMouseDragged(e: MouseEvent): Unit =
    super.onMouseDragged(e)
    cursor = e.getPoint
  override def onMouseReleased(e: MouseEvent): Unit =
    super.onMouseReleased(e)
    buttonDown = false
}
