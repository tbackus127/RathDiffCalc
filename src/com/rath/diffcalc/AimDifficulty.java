
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

    HitObject lastObject = null;
    final ArrayList<Double> jumpDistances = new ArrayList<Double>();

    // Find average jump distance
    for (HitObject hitObject : b) {

      // If it's an object that requires aiming
      if (lastObject != null && hitObject.getType() != HitObjectType.SPINNER) {

        // Calculate distance between last and this object
        final CircleDelta cDelta = new CircleDelta(hitObject, lastObject);
        final double jumpDist = cDelta.getDistance();
        jumpDistances.add(jumpDist);

      }

      lastObject = hitObject;
    }

    for (double objDist : jumpDistances) {

      // Calculate a difficulty for this jump
      final double jumpDiff = Math.pow(objDist, JUMP_WEIGHT)
          * Math.pow(circleSize + 1, CS_WEIGHT);
      System.out.println("Jump diff:" + jumpDiff);

    }
    return 0;
  }

  private static double calcAverage(ArrayList<Double> list) {
    double total = 0;
    for (double d : list) {
      total += d;
    }
    return total / list.size();
  }
}
