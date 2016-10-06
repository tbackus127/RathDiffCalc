
package com.rath.beatmap;

public class TimingPoint {

  private final int offset;
  private final int msPerBeat;
  private final boolean inherited;

  public TimingPoint(int offset, int msPerBeat, boolean inherited) {
    this.offset = offset;
    this.msPerBeat = msPerBeat;
    this.inherited = inherited;

  }

  public int getOffset() {
    return offset;
  }

  public int getMsPerBeat() {
    return msPerBeat;
  }

  public boolean isInherited() {
    return inherited;
  }

}
