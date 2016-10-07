
package com.rath.beatmap;

public class TimingPoint {

  private final int offset;
  private final double msPerBeat;
  private final boolean inherited;

  public TimingPoint(int offset, double msPerBeat, boolean inherited) {
    this.offset = offset;
    this.msPerBeat = msPerBeat;
    this.inherited = inherited;

  }

  public int getOffset() {
    return offset;
  }

  public double getMsPerBeat() {
    return msPerBeat;
  }

  public boolean isInherited() {
    return inherited;
  }

}
