package com.rath.beatmap;


public class Spinner extends HitObject {

  private final int endTime;
  
  public Spinner(int offset, int endTime) {
    super(new Coord(0, 0), offset);
    this.endTime = endTime;
  }

  @Override
  public String toString() {
    return "Spinner:T=" + this.offset + "-" + this.endTime;
  }

  @Override
  public HitObjectType getType() {
    return HitObjectType.SPINNER;
  }
}
