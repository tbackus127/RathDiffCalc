
package com.rath.diffcalc;

import com.rath.beatmap.Coord;
import com.rath.beatmap.HitObject;

public class CircleDelta {

  private final Coord objPosA;
  private final Coord objPosB;
  private final int timeA;
  private final int timeB;
  private final double dist;
  private final double angle;
  private final double jumpSpeed;

  public CircleDelta(HitObject a, HitObject b) {
    this.objPosA = a.getPos();
    this.objPosB = b.getPos();
    this.timeA = a.getOffset();
    this.timeB = b.getOffset();
    this.dist = Coord.calcDistance(this.objPosA, this.objPosB);
    this.angle = Coord.calcAngle(this.objPosA, this.objPosB);
    this.jumpSpeed = calcJumpSpeed();
  }

  private double calcJumpSpeed() {
    final int dt = this.timeB - this.timeA;
    if (dt == 0) return Double.POSITIVE_INFINITY;
    return Math.abs(this.dist / dt);
  }

  /**
   * Gets the distance between two HitObjects.
   * 
   * @return the distance as a double.
   */
  public final double getDistance() {
    return dist;
  }

  /**
   * Gets the angle between the two HitObjects, in radians.
   * 
   * @return the angle as a double.
   */
  public final double getAngle() {
    return angle;
  }

  /**
   * Gets the speed of a jump between two HitObjects.
   * 
   * @return the ratio between the distance and delta time of the two
   *         HitObjects.
   */
  public final double getJumpSpeed() {
    return jumpSpeed;
  }

}
