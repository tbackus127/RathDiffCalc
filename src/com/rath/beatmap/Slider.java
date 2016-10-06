package com.rath.beatmap;

import java.util.ArrayList;
import java.util.Arrays;


public class Slider extends HitObject {

  private final ArrayList<Curve> curves;
  
  public Slider(Coord pos, int offset, ArrayList<Curve> curves) {
    super(pos, offset);
    this.curves = curves;
  }

  @Override
  public String toString() {
    return "Slider@" + this.pos + ":T=" + this.offset + ":\n  " + Arrays.toString(this.curves.toArray());
  }
}
