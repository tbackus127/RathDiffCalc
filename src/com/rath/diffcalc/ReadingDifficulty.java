
package com.rath.diffcalc;

public class ReadingDifficulty {

  private final double range;
  private final double path;
  private final double timing;

  public ReadingDifficulty(double r, double p, double t) {
    this.range = r;
    this.path = p;
    this.timing = t;
  }

  public double getRange() {
    return range;
  }

  public double getPath() {
    return path;
  }

  public double getTiming() {
    return timing;
  }
}
