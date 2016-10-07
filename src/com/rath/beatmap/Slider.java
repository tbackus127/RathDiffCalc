
package com.rath.beatmap;

import java.util.ArrayList;
import java.util.Arrays;

public class Slider extends HitObject {

  private final SliderType type;
  private final ArrayList<Curve> curves;

  public Slider(Coord pos, int offset, SliderType type, ArrayList<Curve> curves) {
    super(pos, offset);
    this.type = type;
    this.curves = curves;
  }

  @Override
  public String toString() {
    return "Slider@" + this.pos + ":T=" + this.offset + ":Type="
        + this.type + ":\n  " + Arrays.toString(this.curves.toArray());
  }
}
