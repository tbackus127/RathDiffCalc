package com.rath.beatmap;


public class HitCircle extends HitObject {
  
  public HitCircle(Coord pos, int offset) {
    super(pos, offset);
    type = HitObjectType.HIT_CIRCLE;
  }
  
  @Override
  public String toString() {
    return "Circle@" + this.pos + ":T=" + this.offset;
  }
}
