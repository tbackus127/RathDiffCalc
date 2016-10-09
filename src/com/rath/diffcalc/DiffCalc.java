package com.rath.diffcalc;

import java.io.File;
import java.io.FileNotFoundException;

import com.rath.beatmap.Beatmap;
import com.rath.beatmap.HitObject;
import com.rath.beatmap.MapParser;

public class DiffCalc {
  
  private File osuFile;
  private Beatmap beatmap;
  
  public DiffCalc(String osuFile) {
    this.osuFile = new File(osuFile);
    try {
      this.beatmap = MapParser.parse(this.osuFile);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    
    for(HitObject ho : this.beatmap) {
      System.out.println(ho);
    }
  }
  
  
  
}
