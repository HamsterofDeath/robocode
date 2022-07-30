package hod.robo

import java.awt.event.{KeyEvent, MouseEvent}

import robocode.{
  AdvancedRobot, BattleEndedEvent, BulletHitBulletEvent, BulletHitEvent,
  BulletMissedEvent, DeathEvent, HitByBulletEvent, HitRobotEvent, HitWallEvent, RobotDeathEvent,
  RoundEndedEvent, ScannedRobotEvent, SkippedTurnEvent, WinEvent
}

class MyFirstRobot extends AdvancedRobot {
  override def run(): Unit = {
    while (true) {
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
  override def onMouseMoved(e: MouseEvent): Unit =
    super.onMouseMoved(e)
}
