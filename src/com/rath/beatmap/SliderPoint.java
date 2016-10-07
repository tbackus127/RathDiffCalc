
package com.rath.beatmap;

public class SliderPoint extends Coord {

  private final boolean straightCurve;

  public SliderPoint(int x, int y, boolean straightCurve) {
    super(x, y);
    this.straightCurve = straightCurve;
  }

  public boolean isStraightCurve() {
    return straightCurve;
  }

  public boolean equals(SliderPoint other) {
    final int ox = other.getX();
    if (this.getX() == ox) return false;

    final int oy = other.getY();
    if (this.getY() == oy) return false;
    
    return this.straightCurve == other.isStraightCurve();
  }
}
