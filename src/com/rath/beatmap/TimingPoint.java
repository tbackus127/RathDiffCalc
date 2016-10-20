
package com.rath.beatmap;

public class TimingPoint {

  private final int offset;
  private final double msPerBeat;
  private final boolean inherited;
  private final boolean isKiai;

  public TimingPoint(int offset, double msPerBeat, boolean inherited, boolean isKiai) {
    this.offset = offset;
    this.msPerBeat = msPerBeat;
    this.inherited = inherited;
    this.isKiai = isKiai;

  }

  public int getOffset() {
    return offset;
  }

  public double getMsPerBeat() {
    return msPerBeat;
  }

  public boolean isKiai() {
    return isKiai;
  }

  public boolean isInherited() {
    return inherited;
  }
  
  @Override
  public String toString() {
    return "TPnt: T=" + this.offset + ", " + this.msPerBeat + "ms/b, Inh=" + this.inherited;
  }

}
