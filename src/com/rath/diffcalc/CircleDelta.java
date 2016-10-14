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
    if(dt == 0)
      return Double.POSITIVE_INFINITY;
    return this.dist / dt;
  }
  
  
}
