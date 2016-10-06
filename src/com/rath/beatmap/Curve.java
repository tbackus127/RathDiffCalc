package com.rath.beatmap;


public class Curve extends Coord {

  private final boolean straightCurve;
  
  public Curve(int x, int y, boolean straightCurve) {
    super(x, y);
    this.straightCurve = straightCurve;
  }

  public boolean isStraightCurve() {
    return straightCurve;
  }
}
