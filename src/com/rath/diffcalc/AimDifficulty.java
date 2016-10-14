
package com.rath.diffcalc;

public class AimDifficulty {

  private final double precision;
  private final double speed;
  private final double control;
  private final double stamina;

  public AimDifficulty(double p, double s, double c, double t) {
    this.precision = p;
    this.speed = s;
    this.control = c;
    this.stamina = t;
  }

  public double getPrecision() {
    return precision;
  }

  public double getSpeed() {
    return speed;
  }

  public double getControl() {
    return control;
  }

  public double getStamina() {
    return stamina;
  }
}
