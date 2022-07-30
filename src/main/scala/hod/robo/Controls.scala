package hod.robo

import java.awt.Point

import robocode.AdvancedRobot

class Controls(val robot: AdvancedRobot) {
  def center =
    val x = robot.getX + robot.getWidth / 2
    val y = robot.getY + robot.getHeight / 2
    Point(Math.round(x.toFloat), Math.round(y.toFloat))

  def angleRequiredFor(p: Point) =
    val ownLocation = center
    val isLeft      = ownLocation.x < p.x
    val isTop       = ownLocation.y < p.y
    val yDiff       = math.abs(ownLocation.y - p.y)
    val xDiff       = math.abs(ownLocation.x - p.x)
    val hyp         = Math.sqrt(xDiff * xDiff + yDiff * yDiff)
    val angle       = 90 - math.toDegrees(math.asin(yDiff / hyp))
    360 - ((isLeft, isTop) match {
      case (false, true) => angle
      case (false, false) => (90 - angle) + 90
      case (true, false) => angle + 180
      case (true, true) => (90 - angle) + 270
    })

  def getTurnRequiredToReach(p: Point, currentRotation: Double) = {
    val simpleRotation   = angleRequiredFor(p)-currentRotation
    if(simpleRotation<=180 && simpleRotation>= -180)
      simpleRotation
    else
      if (simpleRotation > 180) (180 - simpleRotation) else 360 - (-simpleRotation)
  }

  def aimAt(p: Point) = {
    robot.setTurnGunRightRadians(calculateNecessaryRightTurnDegrees(p, robot.getGunHeadingRadians))
  }
  def turnTowards(p: Point) = {
    robot.setTurnRightRadians(calculateNecessaryRightTurnDegrees(p, robot.getHeadingRadians))
  }
  def pointScannerAt(p: Point) = {
    robot.setTurnRadarRightRadians(calculateNecessaryRightTurnDegrees(p, robot.getRadarHeadingRadians))
  }

  private def calculateNecessaryRightTurnDegrees(p: Point, radians: Double) = {
    val headingDegrees = math.toDegrees(radians)
    val turnDegrees    = getTurnRequiredToReach(p, headingDegrees)
    val turn           = Math.toRadians(turnDegrees)
    turn
  }
}
