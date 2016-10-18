
package com.rath.diffcalc;

import java.util.ArrayList;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.HitObject;
import com.rath.beatmap.HitObjectType;

public class AimDifficulty {

  private static final double JUMP_WEIGHT = 1.05D;
  private static final double CS_WEIGHT = 1.25D;

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

  public static final double calcPrecision(Beatmap b) {
    final double circleSize = b.getCircleSize();
    final double approachRate = b.getApproachRate();
    final double averageJumpDiff;

    HitObject lastObject = null;
    final ArrayList<Double> jumpSpeeds = new ArrayList<Double>();

    // Find average jump distance
    for (HitObject hitObject : b) {

      // If it's an object that requires aiming
      if (lastObject != null && hitObject.getType() != HitObjectType.SPINNER) {

        // Calculate distance between last and this object
        final CircleDelta cDelta = new CircleDelta(lastObject, hitObject);
        final double jumpSpd = cDelta.getJumpSpeed();
        jumpSpeeds.add(jumpSpd);

      }

      lastObject = hitObject;
    }

    averageJumpDiff = calcAverage(jumpSpeeds);

    // Iterate through jump distances
    for (double jSpd : jumpSpeeds) {

      // Calculate a difficulty for this jump
      final double jumpDiff = Math.pow(jSpd, JUMP_WEIGHT)
          * Math.pow(circleSize + 1, CS_WEIGHT);
      System.out.println("Jump diff:" + jumpDiff);

    }
    return 0;
  }

  private static final double calcAverage(ArrayList<Double> list) {
    double total = 0;
    for (double d : list) {
      total += d;
    }
    return total / list.size();
  }

  public static double calcSpeed(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcControl(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static double calcStamina(Beatmap b) {
    // TODO Auto-generated method stub
    return 0;
  }
}
