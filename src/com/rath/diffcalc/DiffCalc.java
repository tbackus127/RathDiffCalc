
package com.rath.diffcalc;

import java.io.File;
import java.io.FileNotFoundException;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.HitObject;
import com.rath.beatmap.MapParser;

public class DiffCalc {

  private final File osuFile;
  private final AimDifficulty aim;
  private final TimingDifficulty timing;
  private final ReadingDifficulty reading;

  private Beatmap beatmap = null;

  public DiffCalc(String osuFile) {
    this.osuFile = new File(osuFile);
    try {
      this.beatmap = MapParser.parse(this.osuFile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    this.aim = calcAimDiff();
    this.timing = calcTimingDiff();
    this.reading = calcReadingDiff();
  }

  private AimDifficulty calcAimDiff() {
    double precision = AimDifficulty.calcPrecision(this.beatmap); 
    double speed = 0;
    double control = 0;
    double stamina = 0;
    return new AimDifficulty(precision, speed, control, stamina);
  }

  private TimingDifficulty calcTimingDiff() {
    // TODO: Timing difficulty
    return null;
  }

  private ReadingDifficulty calcReadingDiff() {
    // TODO: Reading difficulty
    return null;
  }

  public AimDifficulty getAim() {
    return aim;
  }

  public TimingDifficulty getTiming() {
    return timing;
  }

  public ReadingDifficulty getReading() {
    return reading;
  }

  @Override
  public String toString() {
    return "RathCalc: " + this.beatmap.getTitle();
  }

}
