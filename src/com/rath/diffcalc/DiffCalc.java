
package com.rath.diffcalc;

import java.io.File;
import java.io.FileNotFoundException;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.MapParser;

public class DiffCalc {

  private final File osuFile;

  private final DifficultyVector diff;

  private Beatmap beatmap = null;

  public DiffCalc(String osuFile) {
    this.osuFile = new File(osuFile);
    try {
      this.beatmap = MapParser.parse(this.osuFile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    this.diff = new DifficultyVector(this.beatmap);
  }
  
  public DifficultyVector getDiff() {
    return diff;
  }

  @Override
  public String toString() {
    return "RathCalc: " + this.beatmap.getTitle();
  }

}
